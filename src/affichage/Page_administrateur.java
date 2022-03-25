package affichage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
