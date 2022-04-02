package affichage;
import jdbc2020.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;

public class Page_vol_admin extends JFrame  {
    private JList List_vols_id;
    private JLabel Label_id_vol;
    private JTextField Tf_id_vol;
    private JButton Button_modifier;
    private JButton Button_modifier_vol;
    private JButton Button_quitter;
    private JPanel Menu_vol_admin;
    private JScrollPane Scrollpane_liste_vols;
    private JButton Button_modifier_billets;
    DefaultListModel DLM =new DefaultListModel();


    public Page_vol_admin () throws SQLException, ClassNotFoundException {
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
                for(int i=0;i<l.getVols().size();i++)
                {
                    if (l.getVols().get(i).getId_vol()==Integer.parseInt(Tf_id_vol.getText()))
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
                for(int i=0;i<l.getVols().size();i++) {
                    if (l.getVols().get(i).getId_vol() == Integer.parseInt(Tf_id_vol.getText())) {
                        dispose();
                        try {
                            Page_administrateur_modifier_billets p = new Page_administrateur_modifier_billets(Integer.parseInt(Tf_id_vol.getText()));
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
    }

}
