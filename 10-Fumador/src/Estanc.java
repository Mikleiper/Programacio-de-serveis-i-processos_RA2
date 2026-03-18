
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {
    
    private Random rnd = new Random();

    private List <Tabac> tabacs ;
    private List <Paper> papers ;
    private List <Llumi> llumins ;
    private boolean obert = true;
    
    public Estanc() {
        tabacs = new ArrayList<>();
        papers = new ArrayList<>();
        llumins = new ArrayList<>();
    }

    private synchronized void addTabac(Tabac t){
        System.out.println("Afegint Tabac");
        tabacs.add(t);
        notifyAll();
    }

    private synchronized void addPaper(Paper p){
        System.out.println("Afegint Paper");
        papers.add(p);
        notifyAll();
    }

    private synchronized void addLlumi(Llumi l){
        System.out.println("Afegint Llumi");
        llumins.add(l);
        notifyAll();
    }

    private synchronized void nouSubministrament(){
        int producte = rnd.nextInt(1,4); /// genera int del 1 al 3
        if(producte == 1){
            addTabac(new Tabac());
        }else if(producte == 2){
            addPaper(new Paper());
        }else{
            addLlumi(new Llumi());
        }
    }

    public synchronized Tabac venTabac(){
        while(tabacs.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return tabacs.remove(0);
    }

    public synchronized Paper venPaper(){
        while(papers.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return papers.remove(0);
    }

    public synchronized Llumi venLlumi(){
        while(llumins.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return llumins.remove(0);
    }

    public void tancarEstanc() {
        obert = false;
        synchronized (this) {
            notifyAll();
        }
        System.out.println("Estanc tancat");
    }
    
    @Override
    public void run(){
        System.out.println("Estanc obert");
        while(obert){
            nouSubministrament();
            try {
                Thread.sleep(rnd.nextLong(500, 1501));
            } catch (InterruptedException e) {
            }
        }
        this.interrupt();        
    }       
}
