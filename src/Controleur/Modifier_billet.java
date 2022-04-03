package Controleur;

import Modele.Connexion;

import java.sql.SQLException;

public class Modifier_billet {
    private Connexion maconnexion;
    private int temp_id_vol;

    /***
     * Constructeur Modifier_billet
     * @param id_vol
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Modifier_billet(int id_vol) throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
        temp_id_vol=id_vol;
    }


    /***
     * Cette méthode met à jour le billet
     * @param cout_economique
     * @param reduction_economique
     * @param cout_affaire
     * @param reduction_affaire
     * @param cout_premium
     * @param reduction_premium
     * @throws SQLException
     */
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




    /**Getters pour récuperer les couts et réductions de chaque classe de billets*/
    public double get_cout_eco() throws SQLException {
        double cout_eco=maconnexion.fill_double_param("SELECT cout FROM Billet " +
                "WHERE type_billet=1 AND fk_vol=?",temp_id_vol );
        return cout_eco;
    }

    public double get_reduc_eco() throws SQLException {
        double reduc_eco=maconnexion.fill_double_param("SELECT reduction FROM Billet " +
                "WHERE type_billet=1 AND fk_vol=?",temp_id_vol );
        return reduc_eco;
    }


    public double get_cout_affaire() throws SQLException {
        double cout_affaire=maconnexion.fill_double_param("SELECT cout FROM Billet " +
                "WHERE type_billet=2 AND fk_vol=?",temp_id_vol );
        return cout_affaire;
    }

    public double get_reduc_affaire() throws SQLException {
        double reduc_affaire=maconnexion.fill_double_param("SELECT reduction FROM Billet " +
                "WHERE type_billet=2 AND fk_vol=?",temp_id_vol );
        return reduc_affaire;
    }


    public double get_cout_premium() throws SQLException {
        double cout_premium=maconnexion.fill_double_param("SELECT cout FROM Billet " +
                "WHERE type_billet=3 AND fk_vol=?",temp_id_vol );
        return cout_premium;
    }

    public double get_reduc_premium() throws SQLException {
        double reduc_premium=maconnexion.fill_double_param("SELECT reduction FROM Billet " +
                "WHERE type_billet=3 AND fk_vol=?",temp_id_vol );
        return reduc_premium;
    }



}
