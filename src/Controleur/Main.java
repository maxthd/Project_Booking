/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Code JDBC de Mr. SEGADO
//https://stackoverflow.com/questions/27053276/date-and-time-picker-in-java
package Controleur;
import Vue.*;
import Modele.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;

//On a utilisé 4 librairies: mail.jar, jfreechart.jar, common.jar et mysqlconnector
//https://stackhowto.com/how-to-insert-and-retrieve-an-image-from-mysql-database-using-java/
//https://stackoverflow.com/questions/34328601/how-to-insert-images-in-blob-in-mysql-table-using-only-sql-syntax-without-php
//Code de Monsieur SEGADO JDBC
public class Main {
    public static void main(String[] s) throws SQLException, ClassNotFoundException, FileNotFoundException {


        /*Connexion maconnexion=new Connexion("booking", "root", "");
        maconnexion.execute_insertimage("INSERT INTO Image(picture) VALUES(?)",
                "F:/cours/cours d info/Java/Photos projet Java/Client.png");
                //"C:/Users/Abdelaziz/OneDrive/Bureau/client.png");*/

        Page_acceuil p = new Page_acceuil();

    }


}
