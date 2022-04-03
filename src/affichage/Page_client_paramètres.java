package affichage;

import Modele.Modifier_client;
import jdbc2020.Listes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_client_paramètres extends JFrame {
    private JTextField Tf_nom;
    private JTextField Tf_prénom;
    private JTextField Tf_username;
    private JTextField Tf_mdp;
    private JTextField Tf_age;
    private JTextField Tf_solde;
    private JTextField Tf_membre;
    private JButton Button_Quitter;
    private JButton Button_valider;
    private JPanel Menu_parametre_client;
    private JButton Button_supprimer;
    Listes l;

    /***
     * Affiche la page des paramètres du clients
     * @param id_du_client
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_client_paramètres (int id_du_client) throws SQLException, ClassNotFoundException
    {
        l = new Listes();
        Modifier_client modif = new Modifier_client();
        setContentPane(Menu_parametre_client);
        setTitle("modification de client");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i=0;i<l.getClients().size();i++)
        {
            if (l.getClients().get(i).getId_client()==id_du_client)
            {
                Tf_age.setText(Integer.toString(l.getClients().get(i).getAge()));
                Tf_mdp.setText(l.getClients().get(i).getPassword());
                Tf_membre.setText(Double.toString(l.getClients().get(i).getMembre()));
                Tf_nom.setText(l.getClients().get(i).getNom());
                Tf_prénom.setText(l.getClients().get(i).getPrenom());
                Tf_solde.setText(Double.toString(l.getClients().get(i).getSolde()));
                Tf_username.setText(l.getClients().get(i).getUsername());
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
                    Page_client p = new Page_client(id_du_client);
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
                    Page_client p = new Page_client(id_du_client);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Button_supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modif.Delete_client(id_du_client);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                dispose();
                Page_acceuil p = new Page_acceuil();
            }
        });
    }
}
