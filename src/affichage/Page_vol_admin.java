package affichage;
import jdbc2020.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class Page_vol_admin extends JFrame  {
    private JList List_vols_id;
    private JTextField Tf_id_vol;
    private JButton Button_modifier;
    private JButton Button_modifier_vol;
    private JButton Button_quitter;
    private JPanel Menu_vol_admin;
    private JScrollPane Scrollpane_liste_vols;
    private JButton Button_modifier_billets;
    private JButton Button_stat;
    DefaultListModel DLM =new DefaultListModel();


    /***
     * Afficher la page pour récuperer la liste des vols (accessible seulement par les employés)
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_vol_admin () throws SQLException, ClassNotFoundException {
        ArrayList<Integer> tab_id = new ArrayList();
        Listes l=new Listes();
        setContentPane(Menu_vol_admin);
        setTitle("Page d'acceuil");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i=0;i<l.getVols().size();i++)
        {
            String o="Vol "+Integer.toString(l.getVols().get(i).getId_vol())+" "+l.getVols().get(i).getVille_depart()+ " "+
                    l.getVols().get(i).getVille_arrive()+" départ "+l.getVols().get(i).getDate_depart()+" "+l.getVols().get(i).getHeure_depart()
                    +" arrivée "+ l.getVols().get(i).getDate_arrive()+" "+l.getVols().get(i).getHeure_arrive();
            tab_id.add(l.getVols().get(i).getId_vol());
            DLM.addElement(o);
        }
        List_vols_id.setModel(DLM);
        Button_quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                Page_administrateur p= new Page_administrateur();
            }
        });
        Button_modifier_vol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=List_vols_id.getSelectedIndex();
                for(int i=0;i<l.getVols().size();i++)
                {
                    if (l.getVols().get(i).getId_vol()==tab_id.get(index))
                    {
                        dispose();
                        try {
                            Page_modifier_vol p= new Page_modifier_vol(l.getVols().get(i).getId_vol());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        Scrollpane_liste_vols.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        Button_modifier_billets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=List_vols_id.getSelectedIndex();
                for(int i=0;i<l.getVols().size();i++)
                {
                    if (l.getVols().get(i).getId_vol()==tab_id.get(index)) {
                        dispose();
                        try {
                            Page_administrateur_modifier_billets p = new Page_administrateur_modifier_billets(tab_id.get(index));
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        Button_modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Page_administrateur_ajouter_vol p = new Page_administrateur_ajouter_vol();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
        Button_stat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=List_vols_id.getSelectedIndex();
                for(int i=0;i<l.getVols().size();i++)
                {
                    if (l.getVols().get(i).getId_vol()==tab_id.get(index)){
                        dispose();
                        try {
                            Page_statistique stat = new Page_statistique(l.getVols().get(i).getId_vol());
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
