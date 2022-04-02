package affichage;

import Modele.Modifier_client;
import jdbc2020.Listes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Page_client_admin extends JFrame {
    private JList List_clients;
    private JTextField Tf_id_clients;
    private JButton Button_recherche;
    private JButton Button_quitter;
    private JPanel Menu_recherche_client;
    DefaultListModel DLM =new DefaultListModel();

    public Page_client_admin () throws SQLException, ClassNotFoundException
    {
        ArrayList<Integer> tab_id = new ArrayList();
        Listes l = new Listes();
        setContentPane(Menu_recherche_client);
        setTitle(" Page recherche client");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        for (int i=0;i<l.getClients().size();i++)
        {
            String o= "id: "+ Integer.toString(l.getClients().get(i).getId_client())+" prénom : " + l.getClients().get(i).getPrenom() +
                    " nom : " + l.getClients().get(i).getNom();
            tab_id.add(l.getClients().get(i).getId_client());
            DLM.addElement(o);
        }
        List_clients.setModel(DLM);
        Button_recherche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=List_clients.getSelectedIndex();
                for(int i=0;i<l.getClients().size();i++)
                {
                    if (l.getClients().get(i).getId_client()==tab_id.get(index))
                    {
                        dispose();
                        try {
                            Page_modifier_client p= new Page_modifier_client (l.getClients().get(i).getId_client());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        Button_quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Page_administrateur p= new Page_administrateur();
            }
        });
    }
}
