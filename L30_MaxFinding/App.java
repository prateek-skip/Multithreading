

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        // parallel is only fater for large test cases otherwise it is slower than
        // sequential approach due to parallel slowdown.
        int n = 500000000; 
        long[] nums = createArray(n);

        ForkJoinPool pool  = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SequentialMaxFinding sequential = new SequentialMaxFinding();

        long start = System.currentTimeMillis();
        System.out.println("Max: " + sequential.maxNum(nums));
        long end = System.currentTimeMillis();

        System.out.println("Sequential time : -- "+(end-start));

        ParallelMaxTask parallel = new ParallelMaxTask(nums, 0, n);
        start = System.currentTimeMillis();
        System.out.println("Max -- :  "+ pool.invoke(parallel));
        System.out.println("Parallel time : - "+(System.currentTimeMillis() - start));

    }

    private static long[] createArray(int n){
        Random random = new Random();

        long[] nums =new long[n];

        for(int i=0;i<n;i++){
            nums[i] = random.nextInt(n);
        }
        return nums;


    }
}
