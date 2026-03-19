import java.util.Random;

public class Barber extends Thread{
    
    public Random rnd = new Random();
    private String nom;

    public Barber(String nom) {
        this.nom = nom;
    }

    @Override
    public void run(){        
        boolean treballant = true;
        while(treballant){
            if(!salaEspera.isEmpty()){
                Client client = Barberia.barberia.seguentClient();
                System.out.printf("Li toca al client %s\n", client.getNom());
                System.out.printf("Tallant cabell a %s\n", client.getNom());
                client.tallarseCabell();
                try {
                    Thread.sleep(rnd.nextLong(100)+900);
                } catch (InterruptedException e) {
                    treballant = false;
                }
            } else {
                System.out.printf("Barber %s dormint", this.nom);
                try {
                    synchronized (Barberia.barberia.condBarber) { 
                        Barberia.barberia.condBarber.wait();
                    }        
                } catch (InterruptedException e) {
                    treballant = false;
                }
            }
        }
    }
}
