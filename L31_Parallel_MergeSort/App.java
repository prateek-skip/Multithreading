import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        int n = 100000000;
        int[] arr = createArray(n);

        int[] arr2 = new int[n];
        for(int i=0;i<n;i++){
            arr2[i] = arr[i];
        }

        SequentialMergeSort sequential = new SequentialMergeSort(arr);
        long start = System.currentTimeMillis();
        sequential.mergeSort(arr);
        System.out.println("Sequential running time -- : "+ (System.currentTimeMillis() - start));

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        MergeSortTask parallel = new MergeSortTask(arr2);
        start = System.currentTimeMillis();
        pool.invoke(parallel);
        System.out.println("Parallel running time: -- "+(System.currentTimeMillis() - start));

    }   
    
    private static int[] createArray(int n){
        Random random = new Random();

        int[] nums =new int[n];

        for(int i=0;i<n;i++){
            nums[i] = random.nextInt(n);
        }
        return nums;


    }
}
