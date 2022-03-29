package affichage;
import Modele.*;
import jdbc2020.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_modifier_vol extends JFrame {
    private JTextField Tf_id_vol;
    private JLabel Label_ville_d;
    private JTextField Tf_ville_d;
    private JLabel Label_date_d;
    private JTextField Tf_date_d;
    private JLabel Label_horaire_d;
    private JLabel Label_id_vol;
    private JTextField Tf_horaire_d;
    private JLabel Label_ville_a;
    private JTextField Tf_ville_a;
    private JLabel Label_date_a;
    private JTextField Tf_date_a;
    private JLabel Label_horaire_a;
    private JTextField Tf_horraire_a;
    private JLabel Label_nb_places;
    private JTextField Tf_nb_places;
    private JLabel Label_reduction;
    private JTextField Tf_reduction;
    private JButton Button_Quitter;
    private JButton Button_valider;
    private JLabel Label_vol_dispo;
    private JTextField Tf_vol_dispo;
    private JPanel Menu_modification_vol;

    public Page_modifier_vol (int id_du_vol) throws SQLException, ClassNotFoundException
    {
        Listes l  = new Listes();
        Modifier_vol modif= new Modifier_vol();
        setContentPane(Menu_modification_vol);
        setTitle("modification de vol");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i=0;i<l.getVols().size();i++)
        {
            if (l.getVols().get(i).getId_vol()==id_du_vol)
            {
                Label_id_vol.setText(Integer.toString(l.getVols().get(i).getId_vol()));
                Label_ville_d.setText(l.getVols().get(i).getVille_depart());
                Label_date_d.setText(l.getVols().get(i).getDate_depart());
                Label_horaire_d.setText(l.getVols().get(i).getHeure_depart());
                Label_ville_a.setText(l.getVols().get(i).getVille_arrive());
                Label_date_a.setText(l.getVols().get(i).getDate_arrive());
                Label_horaire_a.setText(l.getVols().get(i).getHeure_arrive());
                Label_nb_places.setText(Integer.toString(l.getVols().get(i).getNombre_place()));
                Label_vol_dispo.setText(Integer.toString(l.getVols().get(i).getVol_dispo()));
            }
            if (l.getBillets().get(i).getReduction()==id_du_vol)
            {
                Label_reduction.setText(Double.toString(l.getBillets().get(i).getReduction()));
            }
        }
        Button_Quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Page_vol_admin p = new Page_vol_admin();
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
                int compteur=0;
                for (int i=0;i<l.getVols().size();i++)
                {
                    if (l.getVols().get(i).getId_vol()==Integer.parseInt(Tf_id_vol.getText()))
                    {
                       compteur++;
                    }
                }
                if (compteur!=0)
                {

                }
                else
                {
                    System.out.println("on va modifier");
                    try {
                        modif.Update_Vol(Integer.parseInt(Tf_id_vol.getText()), Integer.parseInt(Tf_nb_places.getText()), Tf_ville_d.getText(),
                                Tf_ville_a.getText(), Tf_date_d.getText(), Tf_date_a.getText(), Tf_horaire_d.getText(), Tf_horraire_a.getText(),
                                Integer.parseInt(Tf_vol_dispo.getText()));
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
