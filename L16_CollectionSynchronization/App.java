
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        // add() and remove() are synchronized under the hood
        // Collecctions provide intrinsic lock -- not that efficient because
        // threads have to wait for each other even for independent methods (operation) 
        List<Integer> list =Collections.synchronizedList( new ArrayList<>());
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;++i){
                    list.add(i);
                }
            }
        });

        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;++i){
                    list.add(i);
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

        System.out.println(list.size());
    }
}
