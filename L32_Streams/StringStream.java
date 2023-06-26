import java.util.Comparator;
import java.util.stream.Stream;

public class StringStream {
    public static void main(String[] args) {
        String[] names = {"Adam", "Marths", "Kevin","Ben","Joe","Susan"};

        Stream.of(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }    
}
