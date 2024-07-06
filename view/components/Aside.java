package view.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Engine;
import model.Scooter;
import view.ListeDeLocations;
import view.LocationScooter;
import view.LouerScooter;
import view.NotificationPage;


public class Aside extends JPanel {

    public LouerScooter currentPage;
    private MytextField searchBar;
    private String idInfo = "Selectioner un scooter";
    private String modelInfo = "Selectioner un scooter";
    private String kiloInfo = "Selectioner un scooter";
    private String etatInfo = "Selectioner un scooter";
    private DataDiv idDiv;
    private DataDiv modelDiv;
    private DataDiv kiloDiv;
    private DataDiv etatInfoDiv;
    JPanel infosPanel ;

    public Aside(Myframe passPage,LouerScooter currentPage,Engine engine) {
        this.currentPage = currentPage;
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(320,5000));
        HeadingText heading = new HeadingText("Parc des scooters");
        heading.setBackground(Color.lightGray);
        heading.setPreferredSize(new Dimension(320,50));
        heading.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        
        searchBar = new MytextField(30, 150,true);
        Mybutton actionBtn = new Mybutton("search(ID)",Color.WHITE,Color.blue);
        Aside currentAside = this;
        actionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (actionBtn.getButtonTitle() == "search(ID)"){
                    if(searchBar.getText().trim().isEmpty()){
                        NotificationPage error = new NotificationPage("Error : Veuillez inserez le ID du scooter recherché");                    
                    }else{
                        try{
                            Scooter researchedScooter = engine.parc.getScooterById(Integer.parseInt(searchBar.getText())) ;
                            if (researchedScooter == null){
                                NotificationPage error = new NotificationPage("Error : Il n'existe aucun scooter avec le ID "+searchBar.getValue());                    
                            }else{
                                currentPage.getSection().setNewSection(currentAside , researchedScooter);
                                actionBtn.setButtonTitle("Reset");

                                setDataid("Selectioner un scooter");
                                setDatamodel("Selectioner un scooter");
                                setDataKilo("Selectioner un scooter");
                                setDataEtat("Selectioner un scooter");
                            }
                        }catch (Exception ex) {
                            NotificationPage error = new NotificationPage("Error : Il n'existe aucun scooter avec le ID "+searchBar.getValue()); 
                        }
                    }
                }else{
                    searchBar.resetTextField();
                    actionBtn.setButtonTitle("search(ID)");
                    currentPage.getSection().resetSection(currentAside, engine);
                    setDataid("Selectioner un scooter");
                    setDatamodel("Selectioner un scooter");
                    setDataKilo("Selectioner un scooter");
                    setDataEtat("Selectioner un scooter");
                }
            }
        });

        Mybutton exit = new Mybutton("Home page",Color.white,Color.ORANGE);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                passPage.setVisible(true);
                currentPage.setVisible(false);
            }
        });
        
        idDiv = new DataDiv("id", this.idInfo);
        idDiv.setBackground(Color.LIGHT_GRAY);
        modelDiv = new DataDiv("model", this.modelInfo);
        modelDiv.setBackground(Color.LIGHT_GRAY);
        kiloDiv = new DataDiv("kilometrage", this.kiloInfo);
        kiloDiv.setBackground(Color.LIGHT_GRAY); 
        etatInfoDiv = new DataDiv("Etat courant", this.etatInfo);
        etatInfoDiv.setBackground(Color.LIGHT_GRAY); 
        
        
        infosPanel = new JPanel(new GridLayout(4,1,0,3));
        infosPanel.setBackground(new Color(0, 0, 0, 0));
        infosPanel.add(idDiv);
        infosPanel.add(modelDiv);
        infosPanel.add(kiloDiv);
        infosPanel.add(etatInfoDiv);

        this.add(heading);
        this.add(searchBar);
        this.add(actionBtn);
        this.add(infosPanel);

        this.repaint();

        Mybutton louerBtn = new Mybutton("Louer ce scooter", Color.WHITE, Color.BLUE);
        louerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (idDiv.getValue() == "Selectioner un scooter"){
                    NotificationPage error = new NotificationPage("Erreur: Veuillez selectionez un scooter d'abord"); 
                }else{
                    LocationScooter locationScooter = new LocationScooter(idDiv.value, modelDiv.value, kiloDiv.value , engine , currentAside);
                }
            }
        });
        louerBtn.setPreferredSize(new Dimension(180, 40));
        Mybutton plusBtn = new Mybutton("plus de details", Color.white, Color.GREEN);
        plusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (idDiv.getValue() == "Selectioner un scooter"){
                    NotificationPage error = new NotificationPage("Erreur: Veuillez selectionez un scooter d'abord"); 
                }else{
                    ListeDeLocations listedelocation = new ListeDeLocations(engine.parc.getScooterById(Integer.valueOf(idDiv.value)));
                }
            }
        });
        plusBtn.setPreferredSize(new Dimension(180, 40));

        JPanel buttonsPanel = new JPanel(new GridLayout(3,1,0,10));
        buttonsPanel.setBackground(new Color(0, 0, 0, 0));

        buttonsPanel.add(louerBtn);
        buttonsPanel.add(plusBtn);
        buttonsPanel.add(exit);

        this.add(buttonsPanel);
        this.setVisible(true);
        this.show();
    }

    public void setDataid(String id){
        idDiv.setValue(id);
    }
    public void setDatamodel(String model){
        modelDiv.setValue(model);
    }
    public void setDataKilo(String kilo){
        kiloDiv.setValue(kilo);
    }
    public void setDataEtat(String etat){
        etatInfoDiv.setValue(etat);
    }

    public DataDiv getIdDiv(){
        return this.idDiv;
    }
    public DataDiv getModelDiv(){
        return this.modelDiv;
    }
    public DataDiv getKiloDiv(){
        return this.kiloDiv;
    }

    public void resfresh (){
        this.setDataid("Selectioner un scooter");
        this.setDatamodel("Selectioner un scooter");
        this.setDataKilo("Selectioner un scooter");
        this.setDataEtat("Selectioner un scooter");
    }
}