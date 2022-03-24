package affichage;

import javax.swing.*;

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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
