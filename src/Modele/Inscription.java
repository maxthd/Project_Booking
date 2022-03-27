package Modele;

import jdbc2020.Connexion;

import java.sql.SQLException;

public class Inscription {
    private Connexion maconnexion;

    public Inscription() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
    }

    public void Ajout_client(String nom, String prenom, String username, String password,
                             int age, double solde, int membre) throws SQLException {

        if ((Valid_word("SELECT id_client FROM Client WHERE username= ?", username)==true)
            && (Valid_word("SELECT id_client FROM Client WHERE password= ?", password)==true)) {
            maconnexion.executeinsert_client("INSERT INTO Client (nom, prenom, username, password," +
                    " age, solde, reduction, membre) VALUES" +
                    "(?, ?, ?, ?, ?, ?, 0 , ? )", nom, prenom, username, password, age, solde, membre);
        }
        else
            System.out.println("Un client avec ce username ou ce mot de passe existe déja. Choisis un autre");
    }

    public boolean Valid_word(String requete, String word) throws SQLException {
        int temp;
        temp=maconnexion.fill_int_param_String(requete, word);
        if (temp==0)
            return true;
        else
            return false;
    }
}
