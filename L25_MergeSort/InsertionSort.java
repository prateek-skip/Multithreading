
public class InsertionSort {
    
    public int[] sort(int[] arr){
        int l = arr.length;
        for(int i=1;i<l;i++){
            int temp = arr[i];
            int sortedIdx = i-1;
            while(sortedIdx>=0 && temp < arr[sortedIdx]){
                    arr[sortedIdx+1] = arr[sortedIdx];
                
                sortedIdx--;
            }
            arr[sortedIdx+1] = temp;
        }

        return arr;
    }
}
