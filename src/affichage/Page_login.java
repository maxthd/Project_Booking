package affichage;

import jdbc2020.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page_login extends JFrame {
    private JPanel Menu_login;
    private JTextField Tf_identifiant;
    private JLabel Label_mdp;
    private JLabel Label_id;
    private JTextField Tf_mdp;
    private JButton Button_valider;
    private JButton Button_quitter;

    public Page_login ()
    {
        setContentPane(Menu_login);
        setTitle("Page d'acceuil");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Button_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("!."+Tf_identifiant.getText()+".!");
                if (Tf_identifiant.getText().equals("admin"))
                {
                    dispose();
                    Page_administrateur p= new Page_administrateur();
                }
                else
                {
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
