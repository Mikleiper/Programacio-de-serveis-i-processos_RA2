public class Barri {

    private Estanc estanc;
    private Fumador[] fumadors = new Fumador[3];

    public Barri(){
        estanc = new Estanc();
        for (int i = 0; i < fumadors.length; i++) {
            fumadors[i] = new Fumador(i, estanc);
        }
    }

    public static void main(String[] args) {
        Barri barri = new Barri();
        
        barri.estanc.start();
        for (Fumador f: barri.fumadors){
            f.start();
        }
        
        for (Fumador f: barri.fumadors){
            try {
                f.join();
            } catch (InterruptedException e) {
            }
        }        
        barri.estanc.tancarEstanc();
    }
    
}
