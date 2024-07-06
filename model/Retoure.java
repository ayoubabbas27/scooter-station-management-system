package model;

import java.time.LocalDate;

public class Retoure {

    private float kilometrage;
    private LocalDate date_retour;
    private Client client;
    private Location location;

    //Constractor
    public Retoure(Client client,LocalDate date_retour,float kilometrage,Location location) {
        this.date_retour = date_retour;
        this.kilometrage = kilometrage;
        this.location = location;
        this.client = client;
    }

    //Getters
    public LocalDate getDate_retour() {
        return date_retour;
    }
    public float getKilometrage() {
        return kilometrage;
    }
    public Location getLocation() {
        return location;
    }
    public Client getClient() {
        return client;
    }

    //Other methods
    public boolean isRetoureLate (){
        if (this.date_retour.isAfter(this.getLocation().getDateFin())){
            return true;
        }
        return false;
    }

    

}