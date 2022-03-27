package Modele;
import jdbc2020.*;

import java.sql.SQLException;
import java.util.ArrayList;



public class Historique_client {
    private ArrayList<Vol> vols =new ArrayList<>();
    private Connexion maconnexion =new Connexion("booking", "root", "");


    public Historique_client(int id_client) throws SQLException, ClassNotFoundException {
        ArrayList<Integer> list_id;
        list_id=maconnexion.fill_array_param("SELECT v.id_vol FROM vol v, reservation r " +
                "WHERE v.id_vol=r.fk_vol AND r.fk_client=?", id_client);

        for (int i=0; i< list_id.size(); i++)
        {
            Vol vol=new Vol(list_id.get(i), maconnexion);
            vols.add(vol);
        }
    }

    public void Affichage_historique(){
        for (int i=0; i<vols.size(); i++)
            vols.get(i).Afficher_Vol();
    }

    public ArrayList<Vol> get_historique() {
        return vols;
    }
}
