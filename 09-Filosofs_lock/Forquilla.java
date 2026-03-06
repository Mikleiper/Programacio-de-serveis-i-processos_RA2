import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    
    private final ReentrantLock bloqueig = new ReentrantLock(true); //reentrantlock en comptes de lock pq lock NO té el metode isHledByCUrrentTHread
    private int num;
    
    public Forquilla(int num){
        this.num = num;
    }

    public int getNum(){
        return num;
    }

    public void agafar(){
        bloqueig.lock();
    }

    public void deixar(){
        if (bloqueig.isHeldByCurrentThread()){
            bloqueig.unlock();
        }
    }
    
}
