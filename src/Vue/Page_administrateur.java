package Vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_administrateur extends JFrame {
    private JPanel Menu_admin;
    private JLabel Label_menu_admin;
    private JButton Button_quitter;
    private JButton Button_modif_vols;
    private JButton Button_modif_clients;

    /***
     * Afficher le 'menu' des employés
     */
    public Page_administrateur ()
    {
        setContentPane(Menu_admin);
        setTitle("Page Menu administrateur");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Button_quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Page_acceuil p= new Page_acceuil();
            }
        });
        Button_modif_vols.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose ();
                try {
                    Page_vol_admin p = new Page_vol_admin();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Button_modif_clients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose ();
                try {
                    Page_client_admin cli = new Page_client_admin();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
