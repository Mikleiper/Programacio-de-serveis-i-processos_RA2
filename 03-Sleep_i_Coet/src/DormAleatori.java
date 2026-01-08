public class DormAleatori extends Thread {

    private long tempsConstruc;

    public DormAleatori(String nom){
        super(nom);
        this.tempsConstruc = System.currentTimeMillis();
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i ++){
            long interAleatori = ((long) (Math.random() * 1000));
            long totalConstruc = System.currentTimeMillis() - this.tempsConstruc;
            System.out.printf("%s (%d) a dormir %dms total %dms%n", getName(), i, interAleatori, totalConstruc);
            try {
                Thread.sleep(interAleatori);
            } catch (Exception e) {
                e.printStackTrace(); //imprimir l'error i a on ocurreix
            }
        }
    }
    
    public static void main(String[] args) {
        
        // 1. Es creen tots els fils
        DormAleatori person1 = new DormAleatori("Joan");
        DormAleatori person2 = new DormAleatori("Pep");

        // 2. S'inicien tots els fils
        person1.start();
        person2.start();

        System.out.println("-- Fi de main -----------");

    }
    
}
