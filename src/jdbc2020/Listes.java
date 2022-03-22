package jdbc2020;

import java.sql.SQLException;
import java.util.ArrayList;

public class Listes {
    private Connexion maconnexion;
    private ArrayList<Vol> vols=new ArrayList<>();
    private ArrayList<Employe> employes=new ArrayList<>();
    private ArrayList<Client> clients=new ArrayList<>();

    public Listes() throws SQLException, ClassNotFoundException {
        maconnexion=new Connexion("booking", "root", "");

        init_listes_vols();
        init_listes_employes();
        init_listes_clients();
    }


    public void init_listes_vols() throws SQLException {
        int taille=maconnexion.fill_int("SELECT COUNT(*) FROM Vol");

        for (int i=1; i<=taille; i++) {
            Vol vol=new Vol(i, maconnexion);
            vols.add(vol);
        }
    }

    public void init_listes_employes() throws SQLException {
        int taille=maconnexion.fill_int("SELECT COUNT(*) FROM Employe");

        for (int i=1; i<=taille; i++) {
            Employe employe= new Employe(i, maconnexion);
            employes.add(employe);
        }
    }

    public void init_listes_clients() throws SQLException {
        int taille=maconnexion.fill_int("SELECT COUNT(*) FROM Client");

        for (int i=1; i<=taille; i++) {
            Client client=new Client(i, maconnexion);
            clients.add(client);
        }
    }


}
