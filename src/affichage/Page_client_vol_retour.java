package affichage;

import Modele.Achat_billet;
import Modele.Choix_vol;
import jdbc2020.Listes;
import jdbc2020.Vol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

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
        Listes lis = new Listes();
        Choix_vol choix_vol1=new Choix_vol(départ, arrivée);
        Choix_vol choix_vol2=new Choix_vol(arrivée, départ);

        ArrayList<Vol> vols_aller=choix_vol1.get_vols();
        ArrayList<Vol> vols_retour=choix_vol2.get_vols();
        setContentPane(Menu_vol_retour);
        setTitle("Page selection des vols allé-retours");
        setSize(1200,800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Combobox_classe_allé.addItem("Economique");
        Combobox_classe_allé.addItem("Affaire");
        Combobox_classe_allé.addItem("Royale");
        Combobox_classe_retour.addItem("Economique");
        Combobox_classe_retour.addItem("Affaire");
        Combobox_classe_retour.addItem("Royale");
        for (int i=0;i<vols_aller.size();i++)
        {
            String o = "Vol " + Integer.toString(vols_aller.get(i).getId_vol()) + " " +
                    vols_aller.get(i).getVille_depart() + " " + vols_aller.get(i).getVille_arrive() +
                    " départ " + vols_aller.get(i).getDate_depart() + " " +
                    vols_aller.get(i).getHeure_depart() + " arrivée " + vols_aller.get(i).getDate_arrive()+ " " +
                    vols_aller.get(i).getHeure_arrive();
            DLM.addElement(o);
        }
        List_vols_allé.setModel(DLM);
        for (int i=0;i<vols_retour.size();i++)
        {
            String o = "Vol " + Integer.toString(vols_retour.get(i).getId_vol()) + " " +
                    vols_retour.get(i).getVille_depart() + " " + vols_retour.get(i).getVille_arrive() +
                    " départ " + vols_retour.get(i).getDate_depart() + " " +
                    vols_retour.get(i).getHeure_depart() + " arrivée " + vols_retour.get(i).getDate_arrive()+ " " +
                    vols_retour.get(i).getHeure_arrive();
            DLM2.addElement(o);
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
                for(int i=0;i<l.getVols().size();i++) {
                    if (l.getVols().get(i).getId_vol() == Integer.parseInt(Tf_id_vol_allé.getText())) {
                        for(int j=0;j<l.getVols().size();j++) {
                            if (lis.getVols().get(j).getId_vol() == Integer.parseInt(Tf_vol_retour.getText())) {
                                try {
                                    Achat_billet achat_allé = new Achat_billet(Integer.parseInt(Tf_id_vol_allé.getText()));
                                    achat_allé.Acheter_billet(Combobox_classe_allé.getSelectedIndex() + 1, id_client);
                                    Achat_billet achat_retour = new Achat_billet(Integer.parseInt(Tf_vol_retour.getText()));
                                    achat_retour.Acheter_billet(Combobox_classe_retour.getSelectedIndex() + 1, id_client);
                                    dispose();
                                    Page_client page_client = new Page_client(id_client);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                } catch (ClassNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
