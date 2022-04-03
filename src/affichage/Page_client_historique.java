package affichage;

import Modele.Historique_client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import jdbc2020.Vol;
import java.util.ArrayList;

public class Page_client_historique extends JFrame {
    private JList List_histo;
    private JButton Button_quitter;
    private JPanel Menu_historique;
    DefaultListModel DLM =new DefaultListModel();

    /***
     * Afficher la page avec l'historique du client
     * @param id_client
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_client_historique(int id_client) throws SQLException, ClassNotFoundException
    {
        Historique_client historique_client = new Historique_client(id_client);
        ArrayList<Vol> vols=historique_client.get_historique();

        setContentPane(Menu_historique);
        setTitle("Page historique");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i=0; i<vols.size();i++)
        {
            String o="Vol "+Integer.toString(vols.get(i).getId_vol())+" "+vols.get(i).getVille_depart()+ " "+
                    vols.get(i).getVille_arrive()+" départ "+vols.get(i).getDate_depart()+" "+vols.get(i).getHeure_depart()
                    +" arrivée "+ vols.get(i).getDate_arrive()+" "+vols.get(i).getHeure_arrive();
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
