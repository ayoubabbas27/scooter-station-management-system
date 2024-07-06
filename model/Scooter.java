package model;
import java.time.LocalDate;
import java.util.*;
import java.util.Random;

public class Scooter {

    private int id;
    private String modele;
    private float kilometrage;
    private Vector<Location> listeLocations = new Vector<Location>();

    //Constractor
    public Scooter(String model , float kilometrage ) {
        Random random = new Random();
        this.modele = model;
        this.kilometrage = kilometrage;
        // this.parc = parc;
        this.listeLocations = new Vector<Location>();
        this.id = random.nextInt((99999 - 10000) + 1) + 10000;
    }

    //Getters
    public int getId() {
        return id;
    }
    public float getKilometrage() {
        return kilometrage;
    }
    public String getModele() {
        return modele;
    }
    public Vector<Location> getListeLocations (){
        return listeLocations;
    }

    //Setters
    public void setKilometrage(float newKilometrage){
        kilometrage = newKilometrage;
    }

    //Other methods
    public boolean isFreeAlways (){
        return listeLocations.isEmpty();
    }
    static private boolean isDateBetween (LocalDate d1 , LocalDate borne1 , LocalDate borne2){
        if (d1.isAfter(borne1) && d1.isBefore(borne2)){
            return true;
        }
        return false;
    }
    static private boolean isContainedIn (LocalDate borneA1 , LocalDate borneA2 , LocalDate borneB1 , LocalDate borneB2){
        if ((borneA1.isAfter(borneB1) || borneA1.isEqual(borneB1)) && (borneA2.isBefore(borneB2) || borneA2.isEqual(borneB2))){
            return true;
        }
        return false;
    }
    public boolean isFreeInDate (LocalDate dateDebutLocation , LocalDate dateFinLocation){
        for (Location location: listeLocations){
            if (isDateBetween(location.getDateDebut(), dateDebutLocation, dateFinLocation) || isDateBetween(location.getDateFin(), dateDebutLocation, dateFinLocation) || isContainedIn(location.getDateDebut(), location.getDateFin(), dateDebutLocation, dateFinLocation) || isContainedIn(dateDebutLocation ,dateFinLocation , location.getDateDebut(), location.getDateFin())){
                return false;
            }
        }
        return true;
    }
    public void addNewLocation (Location location){
        listeLocations.add(location);
    }
    public void supprimerLocation (Location location){
        listeLocations.remove(location);
    }
    public boolean isLocationExist (Client client){
        for (Location location: listeLocations){
            if (location.getClient().equals(client)){
                return true;
            }
        }
        return false;
    }
    public void afficherListeLocations (){
        for (Location lcoation: listeLocations){
            System.out.println("Date de debut :"+lcoation.getDateDebut());
            System.out.println("Date de Fin :"+lcoation.getDateFin());
            System.out.println("ID scooter :"+lcoation.getScooter().getId());
            System.out.println("Nom client :"+lcoation.getClient().getNom());
        }
    }
}