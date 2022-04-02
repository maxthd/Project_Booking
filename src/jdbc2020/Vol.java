package jdbc2020;

import java.sql.SQLException;


public class Vol {
    private int id_vol;
    private String ville_depart;
    private String ville_arrive;
    private String date_depart; //On écrit les dates sous la forme de string "DD/MM/YYYY"
    private String date_arrive;
    private String heure_depart; //On écrit les heures sous la forme de string "HH:MM"
    private String heure_arrive;
    private int nombre_place;
    private int vol_dispo;


    public Vol(int index, Connexion maconnexion) throws SQLException {

        id_vol = index;
        ville_depart = maconnexion.fill_string_param("SELECT ville_depart FROM Vol WHERE id_vol= ?", id_vol);
        ville_arrive = maconnexion.fill_string_param("SELECT ville_arrive FROM Vol WHERE id_vol= ?", id_vol);
        date_depart=maconnexion.fill_string_param("SELECT date_depart FROM Vol WHERE id_vol= ?", id_vol);
        date_arrive=maconnexion.fill_string_param("SELECT date_arrive FROM Vol WHERE id_vol= ?", id_vol);
        heure_depart = maconnexion.fill_string_param("SELECT heure_depart FROM Vol WHERE id_vol= ?", id_vol);
        heure_arrive = maconnexion.fill_string_param("SELECT heure_arrive FROM Vol WHERE id_vol= ?", id_vol);
        nombre_place= maconnexion.fill_int_param("SELECT nombre_place FROM Vol WHERE id_vol= ?", id_vol);
        vol_dispo = maconnexion.fill_int_param("SELECT vol_dispo FROM Vol WHERE id_vol= ?", id_vol);

        //Afficher_Vol();

    }

    public void Afficher_Vol() {
        System.out.println("Numéro_vol: " + id_vol+
                "\t\tville_départ: " + ville_depart+ "\t\tville arrivé: " + ville_arrive);
        System.out.println("date_départ: " + date_depart + "\t\tdate_arrivé: " + date_arrive +
                "\t\theure départ: " + heure_depart + "\t\theure arrivé: " + heure_arrive+
                "\t\tnombre_place: "+nombre_place + "\t\tvol_dispo: "+vol_dispo);

        System.out.println("---------------------------------------------------------------------------");

    }














    /**EN DESSOUS SE TROUVE LES GETTERS ET LES SETTERS, CODER AU DESSUS !!*/
    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }


    public String getVille_depart() {
        return ville_depart;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public String getVille_arrive() {
        return ville_arrive;
    }

    public void setVille_arrive(String ville_arrive) {
        this.ville_arrive = ville_arrive;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public String getDate_arrive() {
        return date_arrive;
    }

    public void setDate_arrive(String date_arrive) {
        this.date_arrive = date_arrive;
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }

    public String getHeure_arrive() {
        return heure_arrive;
    }

    public void setHeure_arrive(String heure_arrive) {
        this.heure_arrive = heure_arrive;
    }

    public int getVol_dispo() {
        return vol_dispo;
    }

    public void setVol_dispo(int vol_dispo) {
        this.vol_dispo = vol_dispo;
    }
}

