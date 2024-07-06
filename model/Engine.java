package model;
import java.time.LocalDate;
import java.util.Vector;

public class Engine {
    public Parc parc;

    public Engine (Parc parc){
        this.parc = parc;
    }

    public String ajouterNewScooter (String modele , float kilometrage){
        if (parc.getListeScooters().size() < parc.getNbrMaxScooters()){
            parc.getListeScooters().add(new Scooter(modele, kilometrage));
            return "Succès : Le scooter a été ajouté";
        }else{
            return "Erreur : Il n'est pas possible d'ajouter ce scooter au parc, et il n'y a plus de places!";
        }
    }

    public String supprimerScooter (int id){
        Scooter scotSupp = parc.getScooterById(id);
        if (scotSupp != null){
            if (scotSupp.isFreeInDate(LocalDate.now(), LocalDate.now())){
                if (scotSupp.isFreeAlways()){
                    parc.getListeScooters().remove(scotSupp);
                    return "Succès : Le scooter "+id+" a été supprimé";
                }else{
                    return"Erreur : Le scooter "+id+" a des reservations dans le future, ce n'est pas possible de le supprimé";
                }
            }else{
                return "Le scooter "+id+" est actuellement en location, ce n'est pas possible de le supprimé";
            }
            
        }else{
            return "Erreur : Le scooter "+id+" n'existe pas dans le parc";
        }
    }

    public boolean louerScooter (String nomClient , String prenomClient , String telephoneClient , LocalDate dateDebutLocation , LocalDate dateFinLocation , Scooter scooter){
        if (scooter.isFreeInDate(dateDebutLocation, dateFinLocation)){
            Client client = parc.getClientByPhone(telephoneClient);
            if (client == null){
                client = new Client(nomClient, prenomClient, telephoneClient);
                parc.ajouterClient(client);
            }
            Location newLocation = new Location( client, scooter, dateDebutLocation ,  dateFinLocation);

            client.addNewLocation(newLocation);
            scooter.addNewLocation(newLocation);
            parc.addNewLocation(newLocation);

            return true;

        }else{
            return false;
        }
    }

    public boolean retournerScooter(Client client,Location location,LocalDate datedebut,LocalDate datefin,Scooter scooter,String kilometrage){
        try {
            client.getListLoc().remove(location);
            parc.getListeLocations().remove(location);
            scooter.setKilometrage(Float.parseFloat(kilometrage));
            scooter.getListeLocations().remove(location);
            Vector<Retoure> listRetoure = parc.getListeRetours();
            listRetoure.add(new Retoure(client, datefin, scooter.getKilometrage(), location));
            parc.setListeRetours(listRetoure);
            if(client.getListLoc().size()==0){
                parc.getListeClients().remove(client);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
