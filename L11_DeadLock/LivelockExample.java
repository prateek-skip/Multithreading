import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {
    
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    
    public static void main(String[] args) {
        LivelockExample livelockExample = new LivelockExample();

        new Thread(livelockExample::worker1, "worker1").start();
        new Thread(livelockExample::worker2, "worker2").start();

    }

    public void worker1(){
        while(true){
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Worker1  acquires the lock1...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Worker1 tries to get lock2....");
             
            if(lock2.tryLock()){
                System.out.println("Worker1 acquires the lock 2");
                lock2.unlock();
            } else {
                System.out.println("Worker1 cannot acquire lock2....");
                continue;
            }

            break;
        }

        lock1.unlock();
        lock2.unlock();
    }


    public void worker2() {
        while(true){
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Worker2  acquires the lock2...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Worker2 tries to get lock1....");
             
            if(lock1.tryLock()){
                System.out.println("Worker2 acquires the lock1");
                lock1.unlock();
            } else {
                System.out.println("Worker2 cannot acquire lock1....");
                continue;
            }

            break;
        }

        lock1.unlock();
        lock2.unlock();
    }
}