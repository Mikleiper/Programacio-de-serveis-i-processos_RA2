import java.util.Random;

public class Filosof extends Thread{
    private long iniciGana;
    private long fiGana;
    private long gana;
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
        this.gana = this.fiGana - this.iniciGana;
        System.out.printf("Fil%d menja amb gana %d%n", this.getComensal(), this.gana);
    }

    public void resetGana(){
        iniciGana = (System.currentTimeMillis());
        this.gana = 0;
        System.out.printf("Fil%d ha acabat de menjar%n", this.nomComensal);
    }

    public void pensar(){
        iniciGana = (System.currentTimeMillis());
        try {
            this.sleep(1000,2000);
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
    }

    public void menjar(){
        agafarForquilles();
        try {
            this.sleep(1000,2000);
        } catch (Exception e) {
        }
        calcularGana();
        resetGana();        
    }

    @Override
    public void run(){
        while (true) { 
            if(rnd.nextBoolean()){
                menjar();
                deixarForquilles();
            } else {
                pensar();
            }
        }
    }



}
