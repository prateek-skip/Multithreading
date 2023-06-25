
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortTask extends RecursiveAction{
    private int[] nums;

    public MergeSortTask(int[] arr) {
        this.nums = arr;
    }



    @Override
    protected void compute() {
        if(nums.length<=10){
            mergeSort(nums);
            return;
        }
            
        
        int middleIndex = nums.length/2;
        int[] left = Arrays.copyOfRange(nums, 0, middleIndex);
        int right[] = Arrays.copyOfRange(nums, middleIndex, nums.length);

        MergeSortTask t1 = new MergeSortTask(left);
        MergeSortTask t2 = new MergeSortTask(right);

        invokeAll(t1,t2);

        merge(left,right,nums);
    }


    
    public void mergeSort(int[] nums){
        if(nums.length <=1){
            return ;
        }

        int middleIndex = nums.length/2;
        int[] left = Arrays.copyOfRange(nums, 0, middleIndex);
        int right[] = Arrays.copyOfRange(nums, middleIndex, nums.length);

        mergeSort(left);
        mergeSort(right);
        merge(left,right , nums);
    }

    public void merge(int[] left, int[] right, int[] original){
        int i=0;
        int j=0;
        int k=0;

        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                original[k++] = left[i++];
            } else {
                original[k++] = right[j++];
            }
        }

        while(i<left.length)
            original[k++] = left[i++];
        
        while(j<right.length)
            original[k++] = right[j++];
        
    }


    
}
