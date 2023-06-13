import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable {
    private BlockingQueue<Integer> qu;

    public FirstWorker(BlockingQueue<Integer> qu){
        this.qu = qu;
    }

    @Override
    public void run() {
        int counter = 0;
        while(true){
            try {
                qu.put(counter);
                System.out.println("Putting item into the queue..... "+ counter);
                counter++;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class SecondWorker implements Runnable {
    private BlockingQueue<Integer> qu;

    public SecondWorker(BlockingQueue<Integer> qu){
        this.qu = qu;
    }

    @Override
    public void run() {
        while(true){
            try {
                int counter = qu.take();
                System.out.println("removing item into the queue..... "+ counter);
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    
    FirstWorker firstWorker = new FirstWorker(queue);
    SecondWorker secondWorker = new SecondWorker(queue);


    new Thread(firstWorker).start();
    new Thread(secondWorker).start();
    }



}
