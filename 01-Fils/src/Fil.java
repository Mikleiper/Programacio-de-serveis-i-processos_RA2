public class Fil extends Thread {

    private int comptador;
    private long delay;
    //constructor de la classe pare per assignar nom
    public Fil(String nom, int comptador, long delay) {
        // Llamamos al constructor de la clase padre Thread para asignar el nombre/id
        // Teoría: "public Thread(String nom) -> rep el nom/id" [PDF pág 4]
        super(nom);
        this.comptador = comptador;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= comptador; i++) {
            
            for (int j = 0; j < 1000; j++) {
                // treball fictici
            }
            System.out.println(this.getName() + " " + i);

        }
        System.out.println("Acaba el fil " + this.getName());
    }

}
