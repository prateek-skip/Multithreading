import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    private int id;
    private Lock lock;
    
    public Book(int id){
        this.id = id;
        this.lock = new ReentrantLock();
    }


    public void read(Student student) throws InterruptedException{
        if(lock.tryLock(10000, TimeUnit.MILLISECONDS)){
            
        System.out.println(student+" starts reading "+this);
        Thread.sleep(2000);
        lock.unlock();
        System.out.println(student+" has finished rading "+this);
        }
        


    }

    @Override
    public String toString() {
        return "Book: "+ this.id;
    }


}
