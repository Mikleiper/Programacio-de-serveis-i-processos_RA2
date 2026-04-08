import java.util.Random;

public class Home extends Thread{
    
    private BanyUnisex bany;
    private Random rnd = new Random();

    public Home (String nom, BanyUnisex bany){
        super(nom);
        this.bany = bany;
    }



    @Override
    public void run(){
        try {
            System.out.println(this.getName() + " vol entrar al bany");
            bany.entraHome(this.getName());

            Thread.sleep(rnd.nextLong(1000, 2001));

            bany.surtHome(this.getName());
            System.out.println(this.getName() + " ha acabat d'usar el bany");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
