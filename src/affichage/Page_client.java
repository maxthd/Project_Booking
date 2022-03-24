package affichage;

import javax.swing.*;

public class Page_client extends JFrame {
    private JLabel Label_page_client;
    private JLabel Label_lieux_d;
    private JTextField Tf_lieux_d;
    private JLabel Label_lieux_a;
    private JTextField tf_lieux_a;
    private JButton Button_Valider;
    private JButton Button_quitter;
    private JPanel Menu_client;

    public Page_client ()
    {
        setContentPane(Menu_client);
        setTitle("Page d'acceuil");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
