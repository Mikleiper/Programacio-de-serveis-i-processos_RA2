public class Administracio {

    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa = new Treballador[50];

    public Administracio(){
        for (int i = 0; i < num_poblacio_activa; i++){
            poblacio_activa[i] = new Treballador(i, 25000, 20, 65);
        }        
    }

    public static void main(String[] args) {
        Administracio admin = new Administracio();
        for (Treballador t : admin.poblacio_activa){
            t.start();
        }
        for (Treballador t : admin.poblacio_activa){
            try {
                t.join();
                System.out.printf("%s -> edat: %d / total: %.2f\n", t.getName(), t.getEdat(), t.getCobrat());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
