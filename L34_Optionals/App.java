
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
		books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
		books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
		books.add(new Book("Death on The Nile", "Agatha Christie", 370, Type.THRILLER));
		books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
		books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
		books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
		books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

        // get the count of elements in the stream
        System.out.println(books.stream().count());

        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        // max number in the array or minimum
        Optional<Integer> result = nums.stream().reduce(Integer::max);

        result.ifPresent(System.out::println);

        // max number of pages
        books.stream().map(Book::getPages).reduce(Integer::max).ifPresent(System.out::println);

        // we want to get the longest book
        Optional<Book> longestBook = books.stream().reduce((b1,b2) -> 
            b1.getPages() > b2.getPages() ? b1 :b2
        );

        longestBook.ifPresent(System.out::println);

        // sum of all the pages
        IntStream s = books.stream().mapToInt(Book::getPages);
        s.boxed();

        System.out.println(totalPages);
        

        //converting back to Stream of integers;


    }
}
