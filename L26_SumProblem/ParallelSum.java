
public class ParallelSum {
    
    private ParallelWorker[] workers;
    private int numOfThreads;

    public ParallelSum(int numOfThreads){
        this.numOfThreads = numOfThreads;
        this.workers = new ParallelWorker[numOfThreads];
    }

    public int sum(int[] nums){
        int total =0;
        int size = (int) (Math.ceil(nums.length *1.0 / numOfThreads));

        for(int i=0;i<numOfThreads;++i){
            workers[i] = new ParallelWorker(i*size, (i+1)*size, nums);
            workers[i].start();
        }

        try {
            for(ParallelWorker worker:workers){
                worker.join();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(ParallelWorker worker : workers)
            total+=worker.getPartialSum();

        return total;
    }
}
