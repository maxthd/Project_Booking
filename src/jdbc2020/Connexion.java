//https://stackoverflow.com/questions/12745186/passing-parameters-to-a-jdbc-preparedstatement
package jdbc2020;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.io.*;



public class Connexion {

    private final Connection conn;
    private final Statement stmt;
    private PreparedStatement param_stmt;
    private ResultSet rset;


    /***
     * Constructeur Connexion
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        String urlDatabase = "jdbc:mysql://localhost:3306/" + nameDatabase + "?autoReconnect=true&useSSL=false";

        //création d'une connexion JDBC à la base
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }


    /***
     * Ajouter une image à la BDD
     * @param requete
     * @param path
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public void execute_insertimage(String requete, String path) throws SQLException, FileNotFoundException {
        File file = new File(path);
        FileInputStream input = new FileInputStream(file);

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setBinaryStream(1, (InputStream)input,(int)file.length());

        param_stmt.executeUpdate();
        System.out.println("Image successfully inserted!");

    }


    /***
     * Retourne une image pour le package Vue
     * @param requete
     * @return
     * @throws SQLException
     */
    public ImageIcon fill_imageicon(String requete) throws SQLException {

        param_stmt =conn.prepareStatement(requete);

        // récupération de l'ordre de la requete
        rset = param_stmt.executeQuery();
        byte[] image = null;
        while (rset.next()) {
            image = rset.getBytes("picture");
        }
        //create the image
        Image img =Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icone = new ImageIcon(img);
        return icone;
    }


    /***
     * Retourne une liste de int selon une requete SQL
     * @param requete
     * @return
     * @throws SQLException
     */
    public ArrayList<Integer> fill_array(String requete) throws SQLException {

        // creation d'une ArrayList de String
        ArrayList<Integer> liste=new ArrayList<>();

        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        //rsetMeta = rset.getMetaData();


        // tant qu'il reste une ligne
        while (rset.next()) {
            liste.add(rset.getInt(1)); // ajouter premier champ
        }

        // Retourner l'ArrayList
        return liste;
    }


    /***
     * Retourne une liste de int selon une requete SQL (avec 1 paramètre type int)
     * @param requete
     * @param index
     * @return
     * @throws SQLException
     */
    public ArrayList<Integer> fill_array_param(String requete, int index) throws SQLException {

        // creation d'une ArrayList de String
        ArrayList<Integer> liste=new ArrayList<>();

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, index);


        // récupération de l'ordre de la requete
        rset = param_stmt.executeQuery();


        // tant qu'il reste une ligne
        while (rset.next()) {
            liste.add(rset.getInt(1)); // ajouter premier champ
        }

