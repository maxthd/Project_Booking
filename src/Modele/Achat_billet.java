package Modele;

import jdbc2020.Billet;
import jdbc2020.Client;
import jdbc2020.Connexion;

import java.sql.SQLException;
import java.util.ArrayList;

public class Achat_billet {
    private Connexion maconnexion;
    private ArrayList<Billet> billets=new ArrayList<>();
    private int temp_id_vol;

    public Achat_billet(int id_vol) throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");

        temp_id_vol=id_vol;
        ArrayList<Integer> list_id;

        list_id=maconnexion.fill_array_param("SELECT id_billet FROM Billet WHERE fk_vol= ?", id_vol);
        for (int i=0; i<list_id.size(); i++)
        {
            if (billet_dispo(list_id.get(i))==true) {
                Billet billet = new Billet(list_id.get(i), maconnexion);
                billets.add(billet);
            }
        }
    }



    //IL FAUT BLINDER LA SAISIE DES ID POUR QU'ILS NE PUISSENT SAISIR QUE CE QUI EST AFFICHE
    public void Acheter_billet(int id_billet, int id_client) throws SQLException {


        if (Valid_idbillet(id_billet)==true) {
            //VERIFIEE SI LE CLIENT EST MEMBRE. SI OUI, APPLIQUEZ LA REDUCTION ET VOIR SI IL A ASSEZ POUR ACHETER LE BILLET.
            double reduction, solde, cout;

            reduction = reduction(id_billet, id_client);
            Client client = new Client(id_client, maconnexion);
            Billet billet = new Billet(id_billet, maconnexion);


            solde = client.getSolde();
            cout = billet.getCout();

            double new_solde = (solde - (cout - reduction));

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

                /**POUR L INSTANT LE USERNAME N EST PAS UN VRAI GMAIL DONC CA MARCHERA PAS TANT QU ON A PAS MAJ LA BDD
                SendEmail.send("projetbooking55@gmail.com", "Projetbooking55.",
                        client.getUsername(), "Confirmation billet", message);*/


            } else
                System.out.println("Solde insuffisant");
        }
        else
            System.out.println("id_vol et id_billet ne sont pas concordant");
    }





    public boolean billet_dispo(int id_billet) throws SQLException {
        int temp;
        temp=maconnexion.fill_int_param("SELECT billet_dispo FROM Billet WHERE id_billet = ?", id_billet);

        if  (temp==0)
            return false;
        if (temp==1)
            return true;

        return false;
    }

    public double reduction(int id_billet, int id_client) throws SQLException {
        int client_membre;
        double reduction=0;
        client_membre=maconnexion.fill_int_param("SELECT membre FROM Client WHERE id_client=?", id_client);
        if (client_membre==0)
            reduction = 0;

        if (client_membre==1)
            reduction=maconnexion.fill_double_param("SELECT reduction FROM Billet WHERE id_billet=?", id_billet);

        return reduction;
    }


    public String message(Billet billet){
        String message="";

        if (billet.getType_billet()==1)
            message="Ce mail confirme votre billet en classe ECONOMIQUE";

        if (billet.getType_billet()==2)
            message="Ce mail confirme votre billet en classe AFFAIRE";

        if (billet.getType_billet()==3)
            message="Ce mail confirme votre billet en classe PREMIUM";

        return message;
    }





    public boolean Valid_idbillet(int id_billet) throws SQLException {
        int fk_vol= maconnexion.fill_int_param("SELECT fk_vol FROM Billet " +
                "WHERE id_billet=?", id_billet );
        int billet_dispo=maconnexion.fill_int_param("SELECT billet_dispo FROM Billet " +
                "WHERE id_billet=?", id_billet );

        if (fk_vol== temp_id_vol && billet_dispo==1)
            return true;

        return false;
    }


    /**GETTERS ET SETTERS*/
    public ArrayList<Billet> getBillets() {
        return billets;
    }

    public void setBillets(ArrayList<Billet> billets) {
        this.billets = billets;
    }
}
