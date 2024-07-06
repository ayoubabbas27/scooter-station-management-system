package view.components;
import java.awt.*;

import javax.swing.JFrame;

public class Myframe extends JFrame{

    

    public Myframe(String title ,int height , int width){
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        show();
        this.setTitle(title);
        this.setForeground(Color.WHITE);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.show();
    }
    public Myframe(String title , int height , int width , Myframe passframe){
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        passframe.setVisible(false);
        passframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
