package jdbc2020;

import org.jdesktop.swingx.JXDatePicker;

import java.sql.SQLException;
import java.util.ArrayList;


public class Vol {
    private int id_vol;
    private int nombre_place;
    private String ville_depart;
    private String ville_arrive;
    private String date_depart; //On écrit les dates sous la forme de string "DD/MM/YYYY"
    private String date_arrive;
    private String heure_depart; //On écrit les heures sous la forme de string "HH:MM"
    private String heure_arrive;
    private boolean vol_dispo;



    public Vol(int index, Connexion maconnexion) throws SQLException, ClassNotFoundException {

        //id_vol=maconnexion.remplir_int("SELECT id_vol FROM Vol WHERE id_vol=1");
        nombre_place=maconnexion.remplir_id("SELECT nombre_place FROM Vol WHERE id_vol= ?", index);
        System.out.println("Vol numero "+index +" a "+nombre_place +" place");


    }

}
