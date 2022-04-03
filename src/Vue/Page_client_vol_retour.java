package Vue;

import Controleur.Achat_billet;
import Controleur.Choix_vol;
import Controleur.Listes;
import Modele.Vol;

import javax.swing.*;
import java.awt.Font;
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
    private JComboBox Combobox_classe_retour;
    private JLabel Label_solde;
    private JLabel Label_initial_allé;
    private JLabel Label_reduc_allé;
    private JLabel Label_final_allé;
    private JLabel Label_initial_retout;
    private JLabel Label_reduc_retour;
    private JLabel Label_final_retour;
    private JButton Button_prix;
    private boolean valid=false;
    DefaultListModel DLM =new DefaultListModel();
    DefaultListModel DLM2 =new DefaultListModel();

    /***
     * Affiche les vols pour un aller-retour entre une ville A et une ville B
     * @param id_client
     * @param départ
     * @param arrivée
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_client_vol_retour (int id_client,String départ, String arrivée) throws SQLException, ClassNotFoundException
    {
        Achat_billet achat_billet_get_client = new Achat_billet(0);
        List_vols_allé.setFont(new Font("Arial",Font.BOLD,14));
        List_vols_retour.setFont(new Font("Arial",Font.BOLD,14));
        ArrayList<Integer> tab_id1 = new ArrayList();
        ArrayList<Integer> tab_id2 = new ArrayList();
        Listes l = new Listes();

        Label_solde.setText(String.valueOf(achat_billet_get_client.getsolde_client(id_client)));
        Choix_vol choix_vol1=new Choix_vol(départ, arrivée);
        Choix_vol choix_vol2=new Choix_vol(arrivée, départ);

        ArrayList<Vol> vols_aller=choix_vol1.get_vols();
        ArrayList<Vol> vols_retour=choix_vol2.get_vols();
        setContentPane(Menu_vol_retour);
        setTitle("Page selection des vols allers-retours");
        setSize(1500,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        Combobox_classe_allé.addItem("Economique");
        Combobox_classe_allé.addItem("Affaire");
        Combobox_classe_allé.addItem("Premium");
        Combobox_classe_retour.addItem("Economique");
        Combobox_classe_retour.addItem("Affaire");
        Combobox_classe_retour.addItem("Premium");
        for (int i=0;i<vols_aller.size();i++)
        {
            String o = vols_aller.get(i).getVille_depart() + " -> " + vols_aller.get(i).getVille_arrive() +
                    "   Départ " + vols_aller.get(i).getDate_depart() + " à " +
                    vols_aller.get(i).getHeure_depart() + "   Arrivée " + vols_aller.get(i).getDate_arrive()+ " à " +
                    vols_aller.get(i).getHeure_arrive();
            tab_id1.add(l.getVols().get(i).getId_vol());
            DLM.addElement(o);
        }
        List_vols_allé.setModel(DLM);
        for (int i=0;i<vols_retour.size();i++)
        {
            String o = vols_retour.get(i).getVille_depart() + " -> " + vols_retour.get(i).getVille_arrive() +
                    "   Départ " + vols_retour.get(i).getDate_depart() + " à " +
                    vols_retour.get(i).getHeure_depart() + "   Arrivée " + vols_retour.get(i).getDate_arrive()+ " à " +
                    vols_retour.get(i).getHeure_arrive();
            tab_id2.add(l.getVols().get(i).getId_vol());
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
                int index1=List_vols_allé.getSelectedIndex();
                int index2=List_vols_retour.getSelectedIndex();
                for(int i=0;i<l.getVols().size();i++) {
                    if (l.getVols().get(i).getId_vol()==tab_id1.get(index1)) {
                        for(int j=0;j<l.getVols().size();j++) {
                            if (l.getVols().get(j).getId_vol()==tab_id2.get(index2)) {
                                try {
                                    Achat_billet achat_allé = new Achat_billet(tab_id1.get(index1));
                                    Achat_billet achat_retour = new Achat_billet(tab_id2.get(index2));

                                    if (achat_allé.getsolde_client(id_client)>=
                                            (achat_allé.getcout_original(Combobox_classe_allé.getSelectedIndex() + 1)
                                                    + achat_retour.getcout_original(Combobox_classe_retour.getSelectedIndex() + 1)
                                                    - (achat_allé.getreduction(Combobox_classe_allé.getSelectedIndex() + 1, id_client)
                                                       + achat_retour.getreduction(Combobox_classe_retour.getSelectedIndex() + 1, id_client)
                                                      ))) {
                                        valid = true;
                                        achat_allé.Acheter_billet(Combobox_classe_allé.getSelectedIndex() + 1, id_client);
                                        achat_retour.Acheter_billet(Combobox_classe_retour.getSelectedIndex() + 1, id_client);
                                    }
                                    if (valid==true) {
                                        dispose();
                                        Page_client page_client = new Page_client(id_client);
                                    }
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                } catch (ClassNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }
                }

                if (valid==false)
                    JOptionPane.showMessageDialog(new JFrame(), "Veuillez choisir vos vol " +
                            "en prenant en compte votre solde.");

            }
        });
        Button_prix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index1=List_vols_allé.getSelectedIndex();
                int index2=List_vols_retour.getSelectedIndex();
                for(int i=0;i<l.getVols().size();i++) {
                    if (l.getVols().get(i).getId_vol() == tab_id1.get(index1)) {
                        try {
                            Achat_billet achat = new Achat_billet(tab_id1.get(index1));
                            double prix_fin =  (achat.getcout_original(Combobox_classe_allé.getSelectedIndex() + 1)-achat.getreduction(Combobox_classe_allé.getSelectedIndex() + 1,id_client));
                            Label_final_allé.setText(Double.toString(prix_fin));
                            Label_initial_allé.setText(String.valueOf(achat.getcout_original(Combobox_classe_allé.getSelectedIndex() + 1)));
                            Label_reduc_allé.setText(String.valueOf(achat.getreduction(Combobox_classe_allé.getSelectedIndex() + 1,id_client)));
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }

                    }
                }
                for(int i=0;i<l.getVols().size();i++) {
                    if (l.getVols().get(i).getId_vol() == tab_id2.get(index2)) {
                        try {
                            Achat_billet achat = new Achat_billet(tab_id2.get(index2));
                            double prix_fin =  (achat.getcout_original(Combobox_classe_retour.getSelectedIndex() + 1)-achat.getreduction(Combobox_classe_retour.getSelectedIndex() + 1,id_client));
                            Label_final_retour.setText(Double.toString(prix_fin));
                            Label_initial_retout.setText(String.valueOf(achat.getcout_original(Combobox_classe_retour.getSelectedIndex() + 1)));
                            Label_reduc_retour.setText(String.valueOf(achat.getreduction(Combobox_classe_retour.getSelectedIndex() + 1,id_client)));
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
