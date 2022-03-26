package jdbc2020;

import java.sql.SQLException;


public class Vol {
    private int id_vol;
    private int nombre_place;
    private String ville_depart;
    private String ville_arrive;
    private int annee_depart;
    private int mois_depart;
    private int jour_depart;
    private int annee_arrive;
    private int mois_arrive;
    private int jour_arrive;
    private String heure_depart; //On écrit les heures sous la forme de string "HH:MM"
    private String heure_arrive;
    private int vol_dispo;


    public Vol(int index, Connexion maconnexion) throws SQLException {

        id_vol = index;
        nombre_place = maconnexion.fill_int_param("SELECT nombre_place FROM Vol WHERE id_vol= ?", id_vol);
        ville_depart = maconnexion.fill_string_param("SELECT ville_depart FROM Vol WHERE id_vol= ?", id_vol);
        ville_arrive = maconnexion.fill_string_param("SELECT ville_arrive FROM Vol WHERE id_vol= ?", id_vol);
        annee_depart=maconnexion.fill_int_param("SELECT annee_depart FROM Vol WHERE id_vol= ?", id_vol);
        mois_depart=maconnexion.fill_int_param("SELECT mois_depart FROM Vol WHERE id_vol= ?", id_vol);
        jour_depart=maconnexion.fill_int_param("SELECT jour_depart FROM Vol WHERE id_vol= ?", id_vol);
        annee_arrive=maconnexion.fill_int_param("SELECT annee_arrive FROM Vol WHERE id_vol= ?", id_vol);
        mois_arrive=maconnexion.fill_int_param("SELECT mois_arrive FROM Vol WHERE id_vol= ?", id_vol);
        jour_arrive=maconnexion.fill_int_param("SELECT jour_arrive FROM Vol WHERE id_vol= ?", id_vol);
        heure_depart = maconnexion.fill_string_param("SELECT heure_depart FROM Vol WHERE id_vol= ?", id_vol);
        heure_arrive = maconnexion.fill_string_param("SELECT heure_arrive FROM Vol WHERE id_vol= ?", id_vol);
        vol_dispo = maconnexion.fill_int_param("SELECT vol_dispo FROM Vol WHERE id_vol= ?", id_vol);

        //Afficher_Vol();

    }

    public void Afficher_Vol() {
        System.out.println("Numéro_vol: " + id_vol+ "\t\tnbr_place: " + nombre_place+
                "\t\tville_départ: " + ville_depart+ "\t\tville arrivé: " + ville_arrive);
        System.out.println("annee départ: " + annee_depart + "\t\tmois départ: " + mois_depart +"\t\tjour départ: " + jour_depart +
                "\t\tannee arrivé: " + annee_arrive+"\t\tmois arrivé: " + mois_arrive+ "\t\tjour arrivé: " + jour_arrive+
                "\t\theure départ: " + heure_depart + "\t\theure arrivé: " + heure_arrive+ "\t\tvol_dispo: "+vol_dispo);

        System.out.println("---------------------------------------------------------------------------");

    }














    /**EN DESSOUS SE TROUVE LES GETTERS ET LES SETTERS, CODER AU DESSUS !!*/
    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public int getNombre_place() {
        return nombre_place;
    }

    public void setNombre_place(int nombre_place) {
        this.nombre_place = nombre_place;
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

    public int getAnnee_depart() {
        return annee_depart;
    }

    public void setAnnee_depart(int annee_depart) {
        this.annee_depart = annee_depart;
    }

    public int getMois_depart() {
        return mois_depart;
    }

    public void setMois_depart(int mois_depart) {
        this.mois_depart = mois_depart;
    }

    public int getJour_depart() {
        return jour_depart;
    }

    public void setJour_depart(int jour_depart) {
        this.jour_depart = jour_depart;
    }

    public int getAnnee_arrive() {
        return annee_arrive;
    }

    public void setAnnee_arrive(int annee_arrive) {
        this.annee_arrive = annee_arrive;
    }

    public int getMois_arrive() {
        return mois_arrive;
    }

    public void setMois_arrive(int mois_arrive) {
        this.mois_arrive = mois_arrive;
    }

    public int getJour_arrive() {
        return jour_arrive;
    }

    public void setJour_arrive(int jour_arrive) {
        this.jour_arrive = jour_arrive;
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

