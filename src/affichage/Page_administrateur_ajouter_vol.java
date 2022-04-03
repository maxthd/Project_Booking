package affichage;

import Modele.Ajout_vol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_administrateur_ajouter_vol extends JFrame {
    private JPanel Menu_ajouter_vol;
    private JTextField Tf_ville_d;
    private JTextField Tf_date_d;
    private JTextField Tf_heure_d;
    private JTextField Tf_ville_a;
    private JTextField Tf_date_a;
    private JTextField Tf_heure_a;
    private JButton Button_quitter;
    private JButton Button_valider;


    /***
     * Afficher la page pour ajouter des vols (accessible seulement par les employés)
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_administrateur_ajouter_vol () throws SQLException, ClassNotFoundException
    {
        Ajout_vol ajout = new Ajout_vol();
        setContentPane(Menu_ajouter_vol);
        setTitle("Page ajout de vol");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        Button_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ajout.Insert_Vol(Tf_ville_d.getText(),Tf_ville_a.getText(),Tf_date_d.getText(),Tf_date_a.getText(),Tf_heure_d.getText(),Tf_heure_a.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                dispose();
                try {
                    Page_administrateur_ajouter_billets p = new Page_administrateur_ajouter_billets(ajout.get_id_lastvol());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Button_quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Page_administrateur p = new Page_administrateur();
            }
        });
    }
}
