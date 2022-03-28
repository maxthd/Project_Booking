package affichage;
import jdbc2020.*;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_vol_admin extends JFrame implements Scrollable, Accessible {
    private JList List_vols_id;
    private JLabel Label_id_vol;
    private JTextField Tf_id_vol;
    private JButton Button_modifier;
    private JButton Button_modifier_vol;
    private JButton Button_quitter;
    private JPanel Menu_vol_admin;
    DefaultListModel DLM =new DefaultListModel();


    public Page_vol_admin () throws SQLException, ClassNotFoundException {
        /*JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(List_vols_id);
        List_vols_id.setLayoutOrientation(JList.VERTICAL);*/
        Listes l=new Listes();
        setContentPane(Menu_vol_admin);
        setTitle("Page d'acceuil");
        setSize(100,100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i=0;i<l.getVols().size();i++)
        {
            String o="Vol "+Integer.toString(l.getVols().get(i).getId_vol())+" "+l.getVols().get(i).getVille_depart()+ " "+
                    l.getVols().get(i).getVille_arrive()+" départ "+"29/09/2001"+" 12:09"+" arrivée "+ "30/09/2001 01:15 "+
                    "nombre de place "+Integer.toString(l.getVols().get(i).getNombre_place());
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


    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return null;
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 0;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 0;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}
