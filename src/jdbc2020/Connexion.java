//https://stackoverflow.com/questions/12745186/passing-parameters-to-a-jdbc-preparedstatement
package jdbc2020;

import java.sql.*;
import java.util.ArrayList;
import java.sql.PreparedStatement;



public class Connexion {

    private final Connection conn;
    private final Statement stmt;
    private PreparedStatement param_stmt;
    private ResultSet rset;

    /**CES ATTRIBUTS SONT USELESS*/
    private ResultSetMetaData rsetMeta;
    public ArrayList<String> tables = new ArrayList<>();
    public ArrayList<String> requetes = new ArrayList<>();

    //Constructeur
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        String urlDatabase = "jdbc:mysql://localhost:3306/" + nameDatabase;

        //création d'une connexion JDBC à la base
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }


    public ArrayList<Integer> fill_array(String requete) throws SQLException {

        // creation d'une ArrayList de String
        ArrayList<Integer> liste=new ArrayList<>();

        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();


        // tant qu'il reste une ligne
        while (rset.next()) {
            liste.add(rset.getInt(1)); // ajouter premier champ
        }

        // Retourner l'ArrayList
        return liste;
    }


    //Retourne un entier unique correspondant à la requete(avec paramètre)
    public int fill_int_param(String requete, int index) throws SQLException {

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, index);

        // récupération de l'ordre de la requete
        rset = param_stmt.executeQuery();

        while (rset.next()) {
            return rset.getInt(1);
        }
        return 0;

    }


    //Retourne un String unique correspondant à la requete(avec paramètre)
    public String fill_string_param(String requete, int index) throws SQLException {

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setString(1, String.valueOf(index));

        // récupération de l'ordre de la requete
        rset = param_stmt.executeQuery();

        while (rset.next()) {
            return rset.getString(1);
        }
        return "";

    }


    //Retourne un double unique correspondant à la requete(avec paramètre)
    public double fill_double_param(String requete, int index) throws SQLException {

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setDouble(1, index);

        // récupération de l'ordre de la requete
        rset = param_stmt.executeQuery();

        while (rset.next()) {
            return rset.getDouble(1);
        }
        return 0;

    }


    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }



    public void param_executeUpdate(String requete, int index) throws SQLException {
        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, index);

        param_stmt.executeUpdate();

    }


    public void param_two_executeUpdate(String requete, int index1, int index2) throws SQLException {
        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, index1);
        param_stmt.setInt(2, index2);

        param_stmt.executeUpdate();

    }










    /** LES METHODES EN DESSOUS SONT USELESSS*/
    //Retourne un entier unique correspondant à la requete (sans paramètre)
    public int fill_int(String requete) throws SQLException {

        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        return rset.getInt(1);

    }

    public void ajouterTable(String table) {
        tables.add(table);
    }

    public ArrayList remplirChampsRequete(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<>();

        // tant qu'il reste une ligne
        while (rset.next()) {
            String champs;
            champs = rset.getString(1); // ajouter premier champ

            // Concatener les champs de la ligne separes par ,
            for (int i = 1; i < nbColonne; i++) {
                champs = champs + "," + rset.getString(i + 1);
            }

            // ajouter un "\n" à la ligne des champs
            champs = champs + "\n";

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(champs);
        }

        // Retourner l'ArrayList
        return liste;
    }

    //Ajout d'une ligne dans Requete (3ème colonne)
    public void ajouterRequete(String requete) {

        requetes.add(requete);
    }


    public ArrayList remplirChampsTable(String table) throws SQLException {

        // récupération de l'ordre de la requete
        rset = stmt.executeQuery("SELECT * FROM " + table);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<>();
        String champs = "";
        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            champs = champs + " " + rsetMeta.getColumnLabel(i + 1);
        }

        // ajouter un "\n" à la ligne des champs
        champs = champs + "\n";

        // ajouter les champs de la ligne dans l'ArrayList
        liste.add(champs);

        // Retourner l'ArrayList
        return liste;
    }

}
