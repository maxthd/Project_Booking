package Vue;

import Controleur.Modifier_billet;
import Controleur.Listes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Page_administrateur_modifier_billets extends JFrame {
    private JPanel Menu_modif_billets;
    private JTextField Tf_cout_eco;
    private JTextField Tf_reduc_eco;
    private JTextField Tf_cout_affaire;
    private JTextField Tf_reduc_affaire;
    private JTextField Tf_cout_royal;
    private JTextField Tf_reduc_royal;
    private JButton Button_quitter;
    private JButton Button_valider;

    /***
     * Afficher la page pour modifier des billets (accessible seulement par un employé)
     * @param id_du_vol
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public Page_administrateur_modifier_billets(int id_du_vol) throws SQLException, ClassNotFoundException {
        Listes l = new Listes();
        Modifier_billet modif = new Modifier_billet(id_du_vol);
        setContentPane(Menu_modif_billets);
        setTitle("Modification de billlets");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i = 0; i < l.getVols().size(); i++) {
            if (l.getVols().get(i).getId_vol() == id_du_vol) {
                Tf_cout_eco.setText(Double.toString(modif.get_cout_eco()));
                Tf_reduc_eco.setText(Double.toString(modif.get_reduc_eco()));
                Tf_cout_affaire.setText(Double.toString(modif.get_cout_affaire()));
                Tf_reduc_affaire.setText(Double.toString(modif.get_reduc_affaire()));
                Tf_cout_royal.setText(Double.toString(modif.get_cout_premium()));
                Tf_reduc_royal.setText(Double.toString(modif.get_reduc_premium()));
            }
        }

        Button_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modif.Update_billet(Double.parseDouble(Tf_cout_eco.getText()), Double.parseDouble(Tf_reduc_eco.getText()), Double.parseDouble(Tf_cout_affaire.getText()),
                            Double.parseDouble(Tf_reduc_affaire.getText()), Double.parseDouble(Tf_cout_royal.getText()), Double.parseDouble(Tf_reduc_royal.getText()));
                    dispose();
                    Page_administrateur p = new Page_administrateur();
                } catch (SQLException ex) {
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

