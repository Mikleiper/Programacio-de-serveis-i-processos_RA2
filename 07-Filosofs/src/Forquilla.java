public class Forquilla {
    private int id;
    private boolean enUs = false;
        
    public Forquilla(int id) {
        this.id = id;
    }

    public boolean isEnUs() {
        return enUs;
    }

    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }

    public int getId(){
        return id;
    }

}