package affichage;

import javax.swing.*;


public class Acceuil extends JFrame
{
    private JButton ConnexionButton;
    private JButton InscriptionButton;
    private JButton QuitterButton;
    private JPanel menu;
    private JLabel action;
    private JLabel titre;

    private int i=0;

    public  Acceuil ()
    {
        setContentPane(menu);
        setTitle("Page d'acceuil");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }




}