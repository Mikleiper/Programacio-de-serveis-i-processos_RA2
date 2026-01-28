

public class Compte {
    //per guardar 1 unica instancia de la classe
    private static Compte instancia;

    private Float saldo;

    private Compte() {
        this.saldo = 0.0f;
    }

    public static synchronized Compte getInstancia() {// synchronized per evitar q es puguin instanciar 2 al mateix temps amb fils diferents
        if (instancia == null) {//Garantim 1 sola instancia
            instancia = new Compte();
        }
        return instancia;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public synchronized void ingressar(Float quantitat) {
        this.saldo = saldo + quantitat;
    }

    public synchronized void retirar(Float quantitat) {
        this.saldo = saldo - quantitat;
    }

}
