
import java.util.concurrent.RecursiveTask;

public class ParallelMaxTask extends RecursiveTask<Long>{
    
    private long[] arr;
    private int lowIndex;
    private int highIndex;
    
    public ParallelMaxTask(long[] arr, int li, int hi){
        this.arr = arr;
        this.lowIndex = li;
        this.highIndex = hi;
    }


    @Override
    protected Long compute() {
        if(highIndex - lowIndex <1000){
            return sequentialMaxFinding();
        } else {
            int middleIndex = (highIndex+lowIndex)/2;

            ParallelMaxTask t1 = new ParallelMaxTask(arr, lowIndex, middleIndex);
            ParallelMaxTask t2 = new ParallelMaxTask(arr, middleIndex+1, highIndex);

            invokeAll(t1,t2);

            return Math.max(t1.join(), t2.join());
        }
    }

    private long sequentialMaxFinding(){
        long max =arr[this.lowIndex];

        for(int i=this.lowIndex;i<this.highIndex;++i){
            if(arr[i]> max){
                max = arr[i];
            }
        }
        return max;
    }
}
