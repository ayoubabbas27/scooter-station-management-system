package view;

import view.components.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import model.Engine;


public class SupprimerScooterPage extends Myframe {
    public SupprimerScooterPage (ParcdeScooter prevPage , Engine engine){
        super("Supprimer un scooter",400,400);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.add(new HeadingText("Information requise"),BorderLayout.NORTH);
        JPanel tmp = new JPanel();
        LayoutManager layout = new FlowLayout(FlowLayout.CENTER, 20,5);
        tmp.setLayout(layout);
        MytextField IDField = new MytextField("ID", 20, 200,true);
        tmp.add(IDField);
        this.add(tmp,BorderLayout.CENTER);
        Mybutton tmpButton = new Mybutton("Valider", Color.WHITE, Color.RED);
        tmpButton.addActionListener(event->{
            if(IDField.getText().equals("") || IDField.getText().equals("ID")){
                NotificationPage notification = new NotificationPage("Erreur : Veuillez saisir toutes les informations requises");
            }else{
                String message  = engine.supprimerScooter(Integer.parseInt(IDField.getText()) );
                NotificationPage notification = new NotificationPage(message);
                prevPage.updateData(engine);
                this.dispose();
            }
        });
        this.add(tmpButton,BorderLayout.SOUTH);
    }
}
