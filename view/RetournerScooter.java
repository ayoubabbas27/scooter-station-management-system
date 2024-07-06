package view;

import view.components.HeadingText;
import view.components.Mybutton;
import view.components.Myframe;
import view.components.MytextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import model.Client;
import model.Engine;


public class RetournerScooter extends Myframe {
    public RetournerScooter(HomePage homePage,Engine engine) {
        super("Retourner Scooter",500,400);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.add(new HeadingText("Informations locataire"),BorderLayout.NORTH);
        JPanel tmp = new JPanel();
        LayoutManager layout = new FlowLayout(FlowLayout.CENTER, 60,10);
        tmp.setLayout(layout);
        MytextField telephoneField = new MytextField("tel", 20, 200, true);

        tmp.add(telephoneField);

        this.add(tmp,BorderLayout.CENTER);
        Mybutton tmpButton = new Mybutton("Valider", Color.WHITE, Color.ORANGE);


        tmpButton.addActionListener(e->{
            if(telephoneField.getText().equals("") || telephoneField.getText().equals("tel")){
                NotificationPage notification = new NotificationPage("Erreur : Veuillez inserer toutes les informations demandées");
            }else{
                Client client = engine.parc.getClientByPhone(telephoneField.getText());
                if(client!=null){
                    RetournerList retournerList = new RetournerList(engine, client);
                    this.dispose();
                }else{
                    NotificationPage notificationPage = new NotificationPage("le client n'exist pas dans notre parc :(");
                }
            }
        });

        this.add(tmpButton,BorderLayout.SOUTH);
        this.show();
    }
}