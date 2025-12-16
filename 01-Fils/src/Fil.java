public class Fil extends Thread {

    private long delay;
    //constructor de la classe pare per assignar nom
    public Fil(String nom, int priority, long delay) {        
        super(nom); //nom del fil creat a cada clase principal(Iguals,Diferents i Estricte)
        setPriority(priority);
        this.delay = delay;
    }

    @Override
    public void run() {
        // per iguals i diferents
        if (delay == 0){
            for (int j = 0; j < 1000; j++) {
                // treball fictici
            }
        }
        
        for (int i = 1; i < 10; i++) {
            System.out.println(this.getName() + " " + i);
            // per estricte
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Acaba el fil " + this.getName());
    }

}
