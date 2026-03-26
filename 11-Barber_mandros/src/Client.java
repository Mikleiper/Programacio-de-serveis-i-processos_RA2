

public class Client {
    private int id;
    private String nom = "Client-";
    
    public Client(int id) {
        this.nom = nom + id;
    }

    public String getNom() {
        return nom;
    }

    public void tallarseCabell(){
    }
}
