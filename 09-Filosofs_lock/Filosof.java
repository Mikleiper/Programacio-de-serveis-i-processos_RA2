public class Filosof {
    int iniciGana;
    int fiGana;
    int gana;
    private int nomComensal;
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;

    public Filosof(int id){
        this.nomComensal = id;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public int calcularGana(){
        return gana = fiGana - iniciGana;
    }

    public void resetGana(){
        iniciGana = (int) (System.currentTimeMillis()/1000);
        gana = 0;
    }

    public void pensar(){
        iniciGana = (int) (System.currentTimeMillis()/1000);
    }

    public void agafarForquillaEsquerra(){
        forquillaEsquerra.agafar();
    }

    public void agafarForquillaDreta(){
        forquillaDreta.agafar();
    }

    public void menjar(){

    }



}
