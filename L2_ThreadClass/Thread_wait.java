class Runner1 extends Thread {


    @Override
    public void run(){
        for(int i=0;i<10;++i){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner1:- "+i);
        }
    }

    public void execute() {
        for(int i=0;i<10;++i){
            System.out.println("Runner1:- "+i);
        }
    }
}

class Runner2 extends Thread{

    @Override
    public void run(){
        for(int i=0;i<10;++i){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner2:- "+i);
        }
    }

    public void execute() {
        for(int i=0;i<10;++i){
            System.out.println("Runner2:- "+i);
        }
    }
}

public class Thread_wait {
    public static void main(String[] args) {

        Thread t1 = new Runner1();
        Thread t2 = new Runner2();
        
        t1.start(); 
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("Finished with threads...........");
        
    }
}