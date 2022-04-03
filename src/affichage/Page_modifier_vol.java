package affichage;
import Modele.*;
import jdbc2020.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Page_modifier_vol extends JFrame
{
    private JLabel Label_ville_d;
    private JTextField Tf_ville_d;
    private JLabel Label_date_d;
    private JTextField Tf_date_d;
    private JLabel Label_horaire_d;
    private JTextField Tf_horaire_d;
    private JLabel Label_ville_a;
    private JTextField Tf_ville_a;
    private JLabel Label_date_a;
    private JTextField Tf_date_a;
    private JLabel Label_horaire_a;
    private JTextField Tf_horraire_a;
    private JButton Button_Quitter;
    private JButton Button_valider;
    private JLabel Label_vol_dispo;
    private JTextField Tf_vol_dispo;
    private JPanel Menu_modification_vol;
    private JButton Button_delete;

    /***
     * Afficher la page pour modifier un vol (accessible seulement par les employés)
     * @param id_du_vol
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_modifier_vol(int id_du_vol) throws SQLException, ClassNotFoundException {
        Listes l = new Listes();
        Modifier_vol modif = new Modifier_vol();
        setContentPane(Menu_modification_vol);
        setTitle("modification de vol");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i = 0; i < l.getVols().size(); i++) {
            if (l.getVols().get(i).getId_vol() == id_du_vol) {
                Label_ville_d.setText(l.getVols().get(i).getVille_depart());
                Label_date_d.setText(l.getVols().get(i).getDate_depart());
                Label_horaire_d.setText(l.getVols().get(i).getHeure_depart());
                Label_ville_a.setText(l.getVols().get(i).getVille_arrive());
                Label_date_a.setText(l.getVols().get(i).getDate_arrive());
                Label_horaire_a.setText(l.getVols().get(i).getHeure_arrive());
                Label_vol_dispo.setText(Integer.toString(l.getVols().get(i).getVol_dispo()));
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
                try {
                    modif.Update_Vol(id_du_vol, Tf_ville_d.getText(),
                            Tf_ville_a.getText(), Tf_date_d.getText(), Tf_date_a.getText(), Tf_horaire_d.getText(), Tf_horraire_a.getText(),
                            Integer.parseInt(Tf_vol_dispo.getText()));
                } catch (SQLException ex) {
                    ex.printStackTrace();

                }
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
    }
}
