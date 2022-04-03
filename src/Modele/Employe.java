package Modele;


import java.sql.SQLException;

public class Employe {
    private int id_employe;
    private String nom;
    private String prenom;
    private String username;
    private String password;

    /***
     * Constructeur employé
     * @param index
     * @param maconnexion
     * @throws SQLException
     */
    public Employe(int index, Connexion maconnexion) throws SQLException {
        id_employe=index;
        nom=maconnexion.fill_string_param("SELECT nom FROM Employe WHERE id_employe = ?", id_employe);
        prenom=maconnexion.fill_string_param("SELECT prenom FROM Employe WHERE id_employe = ?", id_employe);
        username=maconnexion.fill_string_param("SELECT username FROM Employe WHERE id_employe = ?", id_employe);
        password=maconnexion.fill_string_param("SELECT password FROM Employe WHERE id_employe = ?", id_employe);

        //Afficher_Employe();
    }


    /***
     * Afficher les attributs de Employe (sur la console)
     */
    public void Afficher_Employe(){

        System.out.println("Numéro_employé: "+id_employe + "\t\tNom: "+nom + "\t\tPrenom: "+prenom +
                "\t\tUsername: "+username + "\t\tPassword: "+password);
        System.out.println("----------------------------------------------------------");
    }













    /***LES GETTERS ET LES SETTERS*/
    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
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
}
