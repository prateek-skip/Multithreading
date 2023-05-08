class Runner1 implements Runnable {


    @Override
    public void run(){
        for(int i=0;i<10;++i){
            System.out.println("Runner1:- "+i);
        }
    }

    public void execute() {
        for(int i=0;i<10;++i){
            System.out.println("Runner1:- "+i);
        }
    }
}

class Runner2 implements Runnable{

    @Override
    public void run(){
        for(int i=0;i<10;++i){
            System.out.println("Runner2:- "+i);
        }
    }

    public void execute() {
        for(int i=0;i<10;++i){
            System.out.println("Runner2:- "+i);
        }
    }
}

public class Threads {
    public static void main(String[] args) {

        //It is not parallel execution , it is time slicing
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;++i){
                    System.out.println("Runner1: "+ i);
                }
            }
        });
        Thread t2 = new Thread(new Runner2());

        t1.start();
        t2.start();
    }
}