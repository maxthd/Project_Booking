package Modele;

import jdbc2020.Connexion;

import java.sql.SQLException;

public class Modifier_client {
    private Connexion maconnexion;

    public Modifier_client() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
    }


    public void Update_client(int id_client, String nom, String prenom,
                           String username,
                           String password,
                           int age, double solde,  int membre) throws SQLException {

        maconnexion.executeupdate_client("UPDATE Client SET nom=?, prenom=?, username=?," +
                        "password=?, age=?, solde=?, membre=? "+
                        "WHERE id_client=?", nom, prenom, username, password, age, solde, membre, id_client);
    }

    public void Delete_client(int id_client) throws SQLException {
        maconnexion.executeupdate_param("DELETE FROM Client WHERE id_client=?;", id_client);
    }
}
