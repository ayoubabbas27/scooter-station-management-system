package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.components.GridCard;
import view.components.Mybutton;
import view.components.Myframe;
import model.Engine;

public class HomePage extends Myframe {

    public void exitframe(){
        System.exit(0);
    }

    public HomePage(Engine engine) {
        super("Home Page",1000,1600);
        JLabel header = new JLabel("Welcome to LOOSCOOTER", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        header.setForeground(Color.WHITE);

        JPanel heading = new JPanel(new BorderLayout());
        heading.add(header, BorderLayout.CENTER);
        heading.setBackground(Color.GRAY);
                

        JPanel footer = new JPanel(new FlowLayout());
        footer.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        Mybutton exitBtn = new Mybutton("Quittez le Programme", Color.white, Color.RED);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        exitBtn.setPreferredSize(new Dimension(200,40));
        footer.add(exitBtn);  
        JPanel mainShow = new JPanel();
        mainShow.setSize(1200, 500);
        mainShow.setLayout(new FlowLayout());
        GridCard louerScooter = new GridCard("Louer scooter", Color.BLACK, Color.ORANGE);
        HomePage currentHomePage = this;
        louerScooter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LouerScooter louerScooter = new LouerScooter(currentHomePage, engine);
                HomePage.this.setVisible(false);
            }
            
        });
        mainShow.add(louerScooter);
        GridCard retournerScooter = new GridCard("Retourner scooter", Color.BLACK, Color.ORANGE);
        retournerScooter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                RetournerScooter retourner = new RetournerScooter(currentHomePage, engine);
            }
        });
        retournerScooter.setPreferredSize(new Dimension(170, 150));
        mainShow.add(retournerScooter);
        GridCard afficherParc = new GridCard("Afficher le parc", Color.BLACK, Color.ORANGE);
        afficherParc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ParcdeScooter parcView = new ParcdeScooter(currentHomePage, engine);
                HomePage.this.setVisible(false);
                currentHomePage.setVisible(false);
            }
        });
        mainShow.add(afficherParc);

        

        this.add(mainShow,BorderLayout.CENTER);
        this.add(footer,BorderLayout.SOUTH);
        this.add(heading, BorderLayout.NORTH);
    }
}
