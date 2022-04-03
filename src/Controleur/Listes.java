package Controleur;

import Modele.*;

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
    private ArrayList<Image> images=new ArrayList<>();

    /***
     * Constructeur Listes
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Listes() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");

        vols.clear();
        employes.clear();
        clients.clear();
        billets.clear();
        reservations.clear();
        vols_employes.clear();
        clients_employes.clear();
        images.clear();
        init_listes_vols();
        init_listes_employes();
        init_listes_clients();
        init_listes_billets();
        init_listes_reservation();
        init_listes_vols_employes();
        init_listes_clients_employes();
        init_listes_images();
    }


    /***
     * Recuperer les vols de la BDD
     * @throws SQLException
     */
    public void init_listes_vols() throws SQLException {
        ArrayList<Integer> list_id;
        list_id=maconnexion.fill_array("SELECT id_vol FROM Vol");

        for (int i=0; i< list_id.size(); i++)
        {
            Vol vol=new Vol(list_id.get(i), maconnexion);
            vols.add(vol);
        }

    }


    /***
     * Recuperer les employes de la BDD
     * @throws SQLException
     */
    public void init_listes_employes() throws SQLException {
        ArrayList<Integer> list_id;
        list_id=maconnexion.fill_array("SELECT id_employe FROM Employe");

        for (int i=0; i< list_id.size(); i++)
        {
            Employe employe=new Employe(list_id.get(i), maconnexion);
            employes.add(employe);
        }
    }


    /***
     * Recuperer les clients de la BDD
     * @throws SQLException
     */
    public void init_listes_clients() throws SQLException {
        ArrayList<Integer> list_id;
        list_id=maconnexion.fill_array("SELECT id_client FROM Client");

        for (int i=0; i< list_id.size(); i++)
        {
            Client client=new Client(list_id.get(i), maconnexion);
            clients.add(client);
        }
    }

    /***
     * Recuperer les billets de la BDD
     * @throws SQLException
     */
    public void init_listes_billets() throws SQLException {
        ArrayList<Integer> list_id;
        list_id=maconnexion.fill_array("SELECT id_billet FROM Billet");

        for (int i=0; i< list_id.size(); i++)
        {
            Billet billet=new Billet(list_id.get(i), maconnexion);
            billets.add(billet);
        }
    }

    /***
     * Recuperer les réservations de la BDD
     * @throws SQLException
     */
    public void init_listes_reservation() throws SQLException {
        ArrayList<Integer> list_id;
        list_id=maconnexion.fill_array("SELECT id_reservation FROM Reservation");

        for (int i=0; i< list_id.size(); i++)
        {
            Reservation reservation=new Reservation(list_id.get(i), maconnexion);
            reservations.add(reservation);
        }
    }

    /***
     * Recuperer les relations_vols_employes de la BDD
     * @throws SQLException
     */
    public void init_listes_vols_employes() throws SQLException {
        ArrayList<Integer> list_id;
        list_id=maconnexion.fill_array("SELECT id_vol_employe FROM Relation_vol_employe");

        for (int i=0; i< list_id.size(); i++)
        {
            Relation_vol_employe vol_employe=new Relation_vol_employe(list_id.get(i), maconnexion);
            vols_employes.add(vol_employe);
        }
    }

    /***
     * Recuperer les relations_clients_employes de la BDD
     * @throws SQLException
     */
    public void init_listes_clients_employes() throws SQLException {
        ArrayList<Integer> list_id;
        list_id=maconnexion.fill_array("SELECT id_client_employe FROM Relation_client_employe");

        for (int i=0; i< list_id.size(); i++)
        {
            Relation_client_employe client_employe=new Relation_client_employe(list_id.get(i), maconnexion);
            clients_employes.add(client_employe);
        }
    }

    /***
     * Recuperer les images de la BDD
     * @throws SQLException
     */
    public void init_listes_images() throws SQLException {
        ArrayList<Integer> list_id;
        list_id=maconnexion.fill_array("SELECT id_image FROM Image");

        for (int i=0; i< list_id.size(); i++)
        {
            Image image=new Image(list_id.get(i), maconnexion);
            images.add(image);
        }
    }

    /***
     * Affichage console BDD
     */
    public void Afficher_listes(){
        for (int i=0; i<vols.size(); i++)
            vols.get(i).Afficher_Vol();

        for (int i=0; i<employes.size(); i++)
            employes.get(i).Afficher_Employe();

        for (int i=0; i<clients.size(); i++)
            clients.get(i).Afficher_Client();


        for (int i=0; i<billets.size(); i++)
            billets.get(i).Afficher_billet();

        for (int i=0; i<reservations.size(); i++)
            reservations.get(i).Afficher_Reservation();


        for (int i=0; i< vols_employes.size(); i++)
            vols_employes.get(i).Afficher_vol_employe();

        for (int i=0; i< clients_employes.size(); i++)
            clients_employes.get(i).Afficher_client_employe();

        for (int i=0; i<images.size(); i++)
            images.get(i).Afficher_Image();
    }











    /**LES GETTERS ET LES SETTERS*/
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
