public class Motor extends Thread {

    private int pActual;
    private int pObjectiu;
    private boolean ences; 
    
    public void setPotencia (int p){
        pObjectiu = p;
    }

    public void setEnces (boolean estat){
        this.ences = estat;
    }

    public Motor(int numero){
        super ("" + numero);  //el getName() de super necessita String
        // els atributs pActual i objectiu son autoproclamats = 0)
    }

    @Override
    public void run(){
        boolean enRepos = true;  // així no imprimeix FerRes al principi
        while (pObjectiu > 0 || pActual > 0 || ences){
            long interAleatori = ((long) ((Math.random() + 1.0) * 1000)); // interval entre 1-2 segons
            if(pActual < pObjectiu){
                try {
                    Thread.sleep(interAleatori);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pActual++;
                System.out.printf("Motor %s: Incre. Objectiu: %d Actual: %d%n", getName(), pObjectiu, pActual);
                enRepos = false;                
            }else if(pActual > pObjectiu){
                try {
                    Thread.sleep(interAleatori);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pActual--;
                System.out.printf("Motor %s: Decre. Objectiu: %d Actual: %d%n", getName(), pObjectiu, pActual);
                enRepos = false;
            } else {                
                if (!enRepos){
                    System.out.printf("Motor %s: FerRes Objectiu: %d Actual: %d%n", getName(), pObjectiu, pActual);
                    enRepos = true;
                }
                try { //tb sleep per no imprimir masses cops a la consola
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }                             
            }          
        }
    }
}
