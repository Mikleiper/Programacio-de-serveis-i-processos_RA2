
import java.util.Scanner;

public class Coet {

    private Motor motors[] = new Motor[4];

    public Coet(){    
        for (int i = 0; i < 4; i++){
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p){
        if (p >= 0 && p <= 10){
            for (int i = 0; i < 4; i++) {
                motors[i].setPotencia(p);
                if(p == 0) {
                    motors[i].setEnces(false); // apaguem motors
                }
            }
        } else {
            System.out.println("El valor Potencia té que ser un valor entre 0 i 10");
        }
    }

    public void arranca(){
        for (int i = 0; i < 4; i++) {
                motors[i].setEnces(true); //s'encenen els motors
                motors[i].start();
            }
    }

    public static void main(String[] args) {
        //creem els 4 fils
        Coet coet = new Coet();
        //iniciem els fils
        coet.arranca();

        Scanner sc = new Scanner(System.in); // per llegir inputs de teclat
        int p = sc.nextInt();
        System.out.printf("Passant a potència %d%n", p);
        while (p != 0) {
            coet.passaAPotencia(p);
            p = sc.nextInt();
            System.out.printf("Passant a potència %d%n", p);            
        }
        coet.passaAPotencia(p);
        sc.close();
    }
}
