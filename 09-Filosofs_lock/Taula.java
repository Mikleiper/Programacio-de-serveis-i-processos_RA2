
public class Taula {
    Filosof[] comensals;
    Forquilla[] forquilles;
    private int nFilosofs;

    public Taula(int nFilosofs){
        comensals = new Filosof[nFilosofs];
        forquilles = new Forquilla[nFilosofs];

        for (int i = 0; i < forquilles.length; i++){
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < comensals.length; i++){
            comensals[i] = new Filosof(i);
            comensals[i].setForquillaEsquerra(forquilles[i]);
            if((i+1)%nFilosofs == 0){
                comensals[i].setForquillaDreta(forquilles[0]);
            } else {
                comensals[i].setForquillaDreta(forquilles[i+1]);
            }            
        }
    }

    public void showTaula(){
        for (Filosof f:comensals){
            System.out.printf("Comensal:Fil%d esq:%d dret:%d%n",
            f.getComensal(),
            f.getForquillaEsquerra().getNum(), 
            f.getForquillaDreta().getNum());
        }        
    }

    public void cridarATaula(){
        for( Filosof f: comensals){
            f.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(5);
        taula.showTaula();
        taula.cridarATaula();
    }
}
