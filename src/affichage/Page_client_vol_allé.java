package affichage;

import Modele.Achat_billet;
import jdbc2020.Listes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_client_vol_allé extends JFrame {

    private JList List_vols;
    private JTextField Tf_id_vol;
    private JComboBox Combobox_classe;
    private JButton Button_valider;
    private JButton Button_quitter;
    private JPanel Menu_client_vol_allé;
    DefaultListModel DLM =new DefaultListModel();

    public Page_client_vol_allé (int id_client,String départ, String arrivée) throws SQLException, ClassNotFoundException
    {
        Listes l = new Listes();
        setContentPane(Menu_client_vol_allé);
        setTitle("Page selection du vol");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Combobox_classe.addItem("Economique");
        Combobox_classe.addItem("Affaire");
        Combobox_classe.addItem("Royale");
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
        List_vols.setModel(DLM);
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
                    Achat_billet achat= new Achat_billet(Integer.parseInt(Tf_id_vol.getText()));
                    achat.Acheter_billet(Combobox_classe.getSelectedIndex()+1,id_client);
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
