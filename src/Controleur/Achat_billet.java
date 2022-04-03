package Controleur;

import Modele.Billet;
import Modele.Client;
import Modele.Connexion;

import java.sql.SQLException;
import java.util.ArrayList;

public class Achat_billet {
    private Connexion maconnexion;
    private ArrayList<Billet> billets = new ArrayList<>();
    private int temp_id_vol;

    /***
     * Constructeur Achat Billet
     * @param id_vol
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Achat_billet(int id_vol) throws SQLException, ClassNotFoundException {
        maconnexion = new Connexion("booking", "root", "");

        temp_id_vol = id_vol;
        ArrayList<Integer> list_id;

        list_id = maconnexion.fill_array_param("SELECT id_billet FROM Billet WHERE fk_vol= ?", id_vol);
        for (int i = 0; i < list_id.size(); i++) {
            if (billet_dispo(list_id.get(i)) == true) {
                Billet billet = new Billet(list_id.get(i), maconnexion);
                billets.add(billet);
            }
        }
    }


    /***
     * Cette méthode fait les vérifications nécessaires
     * puis permet au client d'acheter le billet
     * @param type_billet
     * @param id_client
     * @throws SQLException
     */
    public void Acheter_billet(int type_billet, int id_client) throws SQLException {

        int id_billet = maconnexion.fill_int_param_double("SELECT id_billet FROM Billet WHERE " +
                "type_billet=? AND fk_vol=?", type_billet, temp_id_vol);

        if (Valid_idbillet(id_billet) == true) {
            //VERIFIEE SI LE CLIENT EST MEMBRE. SI OUI, APPLIQUEZ LA REDUCTION ET VOIR SI IL A ASSEZ POUR ACHETER LE BILLET.
            double reduction, solde, cout, prix_final;

            reduction = reduction(id_billet, id_client);
            Client client = new Client(id_client, maconnexion);
            Billet billet = new Billet(id_billet, maconnexion);


            solde = client.getSolde();
            cout = billet.getCout();

            prix_final = cout - reduction;
            if (prix_final <= 0)
                prix_final = 0;

            double new_solde = solde - prix_final;

            if (new_solde >= 0) {

                //  Si oui, RETIRER L ARGENT DU SOLDE DU CLIENT
                maconnexion.executeupdate_client("UPDATE Client SET nom=?, prenom=?, username=?," +
                                "password=?, age=?, solde=?, membre=? " +
                                "WHERE id_client=?", client.getNom(), client.getPrenom(), client.getUsername(),
                        client.getPassword(), client.getAge(), new_solde, client.getMembre(), id_client);


                //ENLEVER UNE PLACE ET RENDRE LE INT BILLET DISPO FAUX SI ON N A PLUS DE PLACE
                maconnexion.executeupdate_billet("UPDATE Billet SET nombre_billet=? WHERE id_billet=?",
                        billet.getNombre_billet() - 1, billet.getId_billet());

                if (billet.getNombre_billet() - 1 <= 0)
                    maconnexion.executeupdate_billet("UPDATE Billet SET billet_dispo=? WHERE id_billet=?",
                            0, billet.getId_billet());


                //AJOUTER UNE RESERVATION AVEC L'ID du client et l'ID du vol
                maconnexion.executeinsert_reservation("INSERT INTO Reservation(fk_vol, fk_client) VALUES " +
                        "(?, ?);", billet.getFk_vol(), client.getId_client());

                //ENVOYER UN MAIL POUR CONFIRMER LE BILLET ET SON TYPE
                String message = message(billet);

                 SendEmail.send("projetbooking55@gmail.com", "Projetbooking55.",
                 client.getUsername(), "Confirmation billet", message);

                //METTRE LE VOL EN INDISPONIBLE SI C'ETAIT LE DERNIER BILLET
                if (Vol_encoredispo() == false)
                    maconnexion.executeupdate_param("UPDATE Vol SET vol_dispo=0 WHERE id_vol=?", temp_id_vol);


            } else
                System.out.println("Solde insuffisant");
        } else
            System.out.println("id_vol et id_billet ne sont pas concordant");
    }


