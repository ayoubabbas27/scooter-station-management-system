package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Client;
import model.Engine;
import model.Location;
import view.components.Card;
import view.components.Mybutton;
import view.components.Myframe;

public class RetournerList extends Myframe{

    Location selectedLocation = null;
    RetournerList currRetournerList;
    JPanel mainPanel;

    public RetournerList(Engine engine,Client client){
        super("Liste de locations du client "+client.getNom()+" "+client.getPrenom(), 600, 1200);
        Vector<Location> listLocation = client.getListLoc();
        currRetournerList = this;
        if(listLocation.size()==0){
            JLabel text = new JLabel("Ce client n'as fait aucun location");
            text.setFont(new Font("Arial",Font.BOLD,20));
            this.add(text,BorderLayout.NORTH);
        }else{
            mainPanel = new JPanel();
            mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 20));
            for(Location element:listLocation){
                Card card = new Card(element.getDateDebut() , String.valueOf(element.getScooter().getId()) , element.getScooter().getModele());
                card.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        selectedLocation = element;
                        currRetournerList.selectCard(card);
                    }
                });
                mainPanel.add(card);
            }
            Mybutton retournerScooter = new Mybutton("Retourner ce scooter", Color.white, Color.BLUE);
            retournerScooter.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    if(selectedLocation==null){
                        NotificationPage notificationPage = new NotificationPage("Erreur : Vous de devez selectioner une location pour faire le retoure");
                    }else{
                        RetournerForm retournerForm = new RetournerForm(engine, selectedLocation);
                        RetournerList.this.dispose();
                    }
                }
            });
            this.add(mainPanel,BorderLayout.CENTER);
            this.add(retournerScooter,BorderLayout.SOUTH);
        }
        this.setVisible(true);
    }

    public void selectCard (Card selectedCard){
        for(Component compo : mainPanel.getComponents()){
            Card card = (Card) compo ;
            if (card.getID() == selectedCard.getID()){
                card.setBackground(Color.ORANGE);
            }else{
                card.setBackground(Color.WHITE);
            }
        }
        this.repaint();
    }
}
