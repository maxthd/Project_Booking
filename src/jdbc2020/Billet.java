package jdbc2020;

import java.sql.SQLException;

public class Billet {
    private int id_billet;
    private int fk_vol;
    private double cout;
    private double reduction;
    private int billet_dispo;

    public Billet(int index, Connexion maconnexion) throws SQLException {
        id_billet=index;
        fk_vol= maconnexion.fill_int_param("SELECT fk_vol FROM Billet WHERE id_billet = ?", id_billet);
        cout= maconnexion.fill_double_param("SELECT cout FROM Billet WHERE id_billet = ?", id_billet);
        reduction= maconnexion.fill_double_param("SELECT reduction FROM Billet WHERE id_billet = ?", id_billet);
        billet_dispo= maconnexion.fill_int_param("SELECT billet_dispo FROM Billet WHERE id_billet = ?", id_billet);

        //Afficher_billet();
    }


    public void Afficher_billet(){
        System.out.println("-------------------------");
        System.out.println("id_billet: "+id_billet);
        System.out.println("fk_vol : "+fk_vol);
        System.out.println("reduction : "+reduction);
        System.out.println("cout : "+cout);
        if (billet_dispo==0)
            System.out.println("Non Disponible");
        else System.out.println("Disponible");
        System.out.println("-------------------------");
    }

}
