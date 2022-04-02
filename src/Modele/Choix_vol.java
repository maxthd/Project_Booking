package Modele;
import jdbc2020.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Choix_vol {
    private ArrayList<Vol> vols=new ArrayList();
    private Connexion maconnexion;


    public Choix_vol(String ville_depart, String ville_arrive) throws SQLException, ClassNotFoundException {
        vols.clear();
        maconnexion=new Connexion("booking", "root", "");
        ArrayList<Integer> list_id=new ArrayList<>();

        if (ville_depart.isEmpty()==true && ville_arrive.isEmpty()==true) {
            list_id = maconnexion.fill_array("SELECT id_vol FROM vol");
            System.out.println("ville_depart et ville_arrive sont nuls");
        }

        if (ville_depart.isEmpty()==false && ville_arrive.isEmpty()==true) {
            list_id = maconnexion.fill_array_param_String("SELECT id_vol FROM vol " +
                    "WHERE ville_depart=?", ville_depart);
            System.out.println("ville_arrive vide");
        }

        if (ville_depart.isEmpty()==true && ville_arrive.isEmpty()==false) {
            list_id = maconnexion.fill_array_param_String("SELECT id_vol FROM vol " +
                    "WHERE ville_arrive=?", ville_arrive);
            System.out.println("ville_depart vide");
        }

        if (ville_depart.isEmpty()==false && ville_arrive.isEmpty()==false) {
            list_id = maconnexion.fill_array_two_param_String("SELECT id_vol FROM vol " +
                    "WHERE ville_depart=? AND ville_arrive=?", ville_depart, ville_arrive);
            System.out.println("ville_depart et ville_arrive rempli");
        }

        for (int i=0; i< list_id.size(); i++)
        {
            Vol vol=new Vol(list_id.get(i), maconnexion);
            if (vol.getVol_dispo()==1)
                vols.add(vol);
        }
    }



    public void Affichage_vols(){
        for (int i=0; i<vols.size(); i++)
            vols.get(i).Afficher_Vol();
    }


    public ArrayList<Vol> get_vols() {
        return vols;
    }
}

