
import java.util.Random;

public class Compte {
    //per guardar 1 unica instancia de la classe
    private static Compte instancia;

    private Float saldo;

    private Compte() {
        this.saldo = 0.0f;
    }

    public static synchronized  Compte getInstancia() {// synchronized per evitar q es puguin instanciar 2 al mateix temps amb fils diferents
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

}

public class Soci extends Thread{

    private Compte compte;

    private Float aportacio = 10.0f;
    private int maxAnys = 10;
    private Long esperaMax = 100L;
    private Random rnd;

    public Soci (Float aportacio, int maxAnys, Long esperaMax){
        this.compte = Compte.getInstancia();
        this.rnd = new Random();
    }

    public Compte getCompte(){
        return this.compte;
    }
}

    

