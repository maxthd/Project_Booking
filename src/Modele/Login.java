package Modele;
import jdbc2020.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Login {


    public Login () throws SQLException, ClassNotFoundException {
    }

    public boolean Est_un_client (String username, String mdp,Listes la)
    {

        for (int i=0; i<la.getClients().size();i++)
        {
            if ((username.equals(la.getClients().get(i).getUsername()))&&(mdp.equals(la.getClients().get(i).getPassword())))
            {
                return true;
            }
        }
        return false;
    }
    public boolean Est_un_Employe (String username, String mdp,Listes la)
    {
        for (int i=0; i<la.getClients().size();i++)
        {
            if ((username.equals(la.getEmployes().get(i).getUsername()))&&(mdp.equals(la.getEmployes().get(i).getPassword())))
            {
                return true;
            }
        }
        return false;
    }

}
