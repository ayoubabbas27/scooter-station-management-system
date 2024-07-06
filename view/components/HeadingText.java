package view.components;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;

import javax.swing.*;
public class HeadingText extends JPanel{
    public HeadingText(String text){
        this.setLayout(new FlowLayout());
        JLabel heading = new JLabel(text);
        heading.setFont(new Font("Arial",Font.BOLD,21));
        this.add(heading);
        this.setVisible(true);
        this.show();
    }
}
