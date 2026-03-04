public class Forquilla {

    private int id;
    private int propietari = LLIURE;
    public static final int LLIURE = -1;

    public Forquilla(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPropietari() {
        return propietari;
    }

    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }

}
