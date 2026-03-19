
import java.util.LinkedList;


public class Barberia {

    public static Barberia barberia;

    private int nCadires;
    public LinkedList<Client> salaEspera;
    int nMaxCadires;
    Object condBarber;

    public Barberia(int nCadires){
        this.nCadires = nCadires;
        salaEspera = new LinkedList<Client>();
        condBarber = new Object();
    }

    public synchronized Client seguentClient(){ //synch per evitar problemes de concurrència. Barber treu clients i Thread fica clients
        if(salaEspera.isEmpty()){
            return null;
        }
        return salaEspera.removeFirst();
    }
    
    public synchronized void entraClient(Client client){
        if(salaEspera.size() < nMaxCadires){
            salaEspera.add(client);
            System.out.printf("Client%s en espera", client.getNom());
            synchronized(condBarber){
                condBarber.notify();
            }
        
        }
        System.out.printf("No queden cadires, client %s se'n va", client.getNom());

    }

}