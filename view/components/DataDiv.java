package view.components;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DataDiv extends JPanel {
    String value;



    public DataDiv(String text, String value) {
        JLabel mytext = new JLabel(text + ":");
        this.value = value;
        mytext.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel myvalue = new JLabel(this.value);
        myvalue.setFont(new Font("Arial", Font.PLAIN, 18));
        this.setLayout(new FlowLayout());
        this.add(mytext);
        this.add(myvalue);
    }

    public void setValue(String value) {
        this.value = value;
        ((JLabel)getComponent(1)).setText(value); 
        this.repaint();
    }

    public String getValue (){
        return this.value;
    }
}