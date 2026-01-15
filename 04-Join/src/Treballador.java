
import java.util.Random;

public class Treballador extends Thread {

    
    private float sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd;

    public Treballador(int nom, float sou_anual_brut,int edat_inici_treball, int edat_fi_treball){
        super("Ciutadà-"+ nom);
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    public void cobra(){
        float increment = sou_anual_brut / 12;
        cobrat += increment;
    }

    public void pagaImpostos() {
        float impost = 0.24f * (sou_anual_brut/12);
        cobrat-= impost;
    }

    @Override
    public void run(){
        for ( int i = edat_inici_treball; i <= edat_fi_treball; i++){
            edat_actual = i;
            for ( int j = 0; j < 12; j++){
                cobra();
                pagaImpostos();
                try {
                    Thread.sleep(rnd.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getEdat() {
        return edat_actual;
    }

    public float getCobrat() {
        return cobrat;
    }

    
}
