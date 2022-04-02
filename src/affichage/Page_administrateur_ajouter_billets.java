package affichage;

import Modele.Ajout_billet;
import Modele.Modifier_billet;
import jdbc2020.Listes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_administrateur_ajouter_billets extends JFrame {
    private JTextField Tf_cout_eco;
    private JTextField Tf_reduc_eco;
    private JTextField Tf_cout_affaire;
    private JTextField Tf_reduc_affaire;
    private JTextField Tf_cout_royal;
    private JTextField Tf_reduc_royal;
    private JButton Button_valider;
    private JTextField Tf_nb_eco;
    private JTextField Tf_nb_royal;
    private JTextField Tf_nb_affaire;
    private JPanel Menu_ajouter_billet;

    public Page_administrateur_ajouter_billets (int id_du_vol) throws SQLException, ClassNotFoundException {
        Listes l = new Listes();
        Ajout_billet ajout = new Ajout_billet(id_du_vol);
        setContentPane(Menu_ajouter_billet);
        setTitle("Page ajout de billlets");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        Button_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ajout.Ajouter_billets(Integer.parseInt(Tf_nb_eco.getText()),Integer.parseInt(Tf_nb_affaire.getText()),Integer.parseInt(Tf_nb_royal.getText()),
                            Double.parseDouble(Tf_cout_eco.getText()), Double.parseDouble(Tf_cout_affaire.getText()),Double.parseDouble(Tf_cout_royal.getText()),
                            Double.parseDouble(Tf_reduc_eco.getText()),Double.parseDouble(Tf_reduc_affaire.getText()), Double.parseDouble(Tf_reduc_royal.getText()));
                    dispose();
                    Page_administrateur p = new Page_administrateur();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
