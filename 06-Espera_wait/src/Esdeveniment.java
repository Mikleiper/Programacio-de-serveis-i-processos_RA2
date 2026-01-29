import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {

    private List<Assistent> assistents;
    private int placesMax = 5;
    private int placesDisponibles;
    
    public Esdeveniment(int placesMax) {
        this.placesDisponibles = placesMax;
        assistents = new ArrayList<Assistent>(10);
    }
    
    public void setAssistents(Assistent assistent){
        assistents.add(assistent);
    }

    public void synchronized ferReserva(Assistent assistent) {
        while (placesDisponibles < 1){
            try {
                wait();
            } catch (Exception e) {
                
            }
        }

        if ( placesDisponibles > 0 && placesDisponibles <= placesMax){
            placesDisponibles--;
            setAssistents(assistent);
        }
        
        
    }

    public void synchronized cancelaReserva(Assistent assistent) {
        if (assistents.contains(assistent)) {
            assistents.remove(assistent);
            placesDisponibles++;
            notifyAll();
        }
    }

    
}


