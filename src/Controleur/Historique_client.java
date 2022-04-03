package Controleur;
import Modele.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Historique_client {
    private ArrayList<Vol> vols =new ArrayList<>();
    private Connexion maconnexion;


    /***
     * Recupère l'historique du client
     * @param id_client
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Historique_client(int id_client) throws SQLException, ClassNotFoundException {
        vols.clear();
        maconnexion=new Connexion("booking", "root", "");
        ArrayList<Integer> list_id;

        list_id=maconnexion.fill_array_param("SELECT v.id_vol FROM vol v, reservation r " +
                "WHERE v.id_vol=r.fk_vol AND r.fk_client=?", id_client);
        for (int i=0; i< list_id.size(); i++)
        {
            Vol vol=new Vol(list_id.get(i), maconnexion);
            vols.add(vol);
        }
    }


    /***
     * Affichage historique console
     */
    public void Affichage_historique(){
        for (int i=0; i<vols.size(); i++)
            vols.get(i).Afficher_Vol();
    }

    /***Getters*/
    public ArrayList<Vol> get_historique() {
        return vols;
    }
}
