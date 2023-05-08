
public class App {
    
    public static int counter1 = 0;
    public static int counter2 =0;

    // we have to make sure that this method is called only by a single thread at a given time

    //usually it is not a good practice to use synchronized keyword
    
    // public static synchronized void increment(){
    //     counter++;
    // }

    public static void increment1(){
            synchronized(App.class){
                counter1++;
            }
    }

    public static void increment2(){
        //class level locking

        //rule of thumb : we synchronize blocks that are 100% necessary
        synchronized(App.class){
            counter2++;
        }
}

    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<2000;++i){
                    increment1();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<2000;++i){
                    increment2();
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }

        System.out.println(counter1);
        System.out.println(counter2);
    }
    public static void main(String[] args) {
        process();
    }    
}
