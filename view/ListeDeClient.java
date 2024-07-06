package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Client;
import model.Engine;
import view.components.Myframe;

public class ListeDeClient extends Myframe{
    public ListeDeClient(Engine engine){
        super("Liste des Clients",500,600);
        JPanel mainShow = new JPanel();
        mainShow.setLayout(new BoxLayout(mainShow, BoxLayout.Y_AXIS));

        if (engine.parc.getListeClients().size() == 0){
            JLabel infos = new JLabel("on a pas des client");
            infos.setAlignmentX(infos.CENTER_ALIGNMENT);
            infos.setAlignmentY(infos.CENTER_ALIGNMENT);
            mainShow.add(infos);
            this.add(mainShow);
        }else{
    
            int i = 1;
            for (Client client: engine.parc.getListeClients()){
                JLabel infosDates = new JLabel("Clients N°"+i+" (Nom|Prenom|Telephone): "+client.getNom()+" | "+client.getPrenom()+" | "+client.getTelephone());
                JPanel tmp = new JPanel();
                tmp.setLayout(new FlowLayout(FlowLayout.CENTER));
                tmp.add(infosDates);
                tmp.setMaximumSize(new Dimension(560, 40)); 
                tmp.setPreferredSize(new Dimension(560, 40));
                tmp.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
                mainShow.add(tmp);
                i++;
            }
            JScrollPane scrollPanel = new JScrollPane(mainShow);
            this.add(scrollPanel);
        }
        this.setResizable(false);
    }
}
