package Modele;

import jdbc2020.Connexion;

import java.sql.SQLException;

public class Modifier_billet {
    private Connexion maconnexion;
    private int temp_id_vol;

    public Modifier_billet(int id_vol) throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
        temp_id_vol=id_vol;
    }

    public void Update_billet(double cout_economique, double reduction_economique,
                         double cout_affaire, double reduction_affaire,
                         double cout_premium, double reduction_premium) throws SQLException {

        maconnexion.executeupdate_coutreduc_billet("UPDATE Billet SET cout=?, reduction=? " +
                "WHERE type_billet=1 AND fk_vol=?", cout_economique, reduction_economique, temp_id_vol);

        maconnexion.executeupdate_coutreduc_billet("UPDATE Billet SET cout=?, reduction=? " +
                "WHERE type_billet=2 AND fk_vol=?", cout_affaire, reduction_affaire, temp_id_vol);

        maconnexion.executeupdate_coutreduc_billet("UPDATE Billet SET cout=?, reduction=? " +
                "WHERE type_billet=3 AND fk_vol=?", cout_premium, reduction_premium, temp_id_vol);

    }
}
