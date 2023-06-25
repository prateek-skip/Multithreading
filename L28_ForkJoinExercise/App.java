import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Random random = new Random();
        int n = 100;
        // int[] arr = new int[n];
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;++i){
            arr.add(random.nextInt(n));
        }        
        PrintIntegers printIntegers = new PrintIntegers(arr);
        pool.invoke(printIntegers);

    }
}
