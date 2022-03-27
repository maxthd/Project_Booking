package Modele;

import jdbc2020.Connexion;

import java.sql.SQLException;

public class Ajout_vol {

    private Connexion maconnexion;


    public Ajout_vol() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
    }


    public void Insert_Vol(int nombre_place, String ville_depart, String ville_arrive,
                      int annee_depart, int mois_depart, int jour_depart,
                      int annee_arrive,  int mois_arrive, int jour_arrive,
                      String heure_depart, String heure_arrive) throws SQLException {

        maconnexion.executeinsert_vol("INSERT INTO Vol (nombre_place, ville_depart, ville_arrive, " +
                        "annee_depart, mois_depart, jour_depart, annee_arrive, mois_arrive, jour_arrive, " +
                        "heure_depart , heure_arrive , vol_dispo) VALUES " +
                        "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, TRUE);", nombre_place, ville_depart, ville_arrive, annee_depart,
                mois_depart, jour_depart, annee_arrive, mois_arrive, jour_arrive, heure_depart, heure_arrive);
    }

}
