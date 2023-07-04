
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
 * Your task is that given two lists of numbers ([1, 2, 3], [4, 5]). 
 * Generate all pairs of possible numbers!

So the result in the case should be: (1,4), (1,5), (2,4),(2,5),(3,4),(3,5)
 */


public class App {
    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(4, 5);
                
        List<List<Integer>> pairs = nums1.stream().
        flatMap(i->nums2.stream().map(j->Arrays.asList(i,j))).collect(Collectors.toList());
                
        System.out.println(pairs);
        
    }
}
