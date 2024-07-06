package model;
import java.util.*;

public class Client {
    private String nom;
    private String prenom;
    private String telephone;
    private int id;
    private Vector<Location> listeLocations;
    private Parc parc;

    //Constractor
    public Client(String nom,String prenom,String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.listeLocations = new Vector<Location>();
        this.id = new Random().nextInt(100);
    }
    
    //Getters
    public int getId() {
        return id;
    }
    public Vector<Location> getListLoc() {
        return listeLocations;
    }
    public String getNom() {
        return nom;
    }
    public Parc getParc() {
        return parc;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getTelephone() {
        return telephone;
    }

    //Setters 
    public void setListeLocations (Vector<Location> newListeLocations){
        this.listeLocations = newListeLocations;
    }

    //Other methods
    public void addNewLocation (Location lcoation){
        this.listeLocations.add(lcoation);
    }
    public void supprimerLocation (Location location){
        listeLocations.remove(location);
    }
    public boolean isLocationExist (Scooter scooter){
        for (Location location: listeLocations){
            if (location.getScooter().equals(scooter)){
                return true;
            }
        }
        return false;
    }
    public Location getLocationByInfos (Scooter scooter){
        for (Location location: listeLocations){
            if (location.getScooter().equals(scooter)){
                return location;
            }
        }
        return null;
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