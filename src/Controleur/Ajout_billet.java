package Controleur;

import Modele.Connexion;

import java.sql.SQLException;

public class Ajout_billet {
    private Connexion maconnexion;
    private int temp_id_vol;

    /***
     * Constructeur Ajout_billet
     * @param id_vol
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Ajout_billet(int id_vol) throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
        temp_id_vol=id_vol;

    }


    /***
     * Ajoute le billet à la BDD et met à jour le nombre de place du vol
     * @param nombre_economique
     * @param nombre_affaire
     * @param nombre_premium
     * @param cout_economique
     * @param cout_affaire
     * @param cout_premium
     * @param reduction_economique
     * @param reduction_affaire
     * @param reduction_premium
     * @throws SQLException
     */
    public void Ajouter_billets(int nombre_economique, int nombre_affaire, int nombre_premium,
                                double cout_economique, double cout_affaire, double cout_premium,
                                double reduction_economique, double reduction_affaire,
                                double reduction_premium ) throws SQLException {

        maconnexion.executeinsert_billet("INSERT INTO Billet " +
                "(fk_vol, cout, reduction, type_billet, nombre_billet, billet_dispo) VALUES " +
                "(?, ?, ?, 1, ?, TRUE)", temp_id_vol, cout_economique, reduction_economique, nombre_economique );

        maconnexion.executeinsert_billet("INSERT INTO Billet " +
                "(fk_vol, cout, reduction, type_billet, nombre_billet, billet_dispo) VALUES " +
                "(?, ?, ?, 2, ?, TRUE)", temp_id_vol, cout_affaire, reduction_affaire, nombre_affaire);

        maconnexion.executeinsert_billet("INSERT INTO Billet " +
                "(fk_vol, cout, reduction, type_billet, nombre_billet, billet_dispo) VALUES " +
                "(?, ?, ?, 3, ?, TRUE)", temp_id_vol, cout_premium, reduction_premium, nombre_premium );

        maconnexion.param_two_executeUpdate("UPDATE Vol SET nombre_place=? " +
                "WHERE id_vol=?", nombre_economique + nombre_affaire + nombre_premium, temp_id_vol);

    }
}
