

public class SequentialMaxFinding {


    public long maxNum(long[] arr){
        long max = arr[0];
        long l  = arr.length;
        for(int i=0;i<l;++i){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
