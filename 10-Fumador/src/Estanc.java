
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc {
    
    Random rnd = new Random();

    private List <Tabac> tabacs ;
    private List <Paper> papers ;
    private List <Llumi> llumins ;
    
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

    public void tancarEstanc(){
        System.out.println("Estanc tancat");
        this.interrupt();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*List <Tabac> tabacs = new ArrayList<>();
    List <Paper> papers = new ArrayList<>();
    List <Llumi> llumins = new ArrayList<>();

    public Estanc() {
        System.out.println("Estanc obert");
    }

    public synchronized void nouSubministrament() {
        int producte = (int) (Math.random() * 3);
        switch (producte) {
            case 0:
                tabacs.add(new Tabac());
                System.out.println("Afegit Tabac");
                break;
            case 1:
                papers.add(new Paper());
                System.out.println("Afegit Paper");
                break;
            case 2:
                llumins.add(new Llumi());
                System.out.println("Afegit Llumi");
                break;
        }
        notifyAll();
    }

    public synchronized void comprarTabac() throws InterruptedException {
        while (tabacs.isEmpty()) wait();
        tabacs.remove(0);
    }

    public synchronized void comprarPaper() throws InterruptedException {
        while (papers.isEmpty()) wait();
        papers.remove(0);
    }

    public synchronized void comprarLlumi() throws InterruptedException {
        while (llumins.isEmpty()) wait();
        llumins.remove(0);
    }*/

}
