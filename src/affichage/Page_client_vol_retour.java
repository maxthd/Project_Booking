package affichage;

import Modele.Achat_billet;
import jdbc2020.Listes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_client_vol_retour extends JFrame{
    private JList List_vols_allé;
    private JTextField Tf_id_vol_allé;
    private JComboBox Combobox_classe_allé;
    private JButton Button_valider;
    private JButton Button_quitter;
    private JPanel Menu_vol_retour;
    private JList List_vols_retour;
    private JTextField Tf_vol_retour;
    private JComboBox Combobox_classe_retour;
    DefaultListModel DLM =new DefaultListModel();
    DefaultListModel DLM2 =new DefaultListModel();

    public Page_client_vol_retour (int id_client,String départ, String arrivée) throws SQLException, ClassNotFoundException
    {
        Listes l = new Listes();
        setContentPane(Menu_vol_retour);
        setTitle("Page selection des vols allé-retours");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Combobox_classe_allé.addItem("Economique");
        Combobox_classe_allé.addItem("Affaire");
        Combobox_classe_allé.addItem("Royale");
        Combobox_classe_retour.addItem("Economique");
        Combobox_classe_retour.addItem("Affaire");
        Combobox_classe_retour.addItem("Royale");
        for (int i=0;i<l.getVols().size();i++)
        {
            if((départ.equals(l.getVols().get(i).getVille_depart()))&&(arrivée.equals(l.getVols().get(i).getVille_arrive())))
            {
                String o = "Vol " + Integer.toString(l.getVols().get(i).getId_vol()) + " " + l.getVols().get(i).getVille_depart() + " " +
                        l.getVols().get(i).getVille_arrive() + " départ " + l.getVols().get(i).getDate_depart() + " " + l.getVols().get(i).getHeure_depart()
                        + " arrivée " + l.getVols().get(i).getDate_arrive() + " " + l.getVols().get(i).getHeure_arrive();
                DLM.addElement(o);
            }
        }
        List_vols_allé.setModel(DLM);
        for (int i=0;i<l.getVols().size();i++)
        {
            if((arrivée.equals(l.getVols().get(i).getVille_depart()))&&(départ.equals(l.getVols().get(i).getVille_arrive())))
            {
                String o = "Vol " + Integer.toString(l.getVols().get(i).getId_vol()) + " " + l.getVols().get(i).getVille_depart() + " " +
                        l.getVols().get(i).getVille_arrive() + " départ " + l.getVols().get(i).getDate_depart() + " " + l.getVols().get(i).getHeure_depart()
                        + " arrivée " + l.getVols().get(i).getDate_arrive() + " " + l.getVols().get(i).getHeure_arrive();
                DLM2.addElement(o);
            }
        }
        List_vols_retour.setModel(DLM2);
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
        Button_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Achat_billet achat_allé= new Achat_billet(Integer.parseInt(Tf_id_vol_allé.getText()));
                    achat_allé.Acheter_billet(Combobox_classe_allé.getSelectedIndex()+1,id_client);
                    Achat_billet achat_retour= new Achat_billet(Integer.parseInt(Tf_vol_retour.getText()));
                    achat_retour.Acheter_billet(Combobox_classe_retour.getSelectedIndex()+1,id_client);
                    dispose();
                    Page_client page_client = new Page_client(id_client);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
