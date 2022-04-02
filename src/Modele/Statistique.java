package Modele;

import jdbc2020.Connexion;

import java.sql.SQLException;

public class Statistique {
    private Connexion maconnexion;
    private int temp_id_vol;

    public Statistique(int id_vol) throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
        temp_id_vol=id_vol;
    }

    public int getnombre_billet_eco_restant () throws SQLException {
        int nombre_eco=0;
        nombre_eco=maconnexion.fill_int_param("SELECT nombre_billet FROM Billet " +
                "WHERE type_billet=1 AND fk_vol=?", temp_id_vol);
        return nombre_eco;

    }

    public int getnombre_billet_affaire_restant () throws SQLException {
        int nombre_affaire=0;
        nombre_affaire=maconnexion.fill_int_param("SELECT nombre_billet FROM Billet " +
                "WHERE type_billet=2 AND fk_vol=?", temp_id_vol);
        return nombre_affaire;

    }

    public int getnombre_billet_premium_restant () throws SQLException {
        int nombre_premium=0;
        nombre_premium=maconnexion.fill_int_param("SELECT nombre_billet FROM Billet " +
                "WHERE type_billet=3 AND fk_vol=?", temp_id_vol);
        return nombre_premium;

    }

    public int getnombre_total () throws SQLException {
        int nombre_total=0;
        nombre_total=maconnexion.fill_int_param("SELECT nombre_place FROM Vol " +
                "WHERE id_vol=?", temp_id_vol);
        return nombre_total;

    }


}
