import model.*;
import view.*;

public class Main{
    public static void main(String[] args) { 

        Engine engine = new Engine(new Parc("parc A", 50));

        engine.ajouterNewScooter("Honda Activa", 150);
        engine.ajouterNewScooter("Yamaha NMax", 320);
        engine.ajouterNewScooter("Suzuki Burgman", 270);
        engine.ajouterNewScooter("Vespa Primavera", 500);
        engine.ajouterNewScooter("Piaggio Liberty", 180);
        engine.ajouterNewScooter("TVS Jupiter", 210);
        engine.ajouterNewScooter("Hero Maestro", 160);
        engine.ajouterNewScooter("Aprilia SR 150", 390);
        engine.ajouterNewScooter("Bajaj Chetak", 120);
        engine.ajouterNewScooter("Mahindra Gusto", 230);

        Welcome welcomePage = new Welcome(engine);

    }
}