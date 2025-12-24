public class Futbolista extends Thread {

    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom); 
        this.ngols = 0;
        this.ntirades = 0;
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            // Si el random es major o igual a la probabilitat, es gol
            if (Math.random() >= PROBABILITAT) {
                ngols++;
            }
        }
    }

    public static void main(String[] args) {
        String[] nom_jugadors = {"Piqué","Vinicius","Torres","Ramos","Ronaldo","Lewan","Belli","Arnau","Aspas","Messi","Mbapé"};

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];

        System.out.println("Inici dels xuts --------------------");

        // 1. Es creen tots els fils
        for (int i = 0; i < jugadors.length; i++) {
            jugadors[i] = new Futbolista(nom_jugadors[i]);
        }

        // 2. S'inicien tots els fils
        for (int i = 0; i < jugadors.length; i++) {
            jugadors[i].start();
        }

        // 3. S'espera a tots els fils a que acabin
        for (int i = 0; i < jugadors.length; i++) {
            try {
                jugadors[i].join();
            } catch (InterruptedException e) {
                
            }
        }

        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");

        for (Futbolista f : jugadors) {
            System.out.println(f.getName() + " -> " + f.getNgols() + " gols");
        }
    }
}
