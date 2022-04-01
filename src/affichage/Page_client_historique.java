package affichage;

import Modele.Historique_client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_client_historique extends JFrame {
    private JList List_histo;
    private JButton Button_quitter;
    private JPanel Menu_historique;
    DefaultListModel DLM =new DefaultListModel();

    public Page_client_historique(int id_client) throws SQLException, ClassNotFoundException
    {
        Historique_client historique_client = new Historique_client();
        setContentPane(Menu_historique);
        setTitle("Page historique");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i=0; i<historique_client.get_historique().size();i++)
        {
            String o="Vol "+Integer.toString(historique_client.get_historique().get(i).getId_vol())+" "+historique_client.get_historique().get(i).getVille_depart()+ " "+
                    historique_client.get_historique().get(i).getVille_arrive()+" départ "+historique_client.get_historique().get(i).getDate_depart()+" "+historique_client.get_historique().get(i).getHeure_depart()
                    +" arrivée "+ historique_client.get_historique().get(i).getDate_arrive()+" "+historique_client.get_historique().get(i).getHeure_arrive();
            DLM.addElement(o);
        }
        List_histo.setModel(DLM);
        Button_quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Page_client p= new Page_client(id_client);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
