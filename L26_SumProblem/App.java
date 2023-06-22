import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 100000000;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = random.nextInt(100);
        }
        
        long start1 = System.currentTimeMillis();
        ParallelSum parallelSum = new ParallelSum(Runtime.getRuntime().availableProcessors());
        System.out.println(parallelSum.sum(arr));
        long end1 = System.currentTimeMillis();
        System.out.println("Parallel execution time --- "+(end1-start1));

        long start2 = System.currentTimeMillis();
        SequentialSum sequentialSum = new SequentialSum();
        
        System.out.println(sequentialSum.sum(arr));
        long end2 = System.currentTimeMillis();
        System.out.println("Sequential execution time --- "+ (end2-start2));

    }
}
