/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Code JDBC de Mr. SEGADO
//https://stackoverflow.com/questions/27053276/date-and-time-picker-in-java
package jdbc2020;
import affichage.*;
import Modele.*;

import java.sql.SQLException;

//POUR CHARGER UNE IMAGE
/**https://stackhowto.com/how-to-insert-and-retrieve-an-image-from-mysql-database-using-java/
 * */
public class Main {
    public static void main(String[] s) throws SQLException, ClassNotFoundException
    {
        Page_acceuil c = new Page_acceuil();


    }

    public static void test_classe_Listes() throws SQLException, ClassNotFoundException {
        Listes L=new Listes();
        System.out.println("LA LISTE AU DEBUT");
        L.Afficher_listes();
        L=L.Update_listes("INSERT INTO Billet (fk_vol, cout, reduction, billet_dispo) VALUES (2, 30, 50, TRUE);");
        System.out.println("ON  AJOUTE UN BILLET");
        L.Afficher_listes();
        L=L.param_update_listes("DELETE FROM Billet WHERE id_billet= ?", 3);
        System.out.println("ON DELETE LE BILLET 3 (EN UTILISANT Param) ");
        L.Afficher_listes();
        L=L.Update_listes("UPDATE Billet SET billet_dispo=0  WHERE id_billet=2");
        System.out.println("ON UPDATE LE BILLET");
        L.Afficher_listes();

        L=L.param_two_update_listes("UPDATE Billet SET billet_dispo=0  WHERE fk_vol=? AND reduction= ?", 2, 50);
        System.out.println("ON UPDATE LE BILLET(EN UTILISANT DEUX Param)");
        L.Afficher_listes();
    }

}
