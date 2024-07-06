package view.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JPanel{
    String id;
    String model;
    String kilo;
    LocalDate dateDebut;

    JLabel idLabel;
    JLabel modelLabel;
    JLabel kiloLabel;
    JLabel dateLabel;

    public Card(String idScotter, String model, String kilometrage) {
        this.id =idScotter;
        this.kilo = kilometrage;
        this.model = model;
        // this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setLayout(new GridLayout(3,1));
        this.setBorder(BorderFactory.createEmptyBorder(0, 10,0, 0));

        this.setPreferredSize(new Dimension(250, 70));
        
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        idLabel = new JLabel("  ID: " + idScotter);
        idLabel.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(idLabel);

        modelLabel = new JLabel("  Model: " + model);
        this.add(modelLabel);

        kiloLabel = new JLabel("  Kilometrage: " + kilometrage);
        this.add(kiloLabel);

    }
    public Card(LocalDate dateDebut , String idScotter, String model) {
        this.id =idScotter;
        this.dateDebut = dateDebut;
        this.model = model;
        // this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setLayout(new GridLayout(3,1));
        this.setBorder(BorderFactory.createEmptyBorder(0, 10,0, 0));

        this.setPreferredSize(new Dimension(250, 70));
        
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        dateLabel = new JLabel("  Date de début: " + dateDebut.getDayOfMonth()+"/"+dateDebut.getMonthValue()+"/"+dateDebut.getYear());
        this.add(dateLabel);

        idLabel = new JLabel("  ID scooter: " + idScotter);
        idLabel.setFont(new Font("Arial", Font.BOLD, 12));
        this.add(idLabel);

        modelLabel = new JLabel("  Model scooter: " + model);
        this.add(modelLabel);
    }
    public String getID (){
        return id;
    }
}