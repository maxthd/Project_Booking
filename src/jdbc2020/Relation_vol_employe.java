package jdbc2020;

import java.sql.SQLException;

public class Relation_vol_employe {
    private int id_vol_employe;
    private int fk_vol;
    private int fk_employe;

    /***
     * Constructeur vol_employe
     * @param index
     * @param maconnexion
     * @throws SQLException
     */
    public Relation_vol_employe(int index, Connexion maconnexion) throws SQLException {
        id_vol_employe=index;
        fk_vol= maconnexion.fill_int_param("SELECT fk_vol FROM Relation_vol_employe " +
                "WHERE id_vol_employe = ?", id_vol_employe);

        fk_employe=maconnexion.fill_int_param("SELECT fk_employe FROM Relation_vol_employe " +
                "WHERE id_vol_employe = ?", id_vol_employe);

        //Afficher_vol_employe();
    }


    /***
     * Afficher les attributs de vol_employe (sur la console)
     */
    public void Afficher_vol_employe(){
        System.out.println("id_vol_employe: "+id_vol_employe + "\t\tfk_vol: "+fk_vol +"\t\tfk_employe: "+fk_employe);
        System.out.println("-----------------------------------------------------------------------------------------");
    }












    /***LES GETTERS ET LES SETTERS*/

    public int getId_vol_employe() {
        return id_vol_employe;
    }

    public void setId_vol_employe(int id_vol_employe) {
        this.id_vol_employe = id_vol_employe;
    }

    public int getFk_vol() {
        return fk_vol;
    }

    public void setFk_vol(int fk_vol) {
        this.fk_vol = fk_vol;
    }

    public int getFk_employe() {
        return fk_employe;
    }

    public void setFk_employe(int fk_employe) {
        this.fk_employe = fk_employe;
    }
}
