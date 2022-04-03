package Modele;

import java.sql.SQLException;

public class Billet {
    private int id_billet;
    private int fk_vol;
    private double cout;
    private double reduction;
    private int type_billet; //1 pour éco, 2 pour affaire et 3 pour premium
    private int nombre_billet;
    private int billet_dispo;


    /***
     * Constructeur Classe Billet
     * @param index
     * @param maconnexion
     * @throws SQLException
     */
    public Billet(int index, Connexion maconnexion) throws SQLException {
        id_billet=index;
        fk_vol= maconnexion.fill_int_param("SELECT fk_vol FROM Billet WHERE id_billet = ?", id_billet);
        cout= maconnexion.fill_double_param("SELECT cout FROM Billet WHERE id_billet = ?", id_billet);
        reduction= maconnexion.fill_double_param("SELECT reduction FROM Billet WHERE id_billet = ?", id_billet);
        type_billet=maconnexion.fill_int_param("SELECT type_billet FROM Billet WHERE id_billet = ?", id_billet);
        nombre_billet=maconnexion.fill_int_param("SELECT nombre_billet FROM Billet WHERE id_billet = ?", id_billet);
        billet_dispo= maconnexion.fill_int_param("SELECT billet_dispo FROM Billet WHERE id_billet = ?", id_billet);

        //Afficher_billet();
    }


    /***
     * Affichage les attributs de Billet (sur la console)
     */
    public void Afficher_billet(){

        System.out.println("id_billet: "+id_billet + "\t\t fk_vol : "+fk_vol+
                "\t\treduction : "+reduction + "\t\tcout : "+cout+ "\t\ttype_billet :" + type_billet+
                 "\t\tnombre_billet de ce type :" + nombre_billet +  "\t\tbillet_dispo :" + billet_dispo);

        System.out.println("---------------------------------------------------------------"
        +"---------------------------------------------------------------");
    }












    /***LES GETTERS ET LES SETTERS*/
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

    public int getType_billet() {
        return type_billet;
    }

    public void setType_billet(int type_billet) {
        this.type_billet = type_billet;
    }

    public int getNombre_billet() {
        return nombre_billet;
    }

    public void setNombre_billet(int nombre_billet) {
        this.nombre_billet = nombre_billet;
    }

    public int getBillet_dispo() {
        return billet_dispo;
    }

    public void setBillet_dispo(int billet_dispo) {
        this.billet_dispo = billet_dispo;
    }
}
