package Vue;

import Controleur.Achat_billet;
import Controleur.Choix_vol;
import Controleur.Listes;
import Modele.Vol;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Page_client_vol_allé extends JFrame {

    private JList List_vols;
    private JTextField Tf_id_vol;
    private JComboBox Combobox_classe;
    private JButton Button_valider;
    private JButton Button_quitter;
    private JPanel Menu_client_vol_allé;
    private JLabel Label_solde;
    private JLabel Label_prix_init;
    private JLabel Label_reduction;
    private JLabel Label_prix_final;
    private JButton voirPrixButton;
    DefaultListModel DLM =new DefaultListModel();


    /***
     * Affiche les vols pour un aller simple d'une ville A à une ville B
     * @param id_client
     * @param départ
     * @param arrivée
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_client_vol_allé (int id_client,String départ, String arrivée) throws SQLException, ClassNotFoundException
    {
        List_vols.setFont(new Font("Arial",Font.BOLD,14));

        ArrayList<Integer> tab_id = new ArrayList();
        Listes l = new Listes();
        Choix_vol choix_vol=new Choix_vol(départ, arrivée);
        Achat_billet achat_billet_get_client = new Achat_billet(0);
        ArrayList<Vol> vols=choix_vol.get_vols();

        setContentPane(Menu_client_vol_allé);
        setTitle("Page selection du vol");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Combobox_classe.addItem("Economique");
        Combobox_classe.addItem("Affaire");
        Combobox_classe.addItem("Premium");
        Label_solde.setText(Double.toString(achat_billet_get_client.getsolde_client(id_client)));
        for (int i=0;i<vols.size();i++)
        {
                String o = vols.get(i).getVille_depart() + " -> " + vols.get(i).getVille_arrive() +
                        "   Départ " + vols.get(i).getDate_depart() + " à " +
                        vols.get(i).getHeure_depart() + "   Arrivée " + vols.get(i).getDate_arrive()+ " à " +
                        vols.get(i).getHeure_arrive();
                tab_id.add(l.getVols().get(i).getId_vol());
                DLM.addElement(o);
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
                int index=List_vols.getSelectedIndex();
                for(int i=0;i<l.getVols().size();i++) {
                    if (l.getVols().get(i).getId_vol()==tab_id.get(index)) {
                        try {
                            Achat_billet achat = new Achat_billet(tab_id.get(index));
                            achat.Acheter_billet(Combobox_classe.getSelectedIndex() + 1, id_client);
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
        });
        voirPrixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=List_vols.getSelectedIndex();
                for(int i=0;i<l.getVols().size();i++) {
                    if (l.getVols().get(i).getId_vol() == tab_id.get(index)) {
                        try {
                            Achat_billet achat = new Achat_billet(tab_id.get(index));
                            int prix_fin = (int) (achat.getcout_original(Combobox_classe.getSelectedIndex() + 1)-achat.getreduction(Combobox_classe.getSelectedIndex() + 1,id_client));
                            Label_prix_final.setText(Integer.toString(prix_fin));
                            Label_prix_init.setText(String.valueOf(achat.getcout_original(Combobox_classe.getSelectedIndex() + 1)));
                            Label_reduction.setText(String.valueOf(achat.getreduction(Combobox_classe.getSelectedIndex() + 1,id_client)));
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }

                    }
                }
            }

        });
    }
}
