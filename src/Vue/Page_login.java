package Vue;

import Controleur.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_login extends JFrame {
    private JPanel Menu_login;
    private JTextField Tf_identifiant;
    private JLabel Label_mdp;
    private JLabel Label_id;
    private JButton Button_valider;
    private JButton Button_quitter;
    private JPasswordField passwordField_mdp;
    private Listes lis;
    private Login log;
    private boolean valid=false;

    /***
     * Page pour se connecter à son compte
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_login () throws SQLException, ClassNotFoundException {
        lis=new Listes();
        log=new Login(lis);

        System.out.println(valid);
        setContentPane(Menu_login);
        setTitle("Page login");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Button_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (log.Est_un_Employe(Tf_identifiant.getText(),passwordField_mdp.getText()))
                {
                    System.out.println("employe trouvé");
                    dispose();
                    Page_administrateur p= new Page_administrateur();
                    valid=true;
                }
                if (log.Est_un_client(Tf_identifiant.getText(),passwordField_mdp.getText()))
                {
                    System.out.println("client trouvé");
                    dispose();
                    try {
                        Page_client p= new Page_client(log.id_du_client(Tf_identifiant.getText(),passwordField_mdp.getText()));
                        valid=true;
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
                if (valid==false)
                JOptionPane.showMessageDialog(new JFrame(), "Erreur de saisi");
            }
        });
        Button_quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Page_acceuil p= new Page_acceuil();
            }
        });
    }
}
