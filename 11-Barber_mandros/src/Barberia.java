
import java.util.LinkedList;


public class Barberia extends Thread{

    public static Barberia barberia;

    public LinkedList<Client> salaEspera;
    private int nMaxCadires;
    public Object condBarber;

    public Barberia(int nCadires){
        this.nMaxCadires = nCadires;
        this.salaEspera = new LinkedList<>();
        this.condBarber = new Object();
    }

    public synchronized Client seguentClient(){ //synch per evitar problemes de concurrència. Barber treu clients i Thread fica clients
        if(salaEspera.isEmpty()){
            return null;
        }
        return salaEspera.removeFirst();
    }
    
    public void entraClient(Client client){
        synchronized (condBarber) {
            if(salaEspera.size() < nMaxCadires){
                salaEspera.add(client);
                System.out.printf("Client %s en espera%n", client.getNom());
                condBarber.notify();          
            } else {
                System.out.printf("No queden cadires, client %s se'n va%n", client.getNom());
            }        
        }
    }

    @Override
    public void run(){
        for (int i = 1; i <= 10; i++) {
            entraClient(new Client(i));
            try { 
                sleep(500);
            } catch (InterruptedException e) {
            }
        }

        try {
            sleep(10000);
        } catch (InterruptedException e) {
        }

        for (int i = 11; i < 21; i++) {
            entraClient(new Client(i));
            try {
                sleep(500);
            } catch (InterruptedException e) {
            }
        }        
    }

    public static void main(String[] args) {
        barberia = new Barberia(3); // static  linia 7
        Barber barber = new Barber("Pepe");
        barber.start();
        barberia.start();
    }

}

