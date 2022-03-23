package jdbc2020;

import java.sql.SQLException;


public class Vol {
    private int id_vol;
    private int nombre_place;
    private String ville_depart;
    private String ville_arrive;
    private String date_depart; //On écrit les dates sous la forme de string "DD/MM/YYYY"
    private String date_arrive;
    private String heure_depart; //On écrit les heures sous la forme de string "HH:MM"
    private String heure_arrive;
    private int vol_dispo;



    public Vol(int index, Connexion maconnexion) throws SQLException {

        id_vol=index;
        nombre_place= maconnexion.fill_int_param("SELECT nombre_place FROM Vol WHERE id_vol= ?", id_vol);
        ville_depart=maconnexion.fill_string_param("SELECT ville_depart FROM Vol WHERE id_vol= ?", id_vol);
        ville_arrive=maconnexion.fill_string_param("SELECT ville_arrive FROM Vol WHERE id_vol= ?", id_vol);
        date_depart=maconnexion.fill_string_param("SELECT date_depart FROM Vol WHERE id_vol= ?", id_vol);
        date_arrive=maconnexion.fill_string_param("SELECT date_arrive FROM Vol WHERE id_vol= ?", id_vol);
        heure_depart=maconnexion.fill_string_param("SELECT heure_depart FROM Vol WHERE id_vol= ?", id_vol);
        heure_arrive=maconnexion.fill_string_param("SELECT heure_arrive FROM Vol WHERE id_vol= ?", id_vol);
        vol_dispo=maconnexion.fill_int_param("SELECT vol_dispo FROM Vol WHERE id_vol= ?", id_vol);

        //Afficher_Vol();

    }

    public void Afficher_Vol(){
        System.out.println("-------------------------");
        System.out.println(" Numéro de vol : "+ id_vol);
        System.out.println(" nombre place : "+ nombre_place);
        System.out.println(" ville départ : "+ ville_depart);
        System.out.println(" ville arrivé : "+ ville_arrive);
        System.out.println(" date départ : "+ date_depart);
        System.out.println(" date arrivé : "+ date_arrive);
        System.out.println(" heure départ : "+ heure_depart);
        System.out.println(" heure arrivé : "+ heure_arrive);
        if (vol_dispo==0)
        System.out.println("Non Disponible :");
        else System.out.println("Disponible");
        System.out.println("-------------------------");

    }

}
