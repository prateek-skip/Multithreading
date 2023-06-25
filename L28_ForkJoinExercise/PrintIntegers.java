
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class PrintIntegers extends RecursiveAction{
    
    // int[] arr;
    // int low;
    // int high;
    // int count;
    // public PrintIntegers(int[] arr, int low, int high){
    //     this.arr = arr;
    //     this.low = low;
    //     this.high = high;
    // }

    // @Override
    // protected void compute() {
    //     if(high - low >2){
    //         // System.out.println("We will sub divide the tasks...");
    //         int mid = (high + low)/2;
    //         PrintIntegers action1 = new PrintIntegers(arr, low, mid);
    //         PrintIntegers action2 = new PrintIntegers(arr, mid+1, high);

    //         invokeAll(action1, action2);
    //     } else {
            
    //         for(int i=low;i<=high;++i){
    //             System.out.print(arr[i]+" ");
    //         }
    //     }
    // }

    private List<Integer> nums;
	
	public PrintIntegers(List<Integer> nums) {
		this.nums = nums;
	}

    
        @Override
    protected void compute() {
		// the problem is small enough (containing 2 items) so we use
		// standard sequential print operation
		if(nums.size() < 2) {
			for(Integer num : nums)
				System.out.print(num+" ");
		} else {
			// otherwise we split the problem into 2 sub-problems
			// [a,b,c] --> [a] and [b,c]
			// [a,b,c,d] --> [a,b] and [c,d]
			List<Integer> left = nums.subList(0, nums.size()/2);
			List<Integer> right = nums.subList(nums.size()/2,  nums.size());
		
			PrintIntegers action1 = new PrintIntegers(left);
			PrintIntegers action2 = new PrintIntegers(right);
			
			// it means these actions are thrown into the pool
			// fork-join assigns different threads to different tasks
			// so these will be executed with different treads
			invokeAll(action1, action2);
		}
	}
}
