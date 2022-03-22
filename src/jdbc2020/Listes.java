package jdbc2020;

import java.sql.SQLException;
import java.util.ArrayList;

public class Listes {
    private Connexion maconnexion;

    private ArrayList<Vol> vols=new ArrayList<>();
    private ArrayList<Employe> employes=new ArrayList<>();
    private ArrayList<Client> clients=new ArrayList<>();
    private ArrayList<Billet> billets=new ArrayList<>();

    private ArrayList<Reservation> reservations=new ArrayList<>();
    private ArrayList<Relation_vol_employe> vols_employes= new ArrayList<>();
    private ArrayList<Relation_client_employe> clients_employes=new ArrayList<>();

    public Listes() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");

        init_listes_vols();
        init_listes_employes();
        init_listes_clients();
        init_listes_billets();
        init_listes_reservation();
        init_listes_vols_employes();
        init_listes_clients_employes();
    }


    public void init_listes_vols() throws SQLException {
        int taille=maconnexion.fill_int("SELECT COUNT(*) FROM Vol");

        for (int i=1; i<=taille; i++) {
            Vol vol=new Vol(i, maconnexion);
            vols.add(vol);
        }
    }

    public void init_listes_employes() throws SQLException {
        int taille=maconnexion.fill_int("SELECT COUNT(*) FROM Employe");

        for (int i=1; i<=taille; i++) {
            Employe employe= new Employe(i, maconnexion);
            employes.add(employe);
        }
    }

    public void init_listes_clients() throws SQLException {
        int taille=maconnexion.fill_int("SELECT COUNT(*) FROM Client");

        for (int i=1; i<=taille; i++) {
            Client client=new Client(i, maconnexion);
            clients.add(client);
        }
    }

    public void init_listes_billets() throws SQLException {
        int taille=maconnexion.fill_int("SELECT COUNT(*) FROM Billet");

        for (int i=1; i<=taille; i++) {
            Billet billet=new Billet(i, maconnexion);
            billets.add(billet);
        }
    }

    public void init_listes_reservation() throws SQLException {
        int taille=maconnexion.fill_int("SELECT COUNT(*) FROM Reservation");

        for (int i=1; i<=taille; i++) {
            Reservation reservation=new Reservation(i, maconnexion);
            reservations.add(reservation);
        }
    }

    public void init_listes_vols_employes() throws SQLException {
        int taille=maconnexion.fill_int("SELECT COUNT(*) FROM Relation_vol_employe");

        for (int i=1; i<=taille; i++) {
            Relation_vol_employe vol_employe= new Relation_vol_employe(i, maconnexion);
            vols_employes.add(vol_employe);
        }
    }

    public void init_listes_clients_employes() throws SQLException {
        int taille=maconnexion.fill_int("SELECT COUNT(*) FROM Relation_client_employe");

        for (int i=1; i<=taille; i++) {
            Relation_client_employe client_employe=new Relation_client_employe(i, maconnexion);
            clients_employes.add(client_employe);
        }
    }


}
