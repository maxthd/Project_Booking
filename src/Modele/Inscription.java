package Modele;

import jdbc2020.*;

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
                    " age, solde, membre) VALUES" +
                    "(?, ?, ?, ?, ?, ?, ? )", nom, prenom, username, password, age, solde, membre);
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

    public boolean Is_empty (String a,String b,String c,String d,String e,String f)
    {
        if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty() || e.isEmpty() || f.isEmpty())
        {
            System.out.println("erreur car un champs est nul");
            return false;
        }
        else
        {
            System.out.println("Ca se passe bien");
            return true;
        }
    }

    public int Valeur_checkbox (boolean bool)
    {
        if (bool)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
