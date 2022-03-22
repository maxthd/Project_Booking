package jdbc2020;

import java.sql.SQLException;

public class Client {
    private int id_client;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private int age;
    private double solde;
    private double reduction; //La valeur de reduction du client sera attribué à la valeur de réduction de "Billet"
    private int membre;

    public Client(int index, Connexion maconnexion) throws SQLException {
        id_client=index;
        nom= maconnexion.fill_string_param("SELECT nom FROM Client WHERE id_client= ?", id_client);
        prenom= maconnexion.fill_string_param("SELECT prenom FROM Client WHERE id_client= ?", id_client);
        username= maconnexion.fill_string_param("SELECT username FROM Client WHERE id_client= ?", id_client);
        password= maconnexion.fill_string_param("SELECT password FROM Client WHERE id_client= ?", id_client);
        age= maconnexion.fill_int_param("SELECT age FROM Client WHERE id_client= ?", id_client);
        solde= maconnexion.fill_double_param("SELECT solde FROM Client WHERE id_client= ?", id_client);
        reduction= maconnexion.fill_double_param("SELECT reduction FROM Client WHERE id_client= ?", id_client);
        membre= maconnexion.fill_int_param("SELECT membre FROM Client WHERE id_client= ?", id_client);

        Afficher_Client();

    }

    public void Afficher_Client(){

        System.out.println("-------------------------");
        System.out.println("Numéro d'employé : "+id_client);
        System.out.println("Nom d'employé : "+nom);
        System.out.println("Prenom d'employé : "+prenom);
        System.out.println("Username d'employé : "+username);
        System.out.println("Password d'employé : "+password);
        System.out.println("Age : "+age);
        System.out.println("Solde: "+solde);
        System.out.println("Reduction : "+reduction);
        if (membre==0)
        System.out.println("Non membre ");
        else System.out.println("membre ");
        System.out.println("-------------------------");
    }

}
