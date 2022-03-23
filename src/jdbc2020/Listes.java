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
        ArrayList<Integer> taille= new ArrayList<>();
        taille=maconnexion.fill_array("SELECT id_vol FROM Vol");

        for (int i=0; i< taille.size(); i++)
            System.out.println("dans taille ca a la  valeur "+ taille.get(i));

        /*for (int i=1; i<=taille; i++) {
            Vol vol=new Vol(i, maconnexion);
            vols.add(vol);
        }*/
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



    public void Afficher_listes(){
        /*for (int i=0; i<vols.size(); i++)
            vols.get(i).Afficher_Vol();

        for (int i=0; i<employes.size(); i++)
            employes.get(i).Afficher_Employe();

        for (int i=0; i<clients.size(); i++)
            clients.get(i).Afficher_Client();*/

        for (int i=0; i<billets.size(); i++)
            billets.get(i).Afficher_billet();

        /*for (int i=0; i<reservations.size(); i++)
            reservations.get(i).Afficher_Reservation();

        for (int i=0; i< vols_employes.size(); i++)
            vols_employes.get(i).Afficher_vol_employe();

        for (int i=0; i< clients_employes.size(); i++)
            clients_employes.get(i).Afficher_client_employe();*/
    }


    //
    public Listes MAJ_listes(String requete) throws SQLException, ClassNotFoundException {

        maconnexion.executeUpdate(requete);
        Listes newlist= new Listes();
        return newlist;
    }













    /**EN DESSOUS SE TROUVE LES GETTERS ET LES SETTERS, CODER AU DESSUS !!*/
    public ArrayList<Vol> getVols(){
        return vols;
    }

    public ArrayList<Employe> getEmployes(){
        return employes;
    }

    public ArrayList<Client> getClients(){
        return clients;
    }

    public ArrayList<Billet> getBillets(){
        return billets;
    }

    public ArrayList<Reservation> getReservations(){
        return reservations;
    }

    public ArrayList<Relation_vol_employe> getVols_employes(){
        return vols_employes;
    }

    public ArrayList<Relation_client_employe> getClients_employes(){
        return clients_employes;
    }





}
