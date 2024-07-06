package view;
import view.components.Aside;
import view.components.DateInputField;
import view.components.HeadingText;
import view.components.Mybutton;
import view.components.Myframe;
import view.components.MytextField;
import java.awt.LayoutManager;
import java.time.LocalDate;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Engine;

public class LocationScooter extends Myframe {
    
    public LocationScooter (String id,String model,String kilometrage,Engine engine,Aside currentAsidePage) {

        super("Formulaire de location du scooter "+id,700,400);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        this.add(new HeadingText("Informations Scooter"),BorderLayout.NORTH);

        JPanel tmp = new JPanel();
        JPanel tmp1 = new JPanel();
        LayoutManager layout = new FlowLayout(FlowLayout.CENTER, 60,10);
        LayoutManager layout1 = new GridLayout(3,1);
        tmp.setLayout(layout);
        tmp1.setLayout(layout1);

        JLabel idText = new JLabel("ID: "+id);
        idText.setFont(new Font("Arial",Font.BOLD,16));
        JLabel modelText = new JLabel("Model: "+model);
        modelText.setFont(new Font("Arial",Font.BOLD,16));
        JLabel kiloText = new JLabel("Kilometrage: "+kilometrage);
        kiloText.setFont(new Font("Arial",Font.BOLD,16));

        tmp1.add(idText);
        tmp1.add(modelText);
        tmp1.add(kiloText);
        tmp.add(tmp1);
        tmp.add(new HeadingText("Informations locataire"));

        MytextField nomField = new MytextField("nom", 20, 200,false);
        MytextField prenomField = new MytextField("prenom", 20, 200, false);
        MytextField telephoneField = new MytextField("tel", 20, 200, true);

        DateInputField dateDebutField = new DateInputField();
        DateInputField dateFinField = new DateInputField();

        tmp.add(nomField);
        tmp.add(prenomField);
        tmp.add(telephoneField);
        tmp.add(new JLabel("Date de debut de location"));
        tmp.add(dateDebutField);
        tmp.add(new JLabel("Date de fin de location"));
        tmp.add(dateFinField);
        this.add(tmp, BorderLayout.CENTER);
        Mybutton tmpButton = new Mybutton("Valider", Color.WHITE, Color.ORANGE);

        tmpButton.addActionListener(event->{
            if(nomField.getText().equals("nom") || prenomField.getText().equals("prenom") || telephoneField.getText().equals("tel") || nomField.getText().isEmpty() || prenomField.getText().isEmpty() || telephoneField.getText().isEmpty()){
                NotificationPage notification = new NotificationPage("Erreur : Veuillez inserer tous les informations demandées");
            }else{
                if (dateDebutField.getDate().isAfter(dateFinField.getDate()) || dateDebutField.getDate().isBefore(LocalDate.now()) ){
                    NotificationPage notification = new NotificationPage("Erreur : Les dates de locations ne sont pas valides la date de location elle peux etre fait de aujourd'hui pas en passer");
                }else{
                    boolean reponse  = engine.louerScooter(nomField.getText() , prenomField.getText() , telephoneField.getText() , dateDebutField.getDate() , dateFinField.getDate() , engine.parc.getScooterById(Integer.valueOf(id)));
                    if (reponse){
                        NotificationPage notification = new NotificationPage("Succès : Le scooter a été loué");
                        currentAsidePage.resfresh();;
                        if (currentAsidePage.currentPage.getSection().getComponentCount() == 1){
                            currentAsidePage.currentPage.getSection().setNewSection(currentAsidePage, engine.parc.getScooterById(Integer.parseInt(id)));
                        }else{
                            currentAsidePage.currentPage.getSection().resetSection(currentAsidePage,engine);
                        }
                        this.dispose();
                    }else{
                        NotificationPage notification = new NotificationPage("Erreur : Le scooter que vous souhaitez louer n'est pas disponible pendant la période sélectionnée");
                    }
                }
            }
        });
        
        this.add(tmpButton,BorderLayout.SOUTH);
        this.show();
}}
