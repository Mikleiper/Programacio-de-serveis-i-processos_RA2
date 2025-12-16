public class PrincipalDiferents {

     public static void main(String[] args) {
        
        Fil juan = new Fil("Juan", 10, 0);
        Fil pepe = new Fil("Pepe", 1, 0);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }

}