        // Retourner l'ArrayList
        return liste;
    }


    /***
     * Retourne une liste de int selon une requete SQL (avec 1 paramètre type String)
     * @param requete
     * @param word
     * @return
     * @throws SQLException
     */
    public ArrayList<Integer> fill_array_param_String(String requete,
                                                          String word) throws SQLException {

        // creation d'une ArrayList de String
        ArrayList<Integer> liste=new ArrayList<>();

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setString(1, word);


        // récupération de l'ordre de la requete
        rset = param_stmt.executeQuery();


        // tant qu'il reste une ligne
        while (rset.next()) {
            liste.add(rset.getInt(1)); // ajouter premier champ
        }

        // Retourner l'ArrayList
        return liste;
    }


    /***
     * Retourne une liste de int selon une requete SQL (avec 2 paramètre type String)
     * @param requete
     * @param word1
     * @param word2
     * @return
     * @throws SQLException
     */
    public ArrayList<Integer> fill_array_two_param_String(String requete,
                                                          String word1, String word2) throws SQLException {

        // creation d'une ArrayList de String
        ArrayList<Integer> liste=new ArrayList<>();

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setString(1, word1);
        param_stmt.setString(2, word2);


        // récupération de l'ordre de la requete
        rset = param_stmt.executeQuery();


        // tant qu'il reste une ligne
        while (rset.next()) {
            liste.add(rset.getInt(1)); // ajouter premier champ
        }

        // Retourner l'ArrayList
        return liste;
    }


    /***
     * Retourne un entier unique selon une requete SQL (avec 1 paramètre type int)
     * @param requete
     * @param index
     * @return
     * @throws SQLException
     */
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


    /***
     * Retourne une liste de int selon une requete SQL (avec 2 paramètre type int)
     * @param requete
     * @param index1
     * @param index2
     * @return
     * @throws SQLException
     */
    public int fill_int_param_double(String requete, int index1, int index2) throws SQLException {

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, index1);
        param_stmt.setInt(2, index2);

        // récupération de l'ordre de la requete
        rset = param_stmt.executeQuery();

        while (rset.next()) {
            return rset.getInt(1);
        }
        return 0;

    }


    /***
     * Retourne un Blob selon une requete SQL (avec 1 paramètre type Int)
     * @param requete
     * @param index
     * @return
     * @throws SQLException
     */
    public Blob fill_blob_param(String requete, int index) throws SQLException {

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, index);

        // récupération de l'ordre de la requete
        rset = param_stmt.executeQuery();

        while (rset.next()) {
            return rset.getBlob(1);
        }
        return null;
    }


    /***
     * Retourne un int unique selon une requete SQL (avec 1 paramètre type String)
     * @param requete
     * @param word
     * @return
     * @throws SQLException
     */
    public int fill_int_param_String(String requete, String word) throws SQLException {
        param_stmt =conn.prepareStatement(requete);
        param_stmt.setString(1, word);

        // récupération de l'ordre de la requete
        rset = param_stmt.executeQuery();

        while (rset.next()) {
            return rset.getInt(1);
        }
        return 0;

    }


    /***
     * Retourne une String unique selon une requete SQL (avec 1 paramètre type int)
     * @param requete
     * @param index
     * @return
     * @throws SQLException
     */
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


    /***
     * Retourne un double unique selon une requete SQL (avec 1 paramètre type int)
     * @param requete
     * @param index
     * @return
     * @throws SQLException
     */
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


    /***
     * Mettre à jour la BDD selon une requete SQL
     * @param requeteMaj
     * @throws SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }


    /***
     * Mettre à jour la BDD selon une requete SQL (avec 1 paramètre type int)
     * @param requete
     * @param index
     * @throws SQLException
     */
    public void param_executeUpdate(String requete, int index) throws SQLException {
        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, index);

        param_stmt.executeUpdate();

    }


    /***
     * Mettre à jour la BDD selon une requete SQL (avec 2 paramètres type int)
     * @param requete
     * @param index1
     * @param index2
     * @throws SQLException
     */
    public void param_two_executeUpdate(String requete, int index1, int index2) throws SQLException {
        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, index1);
        param_stmt.setInt(2, index2);

        param_stmt.executeUpdate();

    }


    /***
     * Ajouter un vol dans la BDD grace à une requete SQL
     * @param requete
     * @param ville_depart
     * @param ville_arrive
     * @param date_depart
     * @param date_arrive
     * @param heure_depart
     * @param heure_arrive
     * @throws SQLException
     */
    public void executeinsert_vol(String requete, String ville_depart, String ville_arrive,
                                  String date_depart, String date_arrive,
                                  String heure_depart, String heure_arrive) throws SQLException {
        param_stmt =conn.prepareStatement(requete);
        param_stmt.setString(1, ville_depart);
        param_stmt.setString(2, ville_arrive);
        param_stmt.setString(3, date_depart);
        param_stmt.setString(4, date_arrive);
        param_stmt.setString(5, heure_depart);
        param_stmt.setString(6, heure_arrive);


        param_stmt.executeUpdate();

    }


    /***
     * Ajouter un billet dans la BDD grace à une requete SQL
     * @param requete
     * @param fk_vol
     * @param cout
     * @param reduction
     * @param nombre_billet
     * @throws SQLException
     */
    public void executeinsert_billet(String requete, int fk_vol, double cout,
                                     double reduction, int nombre_billet) throws SQLException {
        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, fk_vol);
        param_stmt.setDouble(2, cout);
        param_stmt.setDouble(3, reduction);
        param_stmt.setInt(4, nombre_billet);

        param_stmt.executeUpdate();

    }


    /***
     * Ajouter une réservation dans la BDD grace à une requete SQL
     * @param requete
     * @param fk_vol
     * @param fk_client
     * @throws SQLException
     */
    public void executeinsert_reservation (String requete, int fk_vol, int fk_client) throws SQLException {

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, fk_vol);
        param_stmt.setInt(2, fk_client);

        param_stmt.executeUpdate();
    }


    /***
     * Mettre à jour Vol selon une requete SQL et son id
     * @param requete
     * @param ville_depart
     * @param ville_arrive
     * @param date_depart
     * @param date_arrive
     * @param heure_depart
     * @param heure_arrive
     * @param vol_dispo
     * @param id_vol
     * @throws SQLException
     */
    public void executeupdate_vol(String requete, String ville_depart, String ville_arrive,
                                  String date_depart, String date_arrive,
                                  String heure_depart, String heure_arrive, int vol_dispo, int id_vol) throws SQLException {
        param_stmt =conn.prepareStatement(requete);
        param_stmt.setString(1, ville_depart);
        param_stmt.setString(2, ville_arrive);
        param_stmt.setString(3, date_depart);
        param_stmt.setString(4, date_arrive);
        param_stmt.setString(5, heure_depart);
        param_stmt.setString(6, heure_arrive);
        param_stmt.setInt(7, vol_dispo);
        param_stmt.setInt(8, id_vol);


        param_stmt.executeUpdate();

    }


    /***
     * Mettre à jour Client selon une requete SQL et son id
     * @param requete
     * @param nom
     * @param prenom
     * @param username
     * @param password
     * @param age
     * @param solde
     * @param membre
     * @param id_client
     * @throws SQLException
     */
    public void executeupdate_client(String requete, String nom, String prenom,
                              String username,
                              String password,
                              int age, double solde,  int membre, int id_client) throws SQLException {

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setString(1, nom);
        param_stmt.setString(2, prenom);
        param_stmt.setString(3, username);
        param_stmt.setString(4, password);
        param_stmt.setInt(5, age);
        param_stmt.setDouble(6, solde);
        param_stmt.setInt(7, membre);
        param_stmt.setInt(8, id_client);

        param_stmt.executeUpdate();
    }


    /***
     * Mettre à jour Billet selon une requete SQL et son id
     * @param requete
     * @param var
     * @param id_billet
     * @throws SQLException
     */
    public void executeupdate_billet(String requete,
                                     int var,int id_billet) throws SQLException {

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, var);
        param_stmt.setInt(2, id_billet);

        param_stmt.executeUpdate();
    }


    /***
     * Mettre à jour le cout et la reduction Billet selon une requete SQL et son id
     * @param requete
     * @param cout
     * @param reduction
     * @param fk_vol
     * @throws SQLException
     */
    public void executeupdate_coutreduc_billet(String requete,
                                     double cout,double reduction, int fk_vol) throws SQLException {

        param_stmt =conn.prepareStatement(requete);
        param_stmt.setDouble(1, cout);
        param_stmt.setDouble(2, reduction);
        param_stmt.setInt(3, fk_vol);

        param_stmt.executeUpdate();
    }


    /***
     * Mettre à jour une table selon une requete SQL et son id
     * @param requete
     * @param index
     * @throws SQLException
     */
    public void executeupdate_param(String requete, int index) throws SQLException {
        param_stmt =conn.prepareStatement(requete);
        param_stmt.setInt(1, index);

        param_stmt.executeUpdate();
    }


    /***
     * Ajouter un Client à la table grace à une requete SQL
     * @param requete
     * @param nom
     * @param prenom
     * @param username
     * @param password
     * @param age
     * @param solde
     * @param membre
     * @throws SQLException
     */
    public void executeinsert_client(String requete,  String nom, String prenom,
                                     String username, String password,
                                     int age, double solde, int membre) throws SQLException {
        param_stmt =conn.prepareStatement(requete);
        param_stmt.setString(1, nom);
        param_stmt.setString(2, prenom);
        param_stmt.setString(3, username);
        param_stmt.setString(4,password);
        param_stmt.setInt(5, age);
        param_stmt.setDouble(6, solde);
        param_stmt.setInt(7, membre);


        param_stmt.executeUpdate();

    }


    /***
     * Ferme La connexion
     * @throws SQLException
     */
    public void clear_connexion() throws SQLException {
       conn.close();
       stmt.close();
       param_stmt.close();
       rset.close();
    }

}
