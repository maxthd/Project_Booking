package Vue;

import Modele.Connexion;

import java.sql.*;
import javax.swing.*;

public class ShowMyImage extends JFrame {
    public ShowMyImage() throws SQLException, ClassNotFoundException {
        super("Display an image from a MySQL DB");
        Connexion maconnexion = new Connexion("booking", "root", "");
        setSize(1300, 1300);
        //get the connection
        ImageIcon icone = maconnexion.fill_imageicon("SELECT picture FROM Image WHERE id_image = 1");
        JLabel l = new JLabel();
        l.setIcon(icone);
        add(l);
        setVisible(true);
    }
}