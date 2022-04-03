package Vue;
import Controleur.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_inscription extends JFrame {
    private JPanel Menu_inscription;
    private JLabel Label_username;
    private JTextField Tf_username;
    private JLabel Label_mdp;
    private JLabel Label_nom;
    private JTextField Tf_nom;
    private JTextField Tf_mdp;
    private JLabel Label_prenom;
    private JTextField Tf_prenom;
    private JLabel Label_age;
    private JTextField Tf_age;
    private JLabel Label_solde;
    private JTextField Tf_solde;
    private JCheckBox CheckBox_membre;
    private JLabel Label_Inscription;
    private JButton Button_valider;
    private JButton Button_retour;
    private Inscription inscription;

    /***
     * La page pour s'inscrire en tant que client
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_inscription () throws SQLException, ClassNotFoundException {
        inscription = new Inscription();
        setContentPane(Menu_inscription);
        setTitle("Page d'inscription");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Button_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (inscription.Is_empty(Tf_nom.getText(),Tf_prenom.getText(),Tf_username.getText(),
                        Tf_mdp.getText(), Tf_age.getText(),Tf_solde.getText()))
                {
                    try {
                        inscription.Ajout_client(Tf_nom.getText(), Tf_prenom.getText(), Tf_username.getText(),
                                Tf_mdp.getText(),Integer.parseInt(Tf_age.getText()), Double.parseDouble(Tf_solde.getText()),
                                inscription.Valeur_checkbox(CheckBox_membre.isSelected()));
                        dispose();
                        Page_acceuil ac = new Page_acceuil();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        Button_retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Page_acceuil p= new Page_acceuil();
            }
        });
    }
}
