
class Process {
    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Running the produce method....");
            wait();
            System.out.println("Continued producer.....");
        }

    }

    public void consume() throws InterruptedException{
        Thread.sleep(1000);
        synchronized(this){
            System.out.println("Consume method is executed.....");
            notify();

            // it is not going to handle the lock instantly : we can make further operations
            Thread.sleep(3000);
            System.out.println("After noify in consume");
        }
    }
}

public class App {
    public static void main(String[] args) {
        Process process = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
        });

        t1.start();
        t2.start();

    }
}