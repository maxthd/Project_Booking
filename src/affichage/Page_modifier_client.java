package affichage;

import Modele.Modifier_client;
import jdbc2020.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_modifier_client extends JFrame {
    private JPanel Menu_modification_client;
    private JLabel Label_nom;
    private JTextField Tf_nom;
    private JLabel Label_prénom;
    private JTextField Tf_prénom;
    private JLabel Label_username;
    private JTextField Tf_username;
    private JLabel Label_mdp;
    private JTextField Tf_mdp;
    private JLabel Label_age;
    private JTextField Tf_age;
    private JLabel Label_solde;
    private JTextField Tf_solde;
    private JButton Button_Quitter;
    private JButton Button_valider;
    private JLabel Label_membre;
    private JTextField Tf_membre;
    private JPanel Menu_modification_du_client;
    private JButton Button_supprimer_client;
    Listes l;

    /***
     * Affiche la page pour modifier les paramètres du client
     * @param id_du_client
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_modifier_client (int id_du_client) throws SQLException, ClassNotFoundException
    {
        l = new Listes();
        Modifier_client modif = new Modifier_client();
        setContentPane(Menu_modification_du_client);
        setTitle("modification de client");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i=0;i<l.getClients().size();i++)
        {
            if (l.getClients().get(i).getId_client()==id_du_client)
            {
                Label_age.setText(Integer.toString(l.getClients().get(i).getAge()));
                Label_mdp.setText(l.getClients().get(i).getPassword());
                Label_membre.setText(Double.toString(l.getClients().get(i).getMembre()));
                Label_nom.setText(l.getClients().get(i).getNom());
                Label_prénom.setText(l.getClients().get(i).getPrenom());
                Label_solde.setText(Double.toString(l.getClients().get(i).getSolde()));
                Label_username.setText(l.getClients().get(i).getUsername());
            }
        }
        Button_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   modif.Update_client(id_du_client, Tf_nom.getText(),Tf_prénom.getText(),Tf_username.getText(),Tf_mdp.getText(),
                            Integer.parseInt(Tf_age.getText()),Double.parseDouble(Tf_solde.getText()),Integer.parseInt(Tf_membre.getText()));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                dispose();
                try {
                    Page_client_admin pc= new Page_client_admin();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Button_Quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Page_client_admin p = new Page_client_admin();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Button_supprimer_client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modif.Delete_client(id_du_client);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                dispose();
                Page_administrateur p = new Page_administrateur();
            }
        });
    }

}
