package Vue;
import Controleur.Listes;
import Controleur.Modifier_vol;

import javax.swing.*;
import java.awt.Font;
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
    private JButton Button_delete;
    DefaultListModel DLM =new DefaultListModel();


    /***
     * Afficher la page pour récuperer la liste des vols (accessible seulement par les employés)
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_vol_admin () throws SQLException, ClassNotFoundException {

        List_vols_id.setFont(new Font("Arial",Font.BOLD,14));
        ArrayList<Integer> tab_id = new ArrayList();
        Listes l=new Listes();
        Modifier_vol modif = new Modifier_vol();
        setContentPane(Menu_vol_admin);
        setTitle("Page menu des vols");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i=0;i<l.getVols().size();i++)
        {
            String o=l.getVols().get(i).getVille_depart()+ " -> "+ l.getVols().get(i).getVille_arrive()+
                    "  Départ "+l.getVols().get(i).getDate_depart()+" à "+l.getVols().get(i).getHeure_depart()
                    +"  Arrivée "+ l.getVols().get(i).getDate_arrive()+" à "+l.getVols().get(i).getHeure_arrive();

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
        Button_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = List_vols_id.getSelectedIndex();
                for (int i = 0; i < l.getVols().size(); i++) {
                    if (l.getVols().get(i).getId_vol() == tab_id.get(index)) {
                        try {
                            modif.Delete_Vol(tab_id.get(index));
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        dispose();
                        Page_administrateur p = new Page_administrateur();
                    }
                }
            }
        });
    }


}
