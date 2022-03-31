package Modele;

import jdbc2020.Connexion;

import java.sql.SQLException;

public class Modifier_vol {
    private Connexion maconnexion;


    public Modifier_vol() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
    }


    public void Update_Vol(int id_vol, String ville_depart, String ville_arrive,
                           String date_depart,
                           String date_arrive,
                           String heure_depart, String heure_arrive, int vol_dispo) throws SQLException {

        maconnexion.executeupdate_vol("UPDATE Vol SET ville_depart=?, ville_arrive=?," +
                "date_depart=?, date_arrive=?," +
                "heure_depart=?, heure_arrive=?, vol_dispo=? WHERE id_vol=?", ville_depart, ville_arrive,
                date_depart, date_arrive, heure_depart, heure_arrive, vol_dispo, id_vol);
    }

    public void Delete_Vol(int id_vol) throws SQLException {
        maconnexion.executeupdate_param("DELETE FROM Vol WHERE id_vol=?;", id_vol);
    }
}
