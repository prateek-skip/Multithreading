
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopsticks {
    private int id;
    private Lock lock;
     
    public Chopsticks(int id){
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(Philosphers philospher, State state) throws InterruptedException{
        // this is where we will simulate deadlock
            if(lock.tryLock(10,TimeUnit.MILLISECONDS)){
                System.out.println(philospher + " picked up "+ state.toString()+" "+ this);
                return true;
            }
            return false;
        
    }

    public void putDown(Philosphers philospher, State state){
        lock.unlock();
        System.out.println(philospher + "puts down "+ state.toString()+" "+ this);
    }

    @Override
    public String toString() {
        
        return "Chopstick : "+id;
    }
}
