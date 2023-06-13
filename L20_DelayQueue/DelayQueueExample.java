import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


// Blocking Queue is an unbounded BlobkingQueue of objects that implement the Delayed interface


// It keeps keeps the elements internally until a certain delay has expired 
// an object can only be taken from the queue when it's delay has expired
class DelayedWorker implements Delayed {
    private long duration;
    private String message;

    public DelayedWorker(String message, long duration){
        this.message = message;
        this.duration = System.currentTimeMillis()+ duration;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        // this is the method that can compare objects
        if(duration < ((DelayedWorker) o).getDuration()){
            return -1;
        } 

        
        if(duration > ((DelayedWorker) o).getDuration()){
            return 1;
        } 
        return 0;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DelayWorker [duration=" + duration + ", message=" + message + "]";
    }
    
    
}

public class DelayQueueExample {
    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> qu = new DelayQueue<>();
        try {
         
        qu.put(new DelayedWorker("This is the first message", 2000));
        qu.put(new DelayedWorker("This is the second message", 10000));
        qu.put(new DelayedWorker("This is the third message", 4500));
           
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(!qu.isEmpty()){
            try {
                System.out.println(qu.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }    
}
