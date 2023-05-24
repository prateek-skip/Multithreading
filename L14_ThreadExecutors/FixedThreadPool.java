

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Work implements Runnable {
    private int id;

    public Work(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Work with id "+id+"is in work - thread id: "+ Thread.currentThread().getName());
        long duration = (long)Math.random()*5;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}






public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i=0;i<10;++i){
            executor.execute(new Work(i+1));
        }

        // we prevent the executor to execute any further tasks
        executor.shutdown();

        // terminate actual (running) tasks

        try {
            if(!executor.awaitTermination(1000,TimeUnit.MILLISECONDS)){
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
            executor.shutdownNow();
        }

    }
}

