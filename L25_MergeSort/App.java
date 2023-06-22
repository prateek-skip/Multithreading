import java.util.Random;

public class App {
    public static void main(String[] args) {
        int n = 100000000;
        int arr1[] = new int[n];
        Random random = new Random();
        for(int i=0;i<n;i++){
            arr1[i] = random.nextInt(n);
        }

        int[] arr2 = new int[n];
        for(int i=0;i<n;i++)
            arr2[i] = arr1[i];
        long startTime = System.currentTimeMillis();
        ParallelMergeSort parallelSort = new ParallelMergeSort(arr1,Runtime.getRuntime().availableProcessors());
        parallelSort.sort();
        // parallelSort.showArray();
        long endTime = System.currentTimeMillis();
        System.out.println("The parallel execution time --- "+(endTime - startTime)+" ms");

        long startTime1 = System.currentTimeMillis();
        MergeSort sort = new MergeSort(arr2);
        sort.sort();
        long endTime1 = System.currentTimeMillis();
        System.out.println("The sequential execution time ---- "+ (endTime1 - startTime1)+ " ms");

        // System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
