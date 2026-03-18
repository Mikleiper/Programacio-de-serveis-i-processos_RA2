
import java.util.Random;

public class Fumador extends Thread {

    private Random rnd = new Random();

    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;
    private int fumades = 0;

    public Fumador(int id, Estanc estanc) {
        this.id = id;
        this.estanc = estanc;
    }

    private void fuma(){
        if (tabac!=null && paper!=null && llumi!=null){
            tabac = null;
            paper = null;
            llumi = null; 
            System.out.println("Fumador " + id + " fumant");
            fumades++;
            try {
                Thread.sleep(rnd.nextLong(500, 1001));
            } catch (InterruptedException e) {
            }            
            System.out.println("Fumador " + id + " ha fumat " + fumades + " vegades");
            }
    }

    public void compraTabac(){
        System.out.printf("Fumador %d comprant Tabac%n", id);
        tabac = estanc.venTabac();
    }

    public void compraPaper(){
        System.out.printf("Fumador %d comprant Paper%n", id);
        paper = estanc.venPaper();
    }

    public void compraLlumi(){
        System.out.printf("Fumador %d comprant Llumi%n", id);
        llumi = estanc.venLlumi();
    }

    @Override
    public void run(){
        while(fumades < 3){
            compraTabac();
            compraPaper();
            compraLlumi();
            fuma();
        }
    }
}