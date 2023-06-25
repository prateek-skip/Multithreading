import java.util.Arrays;

public class IntegerStreams {
    public static void main(String[] args) {
        int [] nums = {1,4,6,7,-4,-7,10,9,8};

          
        // Arrays.stream(nums).forEach(x-> System.out.print(x+" "));
        Arrays.stream(nums).filter(x->x%2==0).forEach(x-> System.out.print(x+" "));

            // int sum = Arrays.stream(nums).sum();
        // System.out.println(sum);
    }    
}
