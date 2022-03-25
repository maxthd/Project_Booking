package affichage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Page_acceuil extends JFrame
{
    private JButton ConnexionButton;
    private JButton InscriptionButton;
    private JButton QuitterButton;
    private JPanel menu;
    private JLabel action;
    private JLabel titre;

    private int i=0;

    public Page_acceuil()
    {
        setContentPane(menu);
        setTitle("Page d'acceuil");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);


        ConnexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Page_login p= new Page_login();
            }
        });
        InscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Page_inscription p= new Page_inscription();
            }
        });
        QuitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }




}