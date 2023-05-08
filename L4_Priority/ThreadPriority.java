class Worker implements Runnable{
    
    @Override
    public void run() {
        for(int i=0;i<10;++i){
            System.out.println("Runner1:- "+i);
        }
        
    }
}

class Worker2 implements Runnable{
    
    @Override
    public void run() {
        for(int i=0;i<10;++i){
            System.out.println("Runner2:- "+i);
        }
        
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker());
        
        Thread t2 =  new Thread(new Worker2());
        t1.currentThread().setPriority(4);
        
        t2.currentThread().setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        try {
            
        t2.join();   
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        // main thread is always called first
        System.out.println("From main thread");
    }    
}
