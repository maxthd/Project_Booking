//https://stackoverflow.com/questions/12745186/passing-parameters-to-a-jdbc-preparedstatement
package jdbc2020;

import java.sql.*;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**statement =con.prepareStatement("SELECT * from employee WHERE  userID = ?");
 statement.setString(1, userID);*/

public class Connexion {

    private final Connection conn;
    private final Statement stmt;
    private PreparedStatement prepared_stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;

    public ArrayList<String> tables = new ArrayList<>();

    public ArrayList<String> requetes = new ArrayList<>();


    /**Constructeur */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        String urlDatabase = "jdbc:mysql://localhost:3306/" + nameDatabase;


        //création d'une connexion JDBC à la base
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }



    public void ajouterTable(String table) {
        tables.add(table);
    }


    /**Ajout d'une ligne dans Requete (3ème colonne)*/
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

    public int remplir_id(String requete, int index) throws SQLException {

        int temp_int=0;
        prepared_stmt =conn.prepareStatement(requete);
        prepared_stmt.setInt(1, index);

        // récupération de l'ordre de la requete
        rset = prepared_stmt.executeQuery();

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // tant qu'il reste une ligne
        while (rset.next()) {
            temp_int = rset.getInt(1);
        }
        return temp_int;
    }

    public int remplir_int(String requete) throws SQLException {

        int temp_int=0;

        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // tant qu'il reste une ligne
        while (rset.next()) {
            temp_int = rset.getInt(1);
        }
        return temp_int;
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


    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }


}
