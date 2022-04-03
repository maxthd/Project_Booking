package affichage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_client extends JFrame {
    private JLabel Label_page_client;
    private JLabel Label_lieux_d;
    private JTextField Tf_lieux_d;
    private JLabel Label_lieux_a;
    private JTextField Tf_lieux_a;
    private JButton Button_Valider;
    private JButton Button_quitter;
    private JPanel Menu_client;
    private JButton Button_historique;
    private JButton Button_paramètre;
    private JComboBox Combobox_allé_retour;


    /***
     * Afficher le 'menu' du client
     * @param id_client
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_client (int id_client)  throws SQLException, ClassNotFoundException
    {

        setContentPane(Menu_client);
        setTitle("Page Client");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Combobox_allé_retour.addItem("Aller");
        Combobox_allé_retour.addItem("Aller-retour");
        Button_quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Page_acceuil p= new Page_acceuil();
            }
        });
        Button_Valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Combobox_allé_retour.getSelectedIndex()==0)
                {
                    System.out.println("vol aller");
                    dispose();
                    try {
                        Page_client_vol_allé pca = new Page_client_vol_allé(id_client,Tf_lieux_d.getText(),Tf_lieux_a.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
                if (Combobox_allé_retour.getSelectedIndex()==1)
                {
                    System.out.println("vol aller");
                    dispose();
                    try {
                        Page_client_vol_retour pcar = new Page_client_vol_retour(id_client,Tf_lieux_d.getText(),Tf_lieux_a.getText());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        Button_historique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Page_client_historique p = new Page_client_historique(id_client);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Button_paramètre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Page_client_paramètres p = new Page_client_paramètres(id_client);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
