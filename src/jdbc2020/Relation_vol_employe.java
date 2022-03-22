package jdbc2020;

import java.sql.SQLException;

public class Relation_vol_employe {
    private int id_vol_employe;
    private int fk_vol;
    private int fk_employe;

    public Relation_vol_employe(int index, Connexion maconnexion) throws SQLException {
        id_vol_employe=index;
        fk_vol= maconnexion.fill_int_param("SELECT fk_vol FROM Relation_vol_employe " +
                "WHERE id_vol_employe = ?", id_vol_employe);

        fk_employe=maconnexion.fill_int_param("SELECT fk_employe FROM Relation_vol_employe " +
                "WHERE id_vol_employe = ?", id_vol_employe);

        Afficher_vol_employe();
    }


    public void Afficher_vol_employe(){
        System.out.println("-------------------------");
        System.out.println("id_vol_employe: "+id_vol_employe);
        System.out.println("fk_vol : "+fk_vol);
        System.out.println("fk_employe: "+fk_employe);
        System.out.println("-------------------------");
    }

}
