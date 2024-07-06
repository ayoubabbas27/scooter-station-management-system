package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.components.DataDiv;
import view.components.Mybutton;
import view.components.Myframe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Engine;

public class ParcdeScooter extends Myframe {    
    DataDiv nombreMaxScooter ;
    DataDiv nombreClient;
    DataDiv nombreScooter ;
    DataDiv scooterEnLocation;
    DataDiv scooterReserves;
    DataDiv scooterDispo;
    DataDiv moyenKilo ;
    public ParcdeScooter(HomePage home,  Engine engine) {
        super("Parc des Scooters", 1000,1600);
        
        JPanel mainHome = new JPanel();
        mainHome.setLayout(new BorderLayout());

        JPanel container1 = new JPanel();
        container1.setLayout(new BoxLayout(container1, BoxLayout.Y_AXIS));

        LayoutManager layoutInfosButton = new FlowLayout(FlowLayout.CENTER, 20,5);
        JPanel subContainer1 = new JPanel(layoutInfosButton);
        JPanel subContainer2 = new JPanel(layoutInfosButton);
        JPanel subContainer3 = new JPanel(layoutInfosButton);
        JPanel subContainer4 = new JPanel(layoutInfosButton);
        JPanel subContainer5 = new JPanel(layoutInfosButton);

        JPanel container2 = new JPanel();
        container2.setLayout(new FlowLayout());

        nombreClient = new DataDiv("Nombre de Client", String.valueOf(engine.parc.getListeClients().size()));
        Mybutton visualserClient = new Mybutton("Visualiser", Color.white, Color.blue);
        visualserClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ListeDeClient listeDeClient = new ListeDeClient(engine);
            }
        });
        visualserClient.setAlignmentX(Component.CENTER_ALIGNMENT);

        Mybutton modifierNbrMaxScooters = new Mybutton("Modifier", Color.white, Color.BLUE);
        ParcdeScooter currentPage = this;
        modifierNbrMaxScooters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ModifierCapaciteParcPage modifierCapaciteParcPage = new ModifierCapaciteParcPage(currentPage, engine);
            }
        });
        modifierNbrMaxScooters.setAlignmentX(Component.CENTER_ALIGNMENT);

        Mybutton visualiserLocation = new Mybutton("Visualiser", Color.white, Color.BLUE);
        visualiserLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ListeDeScootersEnLocation listeDeScootersEnLocationPage = new ListeDeScootersEnLocation(engine.parc);
            }
        });
        visualiserLocation.setAlignmentX(Component.CENTER_ALIGNMENT);

        Mybutton visualiserDispo = new Mybutton("Visualiser", Color.WHITE, Color.BLUE);
        visualiserDispo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ListeDesScootersDisponibles listeDesScootersDisponiblesPage = new ListeDesScootersDisponibles(engine.parc);
            }
        });
        visualiserDispo.setAlignmentX(Component.CENTER_ALIGNMENT);

        Mybutton visualiserReserves = new Mybutton("Visualiser", Color.WHITE, Color.BLUE);
        visualiserReserves.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ListeDeScootersReserves listeDesScootersReservesPage = new ListeDeScootersReserves(engine.parc);
            }
        });
        visualiserReserves.setAlignmentX(Component.CENTER_ALIGNMENT);

        Mybutton ajouterScooterBtn = new Mybutton("Ajouter scooter", Color.white, Color.BLUE);
        ajouterScooterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                AjouterScooterPage ajouterScooterPage = new AjouterScooterPage(currentPage, engine);
            }
        });
        ajouterScooterBtn.setPreferredSize(new Dimension(180, 40));

        Mybutton supprimerScooterBtn = new Mybutton("Supprimer scooter", Color.white, Color.RED);
        supprimerScooterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                SupprimerScooterPage supprimerScooterPage = new SupprimerScooterPage(currentPage,engine);
            }
        });
        supprimerScooterBtn.setPreferredSize(new Dimension(180, 40));

        ParcdeScooter currentParcdeScootersPage = this;
        Mybutton exit = new Mybutton("Home page",Color.white,Color.ORANGE);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                home.setVisible(true);
                currentParcdeScootersPage.dispose();
            }
        });

        nombreMaxScooter = new DataDiv("Nombre maximum de scooters",String.valueOf(engine.parc.getNbrMaxScooters()));

        nombreScooter = new DataDiv("Nombre actuel de scooters",String.valueOf(engine.parc.getcurrentNbrScooters()));

        scooterEnLocation = new DataDiv("Nombre de scooters actuellement loués", String.valueOf(engine.parc.getNbrScootersLoues()));

        scooterReserves = new DataDiv("Nombre de scooters réservés pour le futur", String.valueOf(engine.parc.getNbrScootersReserves()));

        scooterDispo = new DataDiv("Nombre de scooters actuellement disponibles", String.valueOf(engine.parc.getNbrScootersDisponibles()));

        moyenKilo = new DataDiv("Distance moyenne parcourue (km)", String.valueOf(engine.parc.calculKilometrageMoy()));

        subContainer1.add(nombreMaxScooter);
        subContainer1.add(modifierNbrMaxScooters);

        subContainer2.add(scooterEnLocation);
        subContainer2.add(visualiserLocation);

        subContainer3.add(scooterReserves);
        subContainer3.add(visualiserReserves);

        subContainer4.add(scooterDispo);
        subContainer4.add(visualiserDispo);

        subContainer5.add(nombreClient);
        subContainer5.add(visualserClient);

        container1.add(subContainer1);
        container1.add(nombreScooter);
        container1.add(subContainer2);
        container1.add(subContainer3);
        container1.add(subContainer4);
        container1.add(moyenKilo);
        container1.add(subContainer5);

        container2.add(ajouterScooterBtn);
        container2.add(supprimerScooterBtn);
        container2.add(exit);

        mainHome.add(container1, BorderLayout.CENTER);
        mainHome.add(container2, BorderLayout.SOUTH);

        this.add(mainHome,BorderLayout.CENTER);
    }
    public void updateData(Engine engine) {
        nombreMaxScooter.setValue(String.valueOf(engine.parc.getNbrMaxScooters()));
        nombreScooter.setValue(String.valueOf(engine.parc.getcurrentNbrScooters()));
        scooterEnLocation.setValue(String.valueOf(engine.parc.getNbrScootersLoues()));
        scooterDispo.setValue(String.valueOf(engine.parc.getNbrScootersDisponibles()));
        moyenKilo.setValue(String.valueOf(engine.parc.calculKilometrageMoy()));
        revalidate();
    }
}
