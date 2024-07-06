package view;
import java.awt.BorderLayout;
import model.Engine;
import view.components.Aside;
import view.components.Myframe;
import view.components.SectionView;

import model.Engine;

public class LouerScooter extends Myframe {
    Aside myAside;
    SectionView section;

    public LouerScooter (Myframe homepage,Engine engine) {
        super("Louer Scooter",1000,1600);
        this.setLayout(new BorderLayout());
        myAside  = new Aside(homepage,this,engine);
        section = new SectionView(myAside,this,engine);
        this.add(myAside,BorderLayout.WEST);
        this.add(section);
        this.setVisible(true);
    }    

    public SectionView getSection (){
        return section;
    }
}
