/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Code JDBC de Mr. SEGADO
//https://stackoverflow.com/questions/27053276/date-and-time-picker-in-java
package jdbc2020;

import java.sql.SQLException;


public class Main {
    public static void main(String[] s) throws SQLException, ClassNotFoundException {

        //test_classe_Listes();
        System.out.println("Main:");
        Listes L=new Listes();
        L.Afficher_listes();



        //Fenetre f1 = new Fenetre();
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
    }

}
