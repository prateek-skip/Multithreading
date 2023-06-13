import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstWorker implements Runnable {
    private BlockingQueue<String> qu;

    public FirstWorker(BlockingQueue<String> qu){
        this.qu = qu;
    }
    @Override
    public void run() {
        try {
            qu.put("B");
            qu.put("H");
            qu.put("F");
            Thread.sleep(2000);
            qu.put("A");
            qu.put("Z");
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        
    }
}

class SecondWorker implements Runnable {
    private BlockingQueue<String> qu;

    public SecondWorker(BlockingQueue<String> qu){
        this.qu = qu;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        System.out.println(qu.take());
        Thread.sleep(1000);
        System.out.println(qu.take());
        Thread.sleep(2000);
        System.out.println(qu.take());
        System.out.println(qu.take());
        System.out.println(qu.take());
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        
    }
}



public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        PriorityBlockingQueue<String> qu = new PriorityBlockingQueue<>();

        FirstWorker first = new FirstWorker(qu);

        SecondWorker second = new SecondWorker(qu);

        new Thread(first).start();
        new Thread(second).start();
    }    
}
