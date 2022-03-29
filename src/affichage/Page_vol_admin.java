package affichage;
import jdbc2020.*;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                    +" arrivée "+ l.getVols().get(i).getDate_arrive()+" "+l.getVols().get(i).getHeure_arrive()+
                    " nombre de place "+Integer.toString(l.getVols().get(i).getNombre_place());
            DLM.addElement(o);
        }
        List_vols_id.setModel(DLM);
        Button_quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                Page_acceuil p= new Page_acceuil();
            }
        });
    }

}
