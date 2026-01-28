import java.util.Random;

public class Soci extends Thread{

    private Compte compte;
    private Float aportacio = 10.0f;
    private int maxAnys = 10;
    private Long esperaMax = 100L;
    private Random rnd;

    public Soci (){
        this.compte = Compte.getInstancia();
        this.rnd = new Random();
    }

    public Compte getCompte(){
        return this.compte;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxAnys; i++) {
            for (int j = 0; j < 12; j++) {
                if (j%2 == 0) {
                    compte.ingressar(aportacio);
                } else {
                    compte.retirar(aportacio);
                }

                try {
                    Thread.sleep(rnd.nextLong(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
