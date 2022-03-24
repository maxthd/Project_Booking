package affichage;

import javax.swing.*;

public class Page_inscription extends JFrame {
    private JPanel Menu_inscription;
    private JLabel Label_id;
    private JTextField Tf_id;
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

    public Page_inscription ()
    {
        setContentPane(Menu_inscription);
        setTitle("Page d'acceuil");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
