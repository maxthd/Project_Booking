package jdbc2020;

import org.jdesktop.swingx.JXDatePicker;

import java.util.ArrayList;

public class Vol {
    private int id_vol;
    private int nombre_place;
    private String ville_depart;
    private String ville_arrive;
    private JXDatePicker date_depart;
    private JXDatePicker date_arrive;

    ArrayList<Client> Clients_vol = new ArrayList<>();
    ArrayList<Billet>  billets_vol = new ArrayList<>();


}
