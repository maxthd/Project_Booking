package Modele;

import jdbc2020.Connexion;
import jdbc2020.Vol;

import java.sql.SQLException;
import java.util.ArrayList;

public class Ajout_vol {

    private Connexion maconnexion;


    /***
     * Constructeur Ajout_vol
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Ajout_vol() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
    }


    /***
     * Ajoute à vol
     * @param ville_depart
     * @param ville_arrive
     * @param date_depart
     * @param date_arrive
     * @param heure_depart
     * @param heure_arrive
     * @throws SQLException
     */
    public void Insert_Vol(String ville_depart, String ville_arrive,
                      String date_depart, String date_arrive ,
                      String heure_depart, String heure_arrive) throws SQLException {

        maconnexion.executeinsert_vol("INSERT INTO Vol (ville_depart, ville_arrive, " +
                        "date_depart, date_arrive, " +
                        "heure_depart , heure_arrive , vol_dispo) VALUES " +
                        "( ?, ?, ?, ?, ?, ?, TRUE);", ville_depart, ville_arrive,
                date_depart, date_arrive, heure_depart, heure_arrive);
    }

    /***
     * Recupère l'id du vol qu'on vient d'ajouter
     * @return
     * @throws SQLException
     */
    public int get_id_lastvol() throws SQLException {
        ArrayList<Integer> list_id;
        list_id=maconnexion.fill_array("SELECT id_vol FROM Vol");
        int id=0;
        id=list_id.get(list_id.size()-1);

        return id;
    }

}
