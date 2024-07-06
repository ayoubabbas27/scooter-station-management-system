package model;
import java.time.LocalDate;
import java.util.*;

public class Parc {

    
    String nomParc;
    private  int nbrMaxScooters;
    private  Vector<Scooter> listeScooters;
    private  Vector<Client> listeClients;
    private Vector<Location> listeLocations;
    private  Vector<Retoure> listeRetours;

    // Constractor
    public Parc(String nomParc , int nbrMaxScooters) {
        this.nbrMaxScooters = nbrMaxScooters;
        this.nomParc = nomParc;
        this.listeScooters =new Vector<Scooter>();
        this.listeClients =new Vector<Client>();
        this.listeRetours = new Vector<Retoure>();
        this.listeLocations = new Vector<Location>();
    }
    public int getNbrMaxScooters (){
        return nbrMaxScooters;
    }
    public  int getNbrScootersDisponibles() {
        int res = 0;
        for (Scooter scooter: listeScooters){
            if (scooter.isFreeInDate(LocalDate.now(), LocalDate.now())){
                res++;
            }
        }
        return res;
    }
    public int getNbrScootersLoues() {
        int res = 0;
        for (Scooter scooter: listeScooters){
            if (!scooter.isFreeInDate(LocalDate.now(), LocalDate.now())){
                res++;
            }
        }
        return res;
    }
    public int getNbrScootersReserves (){
        int res = 0;
        for (Scooter scooter: listeScooters){
            if ((scooter.getListeLocations().size() >= 2)||(scooter.getListeLocations().size() == 1 && scooter.getListeLocations().get(0).getDateDebut().isAfter(LocalDate.now()))){
                res++;
            }
        }
        return res;
    }
    public int getcurrentNbrScooters (){
        return listeScooters.size();
    }
    public Vector<Scooter> getListeScooters (){
        return listeScooters;
    }
    public Vector<Client> getListeClients (){
        return listeClients;
    }
    public Vector<Retoure> getListeRetours (){
        return listeRetours;
    }
    public String getNomParc (){
        return nomParc;
    }
    public Vector<Location> getListeLocations (){
        return listeLocations;
    }
    public Scooter getScooterById(int id){
        for(Scooter scot : listeScooters){
            if(scot.getId() == id){
                return scot;
            }
        }
        return null;
    }
    public Client getClientByInfos (String nomClient , String prenomClient , String telephoneClient){
        for(Client client: listeClients){
            if (client.getNom() == nomClient && client.getPrenom() == prenomClient && client.getTelephone() == telephoneClient){
                return client;
            }
        }
        return null;
    }
    public Location getLocationByInfos (String nomClient , String prenomClient , String telephoneClient , int idScooter){
        for (Location location: listeLocations){
            if (location.getClient().getNom() == nomClient && location.getClient().getPrenom() == prenomClient && location.getClient().getTelephone() == telephoneClient && location.getScooter().getId() == idScooter){
                return location;
            }
        }
        return null;
    }
    public void setListeScooter (Vector<Scooter> listeScooters){
        this.listeScooters = listeScooters;
    }
    public void setListeClients (Vector<Client> listeClients){
        this.listeClients = listeClients;
    }
    public void setListeRetours (Vector<Retoure> listeRetours){
        this.listeRetours = listeRetours;
    }
    public String setNbrMaxScooters (int x){
        if (this.getcurrentNbrScooters() <= x){
            this.nbrMaxScooters = x;
            return "Succès: La capacité maximal du parc a été modifiée";
        }else{
            return "Erreur: Le nombre de scooters dans le parc est supérieur à la nouvelle capacité";
        }
    }
    public void supprimerScooter (Scooter scooter){
        listeScooters.remove(scooter);
    }
    public void ajouterClient (Client client){
        listeClients.add(client);
    }
    public void addNewLocation (Location location){
        listeLocations.add(location);
    }
    public void supprimerLocation (Location location){
        listeLocations.remove(location);
    }
    public boolean isLocationExiste (String nomClient , String prenomClient , String telephoneClient , int idScooter , LocalDate dateDebutLocation){
        for (Location location: listeLocations){
            if (location.getClient().getNom() == nomClient && location.getClient().getPrenom() == prenomClient && location.getClient().getTelephone() == telephoneClient && location.getScooter().getId() == idScooter && location.getDateDebut().equals(dateDebutLocation)){
                return true;
            }
        }
        return false;
    }
    public float calculKilometrageMoy (){
        float res = 0;
        if (listeScooters.size() == 0){
            return res;
        }else{
            for (Scooter scooter: listeScooters){
                res = res + scooter.getKilometrage();
            }
            return res/listeScooters.size();
        }
    }
    public Client getClientByPhone (String phone){
        Vector<Client> list  = this.getListeClients();
        for(Client element : list){
            if(element.getTelephone().equals(phone)){
                return element;
            }
        }
        return null;
        
        
    }
}