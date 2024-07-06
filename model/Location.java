package model;
import java.time.LocalDate;

public class Location {
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Scooter scooter;
    private Client client;
    
    //Constractor
    public Location(Client client,Scooter scooter,LocalDate date_debut , LocalDate date_fin) {
        this.dateDebut = date_debut;
        this.dateFin = date_fin;
        this.client = client;
        this.scooter=scooter;
    }

    //Getters
    public Client getClient() {
        return client;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public LocalDate getDateFin() {
        return dateFin;
    }
    public Scooter getScooter() {
        return scooter;
    }
    

}