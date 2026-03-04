public class Taula {

    private Filosof[] comensals;
    private Forquilla[] forquilles;

    public Taula(int nFilosofs) {
        comensals = new Filosof[nFilosofs];
        forquilles = new Forquilla[nFilosofs];

        for (int i = 0; i < forquilles.length; i++) {
            forquilles[i] = new Forquilla(i);
        }
        for (int i = 0; i < comensals.length; i++) {
            comensals[i] = new Filosof(i);
            comensals[i].setForquillaEsquerra(forquilles[i]); //metode alternatiu -> comensals[i].setForquillaDreta(forquilles[(i + 1) % nFilosofs])
            if (i < nFilosofs-1){
                comensals[i].setForquillaDreta(forquilles[i+1]);
            } else {
                comensals[i].setForquillaDreta(forquilles[0]);
            }
        }
    }

    public void showTaula(){
        for (Filosof f: comensals){
            System.out.printf("Comensal:fil%d esq:%d dret:%d%n",
            f.getNComensal(), 
            f.getForquillaEsquerra().getId(), 
            f.getForquillaDreta().getId());
        }
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
