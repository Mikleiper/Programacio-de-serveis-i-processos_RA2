public class Associacio extends Thread {

    private int numSocis = 1000;
    private Soci[] socis;

    public Associacio() {
        iniciaCompteTempsSocis();
        esperaPeriodeSocis();
        mostraBalancComptes();
    }

    public void iniciaCompteTempsSocis() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
            socis[i].start();
        }
    }

    public void esperaPeriodeSocis() {
        for (int i = 0; i < numSocis; i++) {
            try {
                socis[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes() {
        Float saldoFinal = Compte.getInstancia().getSaldo();
        System.out.println("Saldo final del compte: " + saldoFinal);
    }

    public static void main(String[] args) {
        new Associacio();
    }
}
