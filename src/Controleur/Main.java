/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Code JDBC de Mr. SEGADO
//https://stackoverflow.com/questions/27053276/date-and-time-picker-in-java
package Controleur;
import Vue.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;

//POUR CHARGER UNE IMAGE
/**https://stackhowto.com/how-to-insert-and-retrieve-an-image-from-mysql-database-using-java/
 * https://stackoverflow.com/questions/34328601/how-to-insert-images-in-blob-in-mysql-table-using-only-sql-syntax-without-php
 * */
public class Main {
    public static void main(String[] s) throws SQLException, ClassNotFoundException, FileNotFoundException {

        Page_acceuil p = new Page_acceuil();


        System.out.println("test");

        /* LE CODE A APPELER POUR ENVOYER DES MAILS!! FAUT AJOUTER LA LIBRAIRIE mail.Jar
        SendEmail.send("projetbooking55@gmail.com","Projetbooking55.",
                "galiazzogioiamariasoleeeeeeeeeeeeeeeeeeeeeeee@gmail.com","Bonjour","IJUSTE");
         */


        /*CECI EST A APPELE POUR INSERER LES VALEURS DE IMAGES DANS TABLEAU
        JE PR2CISE QU IL FAUT QUE LE CHEMIN CORRESPONDENT A L EMPLACEMENT DE VOTRE IMAGE*/
/*
        Connexion maconnexion=new Connexion("booking", "root", "");
        maconnexion.execute_insertimage("INSERT INTO Image(picture) VALUES(?)",
                "C:/Users/Abdelaziz/OneDrive/Bureau/chat.png");

        //CECI EST POUR AFFICHER L IMAGE
        new ShowMyImage();
        */



    }


}
