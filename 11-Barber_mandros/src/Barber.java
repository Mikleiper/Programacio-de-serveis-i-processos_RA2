import java.util.Random;

public class Barber extends Thread{
    
    public Random rnd = new Random();
    private String nom;

    public Barber(String nom) {
        this.setName(nom);
    }

    @Override
    public void run(){        
        boolean treballant = true;
        while(treballant){
            Client client; // abans del synch pe si no desapareix la instancia d client quan surt dl bloc
            synchronized (Barberia.barberia.condBarber){
                client = Barberia.barberia.seguentClient();

            if (client == null) {
                    System.out.println("Ningú en espera"); 
                    System.out.printf("Barber %s dormint%n", getName());
                    try {
                        Barberia.barberia.condBarber.wait();
                    } catch (InterruptedException e) {
                        treballant = false;
                    }
                    continue; // Quan despertar, torna a l'inici del while per obtenir un client
                }
            }

            System.out.printf("Li toca al client %s%n", client.getNom());
            System.out.printf("Tallant cabell a %s%n", client.getNom());
            client.tallarseCabell();

            try {
                Thread.sleep(rnd.nextLong(100) + 900); // 0,9s + random 0,1s
            } catch (InterruptedException e) {
                treballant = false;
            }
        }
    }
}
