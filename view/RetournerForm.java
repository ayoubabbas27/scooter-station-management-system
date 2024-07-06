package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.Period;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Engine;
import model.Location;
import view.components.DateInputField;
import view.components.HeadingText;
import view.components.Mybutton;
import view.components.Myframe;
import view.components.MytextField;

public class RetournerForm extends Myframe {
    public RetournerForm(Engine engine, Location location) {
        super("Formulaire de retour du scooter "+location.getScooter().getModele(), 700, 450);

        this.setLayout(new BorderLayout());
        this.setResizable(false);

        this.add(new HeadingText("Informations Locataire"),BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60,10));
        JPanel tmp1 = new JPanel(new GridLayout(3,1,0,3));
        JPanel tmp2 = new JPanel(new GridLayout(3,1,0,3));
        JPanel tmp3 = new JPanel(new GridLayout(2,1,0,3));

        JLabel idField = new JLabel("ID de locataire: " + location.getClient().getId());
        JLabel nomField = new JLabel("Nom de Locataire: " + location.getClient().getNom());
        JLabel prenomField = new JLabel("Prenom de Locataire: " + location.getClient().getPrenom());

        tmp1.add(idField);
        tmp1.add(nomField);
        tmp1.add(prenomField);
        mainPanel.add(tmp1);
        mainPanel.add(new HeadingText("Informations Scooter"));

        JLabel idScooterField = new JLabel("ID de Scooter en location: " + location.getScooter().getId());
        JLabel modelScooterField = new JLabel("Model de Scooter: " + location.getScooter().getModele());
        JLabel kilometrageField = new JLabel("Kilometrage de Scooter avant location: " + location.getScooter().getKilometrage());

        tmp2.add(idScooterField);
        tmp2.add(modelScooterField);
        tmp2.add(kilometrageField);
        mainPanel.add(tmp2);

        mainPanel.add(new HeadingText("Donnez le nouveau kilométrage:"));

        MytextField kilometrageinput = new MytextField(20,200,true);

        mainPanel.add(kilometrageinput);

        JLabel dateDeDebut = new JLabel("La date de début de location est: " + location.getDateDebut());
        JLabel dateDeFin = new JLabel("La date de fin prévue de location est: " + location.getDateFin());

        tmp3.add(dateDeDebut);
        tmp3.add(dateDeFin);
        mainPanel.add(tmp3);

        mainPanel.add(new HeadingText("Donnez la date de retour du scooter:"));

        DateInputField dateRetour = new DateInputField();
        mainPanel.add(dateRetour);

        Mybutton valider = new Mybutton("Valider", Color.white, Color.blue);
        valider.addActionListener(event-> {            
            if(!kilometrageinput.getText().isEmpty()){
                if (Float.parseFloat(kilometrageinput.getText())>=location.getScooter().getKilometrage()){
                    if (dateRetour.getDate().isAfter(location.getDateDebut())){
                        Boolean response = engine.retournerScooter(location.getClient(), location, location.getDateDebut(), dateRetour.getDate(), location.getScooter(), kilometrageinput.getText());
                        if(response){
                            if (dateRetour.getDate().isBefore(location.getDateFin()) || dateRetour.getDate().isEqual(location.getDateFin())){
                                NotificationPage notification = new NotificationPage("Succès : Le scooter a été retourné avec succès");
                            }else{
                                NotificationPage notification = new NotificationPage("Succès : Le scooter a été retourné avec succès, mais après la date de retour prévu avec "+ Math.abs(Period.between(dateRetour.getDate(), location.getDateFin()).getDays())+" jours");
                            }
                            RetournerForm.this.dispose();
                        }else{
                            NotificationPage notificationPage = new NotificationPage("Une erreur s'est produite lors du retour du scooter");
                        }
                    }else{
                        NotificationPage error = new NotificationPage("Erreur : La date de retour indiquée ne peut pas être antérieure à la date de début de la location, veuillez saisir une date de retour valide");
                    }
                }else{
                    NotificationPage error = new NotificationPage("Erreur : Le nouveau kilométrage ne peut pas etre inférieur par rapport à l'ancien kilometrage");
                }
            }else{
                NotificationPage error = new NotificationPage("Erreur : Veuillez saisir toutes les informations requises");
            }      
        });
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(valider, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
