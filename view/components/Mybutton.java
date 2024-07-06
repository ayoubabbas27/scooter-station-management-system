package view.components;
    
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Mybutton extends JButton implements ActionListener{
    public Mybutton(String title , Color foreground,Color background){
        this.setText(title);
        this.setForeground(foreground);
        this.setBackground(background);
        // this.setBounds(getVisibleRect());
        this.setFont(new Font("Arial",Font.BOLD,14));
        this.setBorderPainted(false); 
        this.setFocusPainted(false);
        this.setPreferredSize(new Dimension(120, 40));
        this.addActionListener(this);
        this.setVisible(true);
    }

    public void setButtonTitle (String newTitle){
        this.setText(newTitle);
    }

    public String getButtonTitle (){
        return this.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
    }  
}

