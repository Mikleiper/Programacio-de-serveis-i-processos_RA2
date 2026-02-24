import java.util.Random;

public class Filosof extends Thread {
    
    private int gana;
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;

    public Filosof(String name) {
        super(name);
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }
    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }
    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }
    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }
    public int getGana() {
        return gana;
    }
    public void setGana(int gana) {
        this.gana = gana;
    }

    public void menjar() {
        boolean haMenjat = false;
        Random rnd = new Random();

        while (!haMenjat) {
            if (!forquillaEsquerra.isEnUs()){
                forquillaEsquerra.setEnUs(true);
                System.out.printf("Filòsof: %s agafa la forquilla esquerra %d%n", getName(), forquillaEsquerra.getId());
                if (!forquillaDreta.isEnUs()){
                    forquillaDreta.setEnUs(true);
                    System.out.printf("Filòsof: %s agafa la forquilla dreta %d%n", getName(), forquillaDreta.getId());
                    System.out.printf("Filòsof: %s menja%n", getName());

                    try {
                        Long temps = (long) (rnd.nextLong(1000,2000));
                        sleep(temps);
                    } catch (Exception e) {
                    }
                    System.out.printf("Filòsof: %s ha acabat de menjar%n", getName());
                    forquillaDreta.setEnUs(false);
                    forquillaEsquerra.setEnUs(false);
                    gana = 0;
                    haMenjat = true;
                    
                } else {
                    forquillaEsquerra.setEnUs(false);
                    System.out.printf("Filòsof: %s deixa l'esquerra (%d) i espera (dreta ocupada)%n", getName(), forquillaEsquerra.getId());
                }
            } else {
                System.out.printf("Filòsof: %s tracta d'agafar la forquilla esquerra (%d) però està ocupada%n", getName(), forquillaEsquerra.getId());
            }

            if (!haMenjat) {
                gana++;
                System.out.printf("Filòsof: %s gana=%d%n", getName(), getGana());
                try{
                    sleep(rnd.nextLong(500,1000));
                } catch (Exception e){
                }
            }
        }       
    }

    public void pensar() {
        Random rnd = new Random();
        System.out.printf("Filòsof: %s pensant%n", getName());
        try {
            Long temps = (long) (rnd.nextLong(1000,2000));
            sleep(temps);
        } catch (Exception e) {}
    }

    @Override
    public void run(){
        Random rnd = new Random();
        while (true) {
            menjar();
            pensar();
        }
    }

}
