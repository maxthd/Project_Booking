package Modele;

import jdbc2020.Connexion;

import java.sql.SQLException;

public class Ajout_vol {

    private Connexion maconnexion;


    public Ajout_vol() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
    }


    public void Insert_Vol(int nombre_place, String ville_depart, String ville_arrive,
                      String date_depart, String date_arrive ,
                      String heure_depart, String heure_arrive) throws SQLException {

        maconnexion.executeinsert_vol("INSERT INTO Vol (nombre_place, ville_depart, ville_arrive, " +
                        "date_depart, date_arrive, " +
                        "heure_depart , heure_arrive , vol_dispo) VALUES " +
                        "(?, ?, ?, ?, ?, ?, ?, TRUE);", nombre_place, ville_depart, ville_arrive,
                date_depart, date_arrive, heure_depart, heure_arrive);
    }

}
