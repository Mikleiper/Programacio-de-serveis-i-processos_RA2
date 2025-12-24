public class MainDemoFil {

    public static void main(String[] args) {
        // Capturem el fil actual en execució
        Thread t = Thread.currentThread();

        System.out.println("Prioritat -> " + t.getPriority() + ", Nom -> " + t.getName());
        System.out.println("toString() -> " + t.toString());
    }

}
