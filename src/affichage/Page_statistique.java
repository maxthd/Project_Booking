package affichage;

import java.awt.*;
import java.awt.event.*;
import Modele.Statistique;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.sql.SQLException;

public class Page_statistique extends JFrame implements ActionListener{



    JButton b=new JButton("Quitter");


    /***
     * Afficher la page pour les statistiques
     * @param id_vol
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Page_statistique(int id_vol) throws SQLException, ClassNotFoundException {
        DefaultPieDataset pieDataset=new DefaultPieDataset();

        Statistique statistique=new Statistique(id_vol);


        int nombre_billet_vendu= statistique.getnombre_total()- (statistique.getnombre_billet_eco_restant() +
                statistique.getnombre_billet_affaire_restant() + statistique.getnombre_billet_premium_restant());


        pieDataset.setValue("Billet vendu", nombre_billet_vendu);
        pieDataset.setValue("Billet economique restant", statistique.getnombre_billet_eco_restant());
        pieDataset.setValue("Billet affaire restant", statistique.getnombre_billet_affaire_restant());
        pieDataset.setValue("Billet premium restant", statistique.getnombre_billet_premium_restant());

        JFreeChart chart= ChartFactory.createPieChart("repartition des billets du vol", pieDataset, true, true, true);
        PiePlot piePlot=(PiePlot) chart.getPlot();

        ChartFrame frame=new ChartFrame("Page statistique de vol", chart);
        b.setBounds(705,670,95,30);
        b.setLayout(null);
        frame.add(b);
        frame.setVisible(true);
        frame.setSize(800, 600);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                Page_administrateur p = new Page_administrateur();
            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
