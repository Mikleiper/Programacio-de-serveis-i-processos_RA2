package src;

import java.util.Random;

public class Filosof extends Thread{
    private long iniciGana;
    private long fiGana;
    private int gana;
    private int nomComensal;
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;

    Random rnd = new Random();

    public Filosof(int id){
        this.nomComensal = id;
    }

    public int getComensal(){
        return this.nomComensal;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public void calcularGana(){
        this.fiGana = (System.currentTimeMillis());
        this.gana = (int) (this.fiGana - this.iniciGana) / 1000;
        System.out.printf("Fil%d menja amb gana %d%n", this.getComensal(), this.gana);
    }

    public void resetGana(){        
        this.iniciGana = (System.currentTimeMillis());
        this.gana = 0;
        System.out.printf("Fil%d ha acabat de menjar%n", this.nomComensal);
    }

    public void pensar(){
        
        iniciGana = (System.currentTimeMillis());
        try {
            this.sleep(rnd.nextLong(1000, 2000));
        } catch (Exception e) {
        }
        System.out.printf("Fil%d pensant%n", this.nomComensal);
    }

    public void agafarForquillaEsquerra(){
        forquillaEsquerra.agafar();
    }

    public void agafarForquillaDreta(){
        forquillaDreta.agafar();
    }

    public void deixarForquilles(){
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.printf("Fil%d deixa les forquilles%n", this.nomComensal);
    }

    public void agafarForquilles(){ // no calen condiciosn if pq Lock ja comprova si està agafada o no
        agafarForquillaEsquerra();
        agafarForquillaDreta();
        System.out.printf("Fil%d té forquilles esq(%d) dreta(%d)%n", this.nomComensal, this.getForquillaEsquerra().getNum(), this.getForquillaDreta().getNum() );
    }

    public void menjar(){
        agafarForquilles();
        calcularGana();
        try {
            this.sleep(rnd.nextLong(1000, 2000));
        } catch (Exception e) {
        }        
        resetGana(); 
        deixarForquilles();       
    }

    @Override
    public void run(){
        while (true) { 
        pensar();
        menjar();
        }
    }
}
