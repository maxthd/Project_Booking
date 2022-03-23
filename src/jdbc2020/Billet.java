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

        System.out.println("id_billet: "+id_billet + "\t\t fk_vol : "+fk_vol+
                "\t\treduction : "+reduction + "\t\tcout : "+cout+ "\t\tbillet_dispo :" + billet_dispo);

        System.out.println("---------------------------------------------------------------"
        +"---------------------------------------------------------------");
    }












    /**EN DESSOUS SE TROUVE LES GETTERS ET LES SETTERS, CODER AU DESSUS !!*/
    public int getId_billet() {
        return id_billet;
    }

    public void setId_billet(int id_billet) {
        this.id_billet = id_billet;
    }

    public int getFk_vol() {
        return fk_vol;
    }

    public void setFk_vol(int fk_vol) {
        this.fk_vol = fk_vol;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    public int getBillet_dispo() {
        return billet_dispo;
    }

    public void setBillet_dispo(int billet_dispo) {
        this.billet_dispo = billet_dispo;
    }
}
