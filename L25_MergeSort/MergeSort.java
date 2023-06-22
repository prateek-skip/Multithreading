import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    private int[] nums;

    // as mergesort is not in place algo
    private int[] temp;

    public MergeSort(int[] nums){
        this.nums = nums;
        this.temp = new int[nums.length];
    }

    public void sort(){
        mergeSort(0,this.nums.length-1);
    }

    private void mergeSort(int low, int high){
        if(low<high){
            int mid = (high - low)/2 + low;
            mergeSort(low, mid);
            mergeSort(mid+1, high);
            merge(low,high,mid);
        }
    }



    private void merge(int low, int high, int mid) {
        for(int i=low;i<=high;++i){
            temp[i] = nums[i];
        }

        int i=low;
        int j=mid+1;
        int k = low;

        while(i<=mid && j<=high){
            if(temp[i] < temp[j]){
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
            ++k;
        }

        if(i<=mid){
            nums[k++]  =temp[i++];
        }

        if(j<=high){
            nums[k++] = temp[j++];
        }
    }

    public void showArray(){
        for(int i=0;i<this.nums.length;++i){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public void swap(int i, int j){
        int t = this.nums[i];
        this.nums[i] = this.nums[j];
        this.nums[j] = t;
    }


    // public static void main(String[] args) {
    //     List<Integer> arr = new ArrayList<>();
    //     int[] arr2 = {2,12,31,5,3,53,8};
    //     Double d = 7.88;
    //     System.out.println(arr.getClass().getName() );
    //     System.out.println(arr2.getClass());
    //     System.out.println("".getClass().getName());
    //     System.out.println(d.getClass().getSimpleName());
    //     System.out.println("".getClass().getName());

    //     InsertionSort s = new InsertionSort();
    //     System.out.print("unsorted--- ");
    //     for(int i=0;i<arr2.length;i++){
    //         System.out.print( arr2[i]+" ");
    //     }
    //     System.out.println();
        
    //     arr2 = s.sort(arr2);
    //     for(int i=0;i<arr2.length;i++){
    //         System.out.print(arr2[i]+" ");
    //     }
        
    // }


}
