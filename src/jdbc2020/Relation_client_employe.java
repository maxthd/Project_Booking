package jdbc2020;

import java.sql.SQLException;

public class Relation_client_employe {
    private int id_client_employe;
    private int fk_client;
    private int fk_employe;

    public Relation_client_employe(int index, Connexion maconnexion) throws SQLException {
        id_client_employe=index;
        fk_client= maconnexion.fill_int_param("SELECT fk_client FROM Relation_client_employe " +
                "WHERE id_client_employe = ?", id_client_employe);

        fk_employe= maconnexion.fill_int_param("SELECT fk_employe FROM Relation_client_employe " +
                "WHERE id_client_employe = ?", id_client_employe);

        Afficher_client_employe();
    }


    public void Afficher_client_employe(){
        System.out.println("-------------------------");
        System.out.println("id_client_employe: "+id_client_employe);
        System.out.println("fk_client : "+fk_client);
        System.out.println("fk_employe: "+fk_employe);
        System.out.println("-------------------------");
    }
}
