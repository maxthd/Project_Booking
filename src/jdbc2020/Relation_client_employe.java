package jdbc2020;

import java.sql.SQLException;

public class Relation_client_employe {
    private int id_client_employe;
    private int fk_client;
    private int fk_employe;

    /***
     * Constructeur Relation client_employe
     * @param index
     * @param maconnexion
     * @throws SQLException
     */
    public Relation_client_employe(int index, Connexion maconnexion) throws SQLException {
        id_client_employe=index;
        fk_client= maconnexion.fill_int_param("SELECT fk_client FROM Relation_client_employe " +
                "WHERE id_client_employe = ?", id_client_employe);

        fk_employe= maconnexion.fill_int_param("SELECT fk_employe FROM Relation_client_employe " +
                "WHERE id_client_employe = ?", id_client_employe);

        //Afficher_client_employe();
    }


    /***
     * Afficher les attributs de Client_employe (sur la console)
     */
    public void Afficher_client_employe(){
        System.out.println("id_client_employe: "+id_client_employe + "\t\tfk_client: "+fk_client +"\t\tfk_employe: "+fk_employe);
        System.out.println("--------------------------------");
    }

















    /***LES GETTERS ET LES SETTERS*/

    public int getId_client_employe() {
        return id_client_employe;
    }

    public void setId_client_employe(int id_client_employe) {
        this.id_client_employe = id_client_employe;
    }

    public int getFk_client() {
        return fk_client;
    }

    public void setFk_client(int fk_client) {
        this.fk_client = fk_client;
    }

    public int getFk_employe() {
        return fk_employe;
    }

    public void setFk_employe(int fk_employe) {
        this.fk_employe = fk_employe;
    }
}
