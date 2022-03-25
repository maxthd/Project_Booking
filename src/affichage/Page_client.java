package affichage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Button_quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Page_acceuil p= new Page_acceuil();
            }
        });
    }
}
