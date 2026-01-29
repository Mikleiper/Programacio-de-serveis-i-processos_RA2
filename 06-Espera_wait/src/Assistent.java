import java.util.Random;

public class Assistent extends Thread{

    private Esdeveniment esdeveniment;

    public Assistent(int nom, Esdeveniment esdeveniment){
        super("Assistent-" + nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) { 
            if (rnd.nextBoolean()){
                esdeveniment.ferReserva(this);
            } else {
                esdeveniment.cancelaReserva(this);
            }
            try {
                Thread.sleep(rnd.nextInt(1001));
            } catch (InterruptedException e) {
                
            }
        }
    }
}
