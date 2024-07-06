package view;

import view.components.Myframe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Scooter;
import model.Location;

public class ListeDeLocations extends Myframe {
    public ListeDeLocations (Scooter sctr){    
        super("Liste des lcoations du scooter "+sctr.getId(),500,600);

        JPanel mainShow = new JPanel();
        mainShow.setLayout(new BoxLayout(mainShow, BoxLayout.Y_AXIS));

        if (sctr.getListeLocations().size() == 0){
            JLabel infos = new JLabel("Ce scooter n'a pas de locations programées dans le future");
            infos.setAlignmentX(infos.CENTER_ALIGNMENT);
            infos.setAlignmentY(infos.CENTER_ALIGNMENT);
            mainShow.add(infos);
            this.add(mainShow);
        }else{
            int i = 1;
            for (Location location: sctr.getListeLocations()){
                JLabel infosDates = new JLabel("Locations N°"+i+" : à partir de "+location.getDateDebut()+" jusqu'à "+location.getDateFin()+" , Locataire(Nom|Prenom|Tel) : "+location.getClient().getNom()+" | "+location.getClient().getPrenom()+" | "+location.getClient().getTelephone());
                JPanel tmp = new JPanel();
                tmp.setLayout(new FlowLayout(FlowLayout.CENTER));
                tmp.add(infosDates);
                tmp.setMaximumSize(new Dimension(560, 40)); 
                tmp.setPreferredSize(new Dimension(560, 40));
                tmp.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
                mainShow.add(tmp);
                i++;
            }
            JScrollPane scrollPanel = new JScrollPane(mainShow);
            this.add(scrollPanel);
        }
        this.setResizable(false);
    }
}
