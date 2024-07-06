package view.components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;


public class GridCard extends Mybutton{
    public GridCard(String title,Color foregroundColor, Color backgroundColor){
        super(title,foregroundColor,backgroundColor);
        this.setPreferredSize(new Dimension(150, 150));
    }
    public void ActionPerformed(ActionEvent e){
        
    }
}
