package view;
import view.components.Myframe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Parc;
import model.Scooter;

public class ListeDeScootersEnLocation extends Myframe {
    public ListeDeScootersEnLocation(Parc parc){
        super("Liste des scooters actuellement en location",500,600);

        JPanel mainShow = new JPanel();
        mainShow.setSize(1200, 500);
        mainShow.setLayout(new BoxLayout(mainShow, BoxLayout.Y_AXIS));

        if (parc.getNbrScootersLoues() == 0){
            JLabel infos = new JLabel("Ce parc n'a pas des scooters en cours de location");
            infos.setAlignmentX(infos.CENTER_ALIGNMENT);
            infos.setAlignmentY(infos.CENTER_ALIGNMENT);
            mainShow.add(infos);
            this.add(mainShow);
        }else{
            for (Scooter scooter: parc.getListeScooters()){
                if(scooter.isFreeInDate(LocalDate.now(), LocalDate.now()) != true){
                    JLabel info = new JLabel("ID scooter : "+scooter.getId()+" | Modele : "+scooter.getModele()+" | Kilometrage : "+scooter.getKilometrage());
                    JPanel tmp = new JPanel(new FlowLayout());
                    tmp.add(info);
                    tmp.setMaximumSize(new Dimension(560, 40)); 
                    tmp.setPreferredSize(new Dimension(560, 40));
                    tmp.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
                    mainShow.add(tmp);
                }
            }
            JScrollPane scrollPanel = new JScrollPane(mainShow);

            this.add(scrollPanel);
        }

        this.setResizable(false);
    }
}
