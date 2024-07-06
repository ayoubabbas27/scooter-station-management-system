package view.components;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Engine;
import model.Scooter;
import view.LouerScooter;

public class SectionView extends JPanel {
    SectionView currSectionView;

    public SectionView(Aside aside,LouerScooter frame,Engine engine) {
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 20));
        SectionView currSectionView = this;
        Vector<Scooter> listScooter = engine.parc.getListeScooters();
        for (int i = 0; i < engine.parc.getListeScooters().size(); i++) {
            Card card = new Card(String.valueOf(listScooter.get(i).getId()), listScooter.get(i).getModele(), String.valueOf(listScooter.get(i).getKilometrage()));
            String etat = (listScooter.get(i).isFreeInDate(LocalDate.now(), LocalDate.now()))?"Disponible":"Loué" ;
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    aside.setDataid(card.id);
                    aside.setDataKilo(card.kilo);
                    aside.setDatamodel(card.model);
                    aside.setDataEtat(etat);
                    currSectionView.selectCard(card);
                }
            });
            this.add(card);
        }
    }

    public void setNewSection (Aside aside , Scooter scooter){
        this.removeAll();
        SectionView currSectionView = this;
        Card card = new Card(String.valueOf(scooter.getId()), scooter.getModele(), String.valueOf(scooter.getKilometrage()));
        String etat = (scooter.isFreeInDate(LocalDate.now(), LocalDate.now()))?"Disponible":"Loué" ;
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aside.setDataid(card.id);
                aside.setDataKilo(card.kilo);
                aside.setDatamodel(card.model);
                aside.setDataEtat(etat);
                currSectionView.selectCard(card);
            }
        });
        this.add(card);

        this.revalidate();
        this.repaint();
    }

    public void resetSection (Aside aside , Engine engine){
        this.removeAll();
        SectionView currSectionView = this;
        Vector<Scooter> listScooter = engine.parc.getListeScooters();
        for (int i = 0; i < engine.parc.getListeScooters().size(); i++) {
            Card card = new Card(String.valueOf(listScooter.get(i).getId()), listScooter.get(i).getModele(), String.valueOf(listScooter.get(i).getKilometrage()));
            String etat = (listScooter.get(i).isFreeInDate(LocalDate.now(), LocalDate.now()))?"Disponible":"Loué" ;
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    aside.setDataid(card.id);
                    aside.setDataKilo(card.kilo);
                    aside.setDatamodel(card.model);
                    aside.setDataEtat(etat);
                    currSectionView.selectCard(card);
                }
            });
            this.add(card);
        }
        this.revalidate();
        this.repaint();
    }
    public void selectCard (Card selectedCard){
        Component[] cardsListe = this.getComponents();
        for(Component compo : cardsListe){
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