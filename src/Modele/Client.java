package Modele;

import java.sql.SQLException;

public class Client {
    private int id_client;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private int age;
    private double solde;
    private int membre;
    private int fk_image;

    /***
     * Constructeur Classe Client
     * @param index
     * @param maconnexion
     * @throws SQLException
     */
    public Client(int index, Connexion maconnexion) throws SQLException {
        id_client=index;
        nom= maconnexion.fill_string_param("SELECT nom FROM Client WHERE id_client= ?", id_client);
        prenom= maconnexion.fill_string_param("SELECT prenom FROM Client WHERE id_client= ?", id_client);
        username= maconnexion.fill_string_param("SELECT username FROM Client WHERE id_client= ?", id_client);
        password= maconnexion.fill_string_param("SELECT password FROM Client WHERE id_client= ?", id_client);
        age= maconnexion.fill_int_param("SELECT age FROM Client WHERE id_client= ?", id_client);
        solde= maconnexion.fill_double_param("SELECT solde FROM Client WHERE id_client= ?", id_client);
        membre= maconnexion.fill_int_param("SELECT membre FROM Client WHERE id_client= ?", id_client);
        fk_image=maconnexion.fill_int_param("SELECT fk_image FROM Client WHERE id_client= ?", id_client);

        //Afficher_Client();

    }

    /***
     * Afficher les attributs de Client (sur la console)
     */
    public void Afficher_Client(){

        System.out.println("Numéro_client: "+id_client+ "\t\tNom: "+nom + "\t\tPrenom: "+prenom
                +"\t\tUsername: "+username + "\t\tPassword : "+password + "\t\tAge: "+age +
                "\t\tSolde: "+solde + "\t\t membre: "+membre + "\t\t fk_image: "+fk_image);
        System.out.println("---------------------------------------------------------------------------" +
                "------------------------------------------");
    }

















    /***LES GETTERS ET LES SETTERS*/
    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }


    public int getMembre() {
        return membre;
    }

    public void setMembre(int membre) {
        this.membre = membre;
    }
}
