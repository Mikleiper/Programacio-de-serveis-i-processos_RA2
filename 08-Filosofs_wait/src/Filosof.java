import java.util.Random;

public class Filosof extends Thread{
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana = 0;
    private int nComensal;

    public Filosof(int id){
        nComensal=id;
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

    public int getNComensal() {
        return nComensal;
    }

    public boolean agafarForquillaEsquerra() {
        synchronized(forquillaEsquerra) {
            if (forquillaEsquerra.getPropietari() == Forquilla.LLIURE) {
                forquillaEsquerra.setPropietari(getNComensal());
                System.out.printf("Filòsof: %d agafa la forquilla esquerra %d%n", getNComensal(), forquillaEsquerra.getId());
                return true;
            }
            return false;
        }
    }

    public boolean agafarForquillaDreta() {
        synchronized(forquillaDreta) {
            if (forquillaDreta.getPropietari() == Forquilla.LLIURE) {
                forquillaDreta.setPropietari(getNComensal());
                System.out.printf("Filòsof: %d agafa la forquilla dreta %d%n", getNComensal(), forquillaDreta.getId());
                return true;
            }
            return false;
        }
    }

    public boolean agafarForquilles(){    
        if (agafarForquillaEsquerra()){
            if (agafarForquillaDreta()){
                return true;
            } else {
                System.out.printf("Filòsof: %d deixa l'esquerra (%d) i espera (dreta ocupada)%n", getNComensal(), forquillaEsquerra.getId());
                deixarForquilles();
                return false;
            }            
        } else {
            return false;
        }
    }

    public void deixarForquilles() {
        synchronized (forquillaEsquerra) {
            if (forquillaEsquerra.getPropietari() == getNComensal()) {
                forquillaEsquerra.setPropietari(Forquilla.LLIURE);
                forquillaEsquerra.notifyAll();
            }
        }
        synchronized (forquillaDreta) {
            if (forquillaDreta.getPropietari() == getNComensal()) {
                forquillaDreta.setPropietari(Forquilla.LLIURE);
                forquillaDreta.notifyAll();
            }
        }
    }

    public void menjar(){
        Random rnd = new Random();
        while (true) {
            if (agafarForquilles()) {
                gana = 0;
                System.out.printf("Filòsof: %d menja%n", getNComensal());
                synchronized (this) {
                    try {
                        wait(rnd.nextLong(1000, 2000)); // Temps menjant
                    } catch (InterruptedException e) {}
                }
                System.out.printf("Filòsof: %d ha acabat de menjar%n", getNComensal());
                deixarForquilles();
                break;
            }
            
            gana++;// Si no té les dues forquilles, ++gana i esperem abans de reintentar
            System.out.printf("Filosof: fil%d gana = %d%n", getNComensal(), gana);
            synchronized (this) {
                try {
                    wait(rnd.nextLong(500, 1000));
                } catch (InterruptedException e) {}
            }
        }

    }

    public void pensar() {
        Random rnd = new Random();
        System.out.printf("Filòsof: %d pensant%n", getNComensal());
        synchronized (this) {
            try {
                wait(rnd.nextLong(1000, 2000)); // Temps pensant
            } catch (InterruptedException e) {}
        }
    }

    @Override
    public void run(){
        Random rnd = new Random();
        while (true){
            if (rnd.nextBoolean()) {
                menjar();
            } else {
                pensar();
            }
        }
    }

}
