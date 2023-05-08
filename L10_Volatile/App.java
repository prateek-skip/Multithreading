

class Worker implements Runnable {

    // it wil be stored in the main memory and not in CPU cache due to volatile keyword

    private volatile boolean terminated;

    @Override
    public void run() {
        while(!terminated){
            System.out.println("Working class is running......");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();    
            }
        }
    }

    public boolean isTerminated(){
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

}

public class App {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        worker.setTerminated(true); 
        System.out.println("Algorithm is terminated.....");
     
    }
}
