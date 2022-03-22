package jdbc2020;

import java.sql.SQLException;
import java.util.ArrayList;

public class Listes {
    private ArrayList<Vol> vols=new ArrayList<>();
    private Connexion maconnexion;
    private int taille;

    public Listes() throws SQLException, ClassNotFoundException {
        taille=0;
        maconnexion=new Connexion("booking", "root", "");

        taille=maconnexion.remplir_int("SELECT COUNT(*) FROM Vol");

        for (int i=1; i<=taille; i++) {
            Vol vol=new Vol(i, maconnexion);
            vols.add(vol);
        }

    }


}
