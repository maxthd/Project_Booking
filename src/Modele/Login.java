package Modele;
import jdbc2020.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Login {

    private ArrayList<Client> clients;
    private ArrayList<Employe> employes;


    /***
     * Constructeur Login
     * @param l
     */
    public Login (Listes l) {
        clients=l.getClients();
        employes=l.getEmployes();

    }

    /***
     * Verifie que le username et le mdp sont celui d'un client
     * @param username
     * @param mdp
     * @return
     */
    public boolean Est_un_client (String username, String mdp)
    {
        for (int i=0; i<clients.size();i++)
        {
            if ((username.equals(clients.get(i).getUsername()))&&(mdp.equals(clients.get(i).getPassword())))
            {
                System.out.println(username);
                return true;
            }
        }
        System.out.println(username);
        return false;
    }

    /***
     * Recupère l'id du client
     */
    public int id_du_client (String username, String mdp)
    {
        for (int i=0; i<clients.size();i++)
        {
            if ((username.equals(clients.get(i).getUsername()))&&(mdp.equals(clients.get(i).getPassword())))
            {
                System.out.println(username);
                return clients.get(i).getId_client();
            }
        }
        System.out.println(username);
        return 0;
    }


    /***
     * Verifie que le username et le mdp sont celui d'un employe
     * @param username
     * @param mdp
     * @return
     */
    public boolean Est_un_Employe (String username, String mdp)
    {
        for (int i=0; i<employes.size();i++)
        {
            if ((username.equals(employes.get(i).getUsername()))&&(mdp.equals(employes.get(i).getPassword())))
            {
                return true;
            }
        }
        return false;
    }

}
