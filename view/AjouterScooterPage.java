package view;
import view.components.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import model.Engine;


public class AjouterScooterPage extends Myframe {
    public AjouterScooterPage (ParcdeScooter prevPage , Engine engine){

        super("Ajouter un scooter",400,400);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.add(new HeadingText("Information requise"),BorderLayout.NORTH);
        JPanel tmp = new JPanel();
        LayoutManager layout = new FlowLayout(FlowLayout.CENTER, 20,5);
        tmp.setLayout(layout);
        MytextField modelField = new MytextField("model", 20, 200,false);
        MytextField kilometrageField = new MytextField("kilometrage", 20, 200, true);
        tmp.add(modelField);
        tmp.add(kilometrageField);
        this.add(tmp,BorderLayout.CENTER);
        Mybutton tmpButton = new Mybutton("Valider", Color.WHITE, Color.BLUE);

        tmpButton.addActionListener(event->{
            if(modelField.getText().equals("") || kilometrageField.getText().equals("") || modelField.getText().equals("model") || kilometrageField.getText().equals("kilometrage")){
                NotificationPage notification = new NotificationPage("Erreur : Veuillez saisir toutes les informations requises");
            }else{
                String message  = engine.ajouterNewScooter(modelField.getText(), Float.parseFloat(kilometrageField.getText()) );
                NotificationPage notification = new NotificationPage(message);
                prevPage.updateData(engine);
                this.dispose();
            }
        });



        this.add(tmpButton,BorderLayout.SOUTH);
    }
}
