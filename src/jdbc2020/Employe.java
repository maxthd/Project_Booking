package jdbc2020;


import java.sql.SQLException;

public class Employe {
    private int id_employe;
    private String nom;
    private String prenom;
    private String username;
    private String password;

    public Employe(int index, Connexion maconnexion) throws SQLException {
        id_employe=index;
        nom=maconnexion.fill_string_param("SELECT nom FROM Employe WHERE id_employe = ?", id_employe);
        prenom=maconnexion.fill_string_param("SELECT prenom FROM Employe WHERE id_employe = ?", id_employe);
        username=maconnexion.fill_string_param("SELECT username FROM Employe WHERE id_employe = ?", id_employe);
        password=maconnexion.fill_string_param("SELECT password FROM Employe WHERE id_employe = ?", id_employe);

        //Afficher_Employe();
    }

    public void Afficher_Employe(){

        System.out.println("-------------------------");
        System.out.println("Numéro d'employé : "+id_employe);
        System.out.println("Nom d'employé : "+nom);
        System.out.println("Prenom d'employé : "+prenom);
        System.out.println("Username d'employé : "+username);
        System.out.println("Password d'employé : "+password);
        System.out.println("-------------------------");
    }


}
