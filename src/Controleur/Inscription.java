package Controleur;

import Modele.*;

import java.sql.SQLException;

public class Inscription {
    private Connexion maconnexion;

    /***
     * Constructeur Inscription
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Inscription() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");
    }


    /***
     * Constructeur qui permet d'inscrire un nouveau client
     * @param nom
     * @param prenom
     * @param username
     * @param password
     * @param age
     * @param solde
     * @param membre
     * @throws SQLException
     */
    public void Ajout_client(String nom, String prenom, String username, String password,
                             int age, double solde, int membre) throws SQLException {


        if (username_with_atsign(username)==true
            && (Valid_word("SELECT id_client FROM Client WHERE username= ?", username)==true)
            && (Valid_word("SELECT id_client FROM Client WHERE password= ?", password)==true)) {
            maconnexion.executeinsert_client("INSERT INTO Client (nom, prenom, username, password," +
                    " age, solde, membre, fk_image) VALUES" +
                    "(?, ?, ?, ?, ?, ?, ?, 1)", nom, prenom, username, password, age, solde, membre);
        }
        else
            System.out.println("Un client avec ce username ou ce mot de passe existe déja. Choisis un autre");
    }


    /***
     * Verifie que le username ou le mot de passe n'existe pas déja
     * @param requete
     * @param word
     * @return
     * @throws SQLException
     */
    public boolean Valid_word(String requete, String word) throws SQLException {
        int temp;
        temp=maconnexion.fill_int_param_String(requete, word);
        if (temp==0)
            return true;
        else
            return false;
    }


    /***
     * Verfie que le username est une adresse mail
     * @param username
     * @return
     */
    public boolean username_with_atsign (String username){
        for (int i=0; i<username.length(); i++)
        {
            if (username.charAt(i)=='@')
                return true;
        }
        return false;
    }


    /***
     * Verifie que tout les champs ont été rempli
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param f
     * @return
     */
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


    /***
     * Verifie la valeur de la checkbox
     * @param bool
     * @return
     */
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
