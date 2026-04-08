import java.util.Random;

public class Dona extends Thread {
    
    private BanyUnisex bany;
    Random rnd = new Random();

    public Dona (String nom, BanyUnisex bany){
        super(nom);
        this.bany = bany;
    }

    @Override
    public void run(){
        try {
        System.out.println(this.getName() + " vol entrar al bany");
        bany.entraDona(this.getName());

        Thread.sleep(rnd.nextLong(2000, 3001));

        bany.surtDona(this.getName());
        System.out.println(this.getName() + " ha acabat d'usar el bany");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
    }
    
}
