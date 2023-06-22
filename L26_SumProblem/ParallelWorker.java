
public class ParallelWorker extends Thread{
    private int[] nums;
    private int low;
    private int high;
    private int partialSum;

    public ParallelWorker(int low, int high, int[] nums){
        this.low = low;
        this.nums = nums;
        this.high = Math.min(nums.length, high);
    }
    

    @Override
    public void run() {
        partialSum =0;
        for(int i=low;i<high;++i)
            partialSum+=nums[i];    
    }

    public int getPartialSum(){
        return this.partialSum;
    }
}
