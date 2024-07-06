package view.components;

import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MytextField extends JTextField implements ActionListener{

    public String getValue(){
        return this.getText();
    }

    public MytextField(String text, int height, int width, boolean isNumbers) {
        super(text);
        setPreferredSize(new Dimension(width, height));
        if (isNumbers) {
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c)) {
                        e.consume();
                    }
                }
            });
        }
        this.addActionListener(this);
    }
    public MytextField(int height,int width,boolean isNumbers){
        setPreferredSize(new Dimension(width, height));
        if (isNumbers) {
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c)) {
                        e.consume();
                    }
                }
            });
        }
        this.addActionListener(this);
    }

    public MytextField(int height, int width) {
        super();
        this.addActionListener(this);
        setPreferredSize(new Dimension(width, height));
    
    }

    public void resetTextField (){
        super.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            
        } catch (Exception e) {
            System.out.println("there re an error");
        }
    }
}