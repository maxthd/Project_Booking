package Modele;

import jdbc2020.Connexion;

import java.sql.SQLException;

public class Modifier_vol {
    private Connexion maconnexion;


    public Modifier_vol() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
    }


    public void Update_Vol(int id_vol, int nombre_place, String ville_depart, String ville_arrive,
                           int annee_depart, int mois_depart, int jour_depart,
                           int annee_arrive,  int mois_arrive, int jour_arrive,
                           String heure_depart, String heure_arrive, int vol_dispo) throws SQLException {

        System.out.println("here");
        maconnexion.executeupdate_vol("UPDATE Vol SET nombre_place=?, ville_depart=?, ville_arrive=?," +
                "annee_depart=?, mois_depart=?, jour_depart=?, annee_arrive=?, mois_arrive=?, jour_arrive=?," +
                "heure_depart=?, heure_arrive=?, vol_dispo=? WHERE id_vol=?", nombre_place, ville_depart, ville_arrive, annee_depart,
                mois_depart, jour_depart, annee_arrive, mois_arrive, jour_arrive, heure_depart, heure_arrive, vol_dispo, id_vol);
    }
}
