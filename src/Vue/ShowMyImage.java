package Vue;

import Modele.Connexion;

import java.sql.*;
import javax.swing.*;

public class ShowMyImage extends JFrame {
    public ShowMyImage() throws SQLException, ClassNotFoundException {
        super("Display an image from a MySQL DB");
        Connexion maconnexion = new Connexion("booking", "root", "");
        setSize(150, 99);
        //get the connection
        ImageIcon icone = maconnexion.fill_imageicon("SELECT picture FROM Image WHERE id_image = 1");
        JLabel l = new JLabel();
        l.setIcon(icone);
        add(l);
        //setVisible(true);
    }
    public ImageIcon renvoyer_icone ()
    {
        ImageIcon temp = new ImageIcon();
        Connexion maconnexion = null;
        try {
            maconnexion = new Connexion("booking", "root", "");
            ImageIcon icone = maconnexion.fill_imageicon("SELECT picture FROM Image WHERE id_image = 1");
            return  icone;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
}