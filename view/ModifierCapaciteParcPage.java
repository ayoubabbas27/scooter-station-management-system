package view;
import view.components.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import model.Engine;

public class ModifierCapaciteParcPage extends Myframe {
    public ModifierCapaciteParcPage (ParcdeScooter prevPage , Engine engine){
        super("Modifier la capacitée maximale du parc",400,400);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.add(new HeadingText("Entrez la nouvelle capacité maximale"),BorderLayout.NORTH);
        JPanel tmp = new JPanel();
        LayoutManager layout = new FlowLayout(FlowLayout.CENTER, 20,5);
        tmp.setLayout(layout);
        MytextField newCapaciteMax = new MytextField("", 20, 200,true);
        tmp.add(newCapaciteMax);
        this.add(tmp,BorderLayout.CENTER);
        Mybutton tmpButton = new Mybutton("Valider", Color.WHITE, Color.ORANGE);
        tmpButton.addActionListener(event->{
            if(newCapaciteMax.getText().equals("")){
                NotificationPage notification = new NotificationPage("Erreur : Veuillez inserer tous les informations demandées");
            }else{
                String message  = engine.parc.setNbrMaxScooters(Integer.parseInt(newCapaciteMax.getText()) );
                NotificationPage notification = new NotificationPage(message);
                prevPage.updateData(engine);
                this.dispose();
            }
        });
        this.add(tmpButton,BorderLayout.SOUTH);
    }
    
}
