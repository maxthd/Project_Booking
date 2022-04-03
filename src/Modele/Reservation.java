package Modele;

import java.sql.SQLException;

public class Reservation {
    private int id_reservation;
    private int fk_vol;
    private int fk_client;


    /***
     * Constructeur Reservation
     * @param index
     * @param maconnexion
     * @throws SQLException
     */
    public Reservation(int index, Connexion maconnexion) throws SQLException {
        id_reservation=index;
        fk_vol= maconnexion.fill_int_param("SELECT fk_vol FROM Reservation WHERE id_reservation = ?", id_reservation);
        fk_client= maconnexion.fill_int_param("SELECT fk_client FROM Reservation WHERE id_reservation = ?", id_reservation);

        //Afficher_Reservation();
    }


    /***
     * Afficher les attributs de Reservation (sur la console)
     */
    public void Afficher_Reservation(){
        System.out.println("id_reservation: "+id_reservation + "\t\tfk_vol: "+fk_vol +"\t\tfk_client: "+fk_client);
        System.out.println("---------------------------------------------------------------------------");
    }







    /***LES GETTERS ET LES SETTERS*/
    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getFk_vol() {
        return fk_vol;
    }

    public void setFk_vol(int fk_vol) {
        this.fk_vol = fk_vol;
    }

    public int getFk_client() {
        return fk_client;
    }

    public void setFk_client(int fk_client) {
        this.fk_client = fk_client;
    }
}
