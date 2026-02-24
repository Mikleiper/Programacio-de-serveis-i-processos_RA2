public class Taula {
    private final Forquilla[] forquilles;
    private final Filosof[] comensals;

    public Taula(int numFilosofs) {
        forquilles = new Forquilla[numFilosofs];
        comensals = new Filosof[numFilosofs];

        for (int i = 0; i < forquilles.length; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i <comensals.length; i++) {
            comensals[i] = new Filosof("fil"+i);
            comensals[i].setForquillaEsquerra(forquilles[i]);
            if (i < numFilosofs-1){
                comensals[i].setForquillaDreta(forquilles[i+1]);
            } else {
                comensals[i].setForquillaDreta(forquilles[0]);
            }
        }
    }

    public void showTaula() {
        for (Filosof f: comensals){
            System.out.printf("Comensal:%s esq:%d dret:%d%n",f.getName(),f.getForquillaEsquerra().getId(), f.getForquillaDreta().getId());
        }
        System.out.println("--------------------------------");
    }

    public void cridarATaula(){
        for( Filosof f: comensals){
            f.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }

}
