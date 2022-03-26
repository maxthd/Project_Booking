package affichage;

import jdbc2020.*;
import Modele.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_login extends JFrame {
    private JPanel Menu_login;
    private JTextField Tf_identifiant;
    private JLabel Label_mdp;
    private JLabel Label_id;
    private JTextField Tf_mdp;
    private JButton Button_valider;
    private JButton Button_quitter;
    private Listes lis;
    private Login log;

    public Page_login () throws SQLException, ClassNotFoundException {
        lis=new Listes();
        log=new Login();

        setContentPane(Menu_login);
        setTitle("Page d'acceuil");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Button_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (log.Est_un_Employe(Tf_identifiant.getText(),Tf_mdp.getText(),lis))
                {
                    System.out.println("employe trouvé");
                    dispose();
                    Page_administrateur p= new Page_administrateur();
                }
                if (log.Est_un_client(Tf_identifiant.getText(),Tf_mdp.getText(),lis))
                {
                    System.out.println("client trouvé");
                    dispose();
                    Page_client p= new Page_client();
                }
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