    /***
     * Boolean pour savoir si le billet est encore disponible
     * @param id_billet
     * @return
     * @throws SQLException
     */
    public boolean billet_dispo(int id_billet) throws SQLException {
        int temp;
        temp = maconnexion.fill_int_param("SELECT billet_dispo FROM Billet WHERE id_billet = ?", id_billet);

        if (temp == 0)
            return false;
        if (temp == 1)
            return true;

        return false;
    }


    /***
     * Retourne la reduction selon le role du client (membre ou non)
     * @param id_billet
     * @param id_client
     * @return
     * @throws SQLException
     */
    public double reduction(int id_billet, int id_client) throws SQLException {
        int client_membre;
        double reduction = 0;
        client_membre = maconnexion.fill_int_param("SELECT membre FROM Client WHERE id_client=?", id_client);
        if (client_membre == 0)
            reduction = 0;

        if (client_membre == 1)
            reduction = maconnexion.fill_double_param("SELECT reduction FROM Billet WHERE id_billet=?", id_billet);

        return reduction;
    }


    /***
     * Change le message afficher selon la classe du billet
     * @param billet
     * @return
     */
    public String message(Billet billet) {
        String message = "";

        if (billet.getType_billet() == 1)
            message = "Ce mail confirme votre billet en classe ECONOMIQUE";

        if (billet.getType_billet() == 2)
            message = "Ce mail confirme votre billet en classe AFFAIRE";

        if (billet.getType_billet() == 3)
            message = "Ce mail confirme votre billet en classe PREMIUM";

        return message;
    }


    /***
     * Verifie que le vol est encore dispo
     * @return
     * @throws SQLException
     */
    public boolean Vol_encoredispo() throws SQLException {
        ArrayList<Integer> list_id;
        int temp;

        list_id = maconnexion.fill_array_param("SELECT id_billet FROM Billet WHERE fk_vol= ?", temp_id_vol);
        for (int i = 0; i < list_id.size(); i++) {
            temp = maconnexion.fill_int_param("SELECT billet_dispo FROM Billet WHERE id_billet=?", list_id.get(i));
            if (temp == 1)
                return true;
        }
        return false;
    }


    /***
     * Retourne vrai si l'id_billet existe et est valide
     * @param id_billet
     * @return
     * @throws SQLException
     */
    public boolean Valid_idbillet(int id_billet) throws SQLException {
        int fk_vol = maconnexion.fill_int_param("SELECT fk_vol FROM Billet " +
                "WHERE id_billet=?", id_billet);
        int billet_dispo = maconnexion.fill_int_param("SELECT billet_dispo FROM Billet " +
                "WHERE id_billet=?", id_billet);

        if (fk_vol == temp_id_vol && billet_dispo == 1)
            return true;

        return false;
    }

    public double getsolde_client(int id_client) throws SQLException {
        double solde;
        solde = maconnexion.fill_double_param("SELECT solde FROM Client WHERE id_client=?", id_client);
        return solde;
    }

    public double getcout_original(int type_billet) throws SQLException {
        int id_billet;
        double cout = 0;

        id_billet = maconnexion.fill_int_param_double("SELECT id_billet FROM Billet WHERE " +
                "type_billet=? AND fk_vol=?", type_billet, temp_id_vol);

        if (Valid_idbillet(id_billet) == true) //Ce if est censé etre inutile
            cout = maconnexion.fill_double_param("SELECT cout FROM Billet WHERE id_billet=?", id_billet);
        return cout;
    }


    public double getreduction(int type_billet, int id_client) throws SQLException {
        int id_billet;
        double reduction = 0;

        id_billet = maconnexion.fill_int_param_double("SELECT id_billet FROM Billet WHERE " +
                "type_billet=? AND fk_vol=?", type_billet, temp_id_vol);

        if (Valid_idbillet(id_billet) == true) //Ce if est censé etre inutile
            reduction = reduction(id_billet, id_client);

        return reduction;
    }


    /**
     * GETTERS ET SETTERS
     */
    public ArrayList<Billet> getBillets() {
        return billets;
    }

    public void setBillets(ArrayList<Billet> billets) {
        this.billets = billets;
    }
}
