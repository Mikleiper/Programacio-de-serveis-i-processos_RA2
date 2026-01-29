import java.util.Random;

public class Assistent extends Thread{

    private Esdeveniment esdeveniment;

    public Assistent(int nom, Esdeveniment esdeveniment){
        super("Assistent-" + nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        while (true) { 
            esdeveniment.ferReserva(this);
            esdeveniment.cancelaReserva(this);
            Random rnd = new Random();
        }
    }
}
