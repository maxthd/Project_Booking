package jdbc2020;

import java.sql.SQLException;

public class Reservation {
    private int id_reservation;
    private int fk_vol;
    private int fk_client;

    public Reservation(int index, Connexion maconnexion) throws SQLException {
        id_reservation=index;
        fk_vol= maconnexion.fill_int_param("SELECT fk_vol FROM Reservation WHERE id_reservation = ?", id_reservation);
        fk_client= maconnexion.fill_int_param("SELECT fk_client FROM Reservation WHERE id_reservation = ?", id_reservation);

        //Afficher_Reservation();
    }


    public void Afficher_Reservation(){
        System.out.println("-------------------------");
        System.out.println("id_reservation : "+id_reservation);
        System.out.println("fk_vol : "+fk_vol);
        System.out.println("fk_client : "+fk_client);
        System.out.println("-------------------------");
    }
}
