package affichage;

import javax.swing.*;

public class Page_administrateur extends JFrame {
    private JPanel Menu_admin;
    private JLabel Label_menu_admin;
    private JButton Button_valider;
    private JButton Button_quitter;

    public Page_administrateur ()
    {
        setContentPane(Menu_admin);
        setTitle("Page d'acceuil");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
