
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessing {
    public static void main(String[] args) throws IOException {
        String path = "C:/Users/chand/Desktop/Code/MultiThreading/testFile.txt";
        Stream<String> namesStream = Files.lines(Paths.get(path));

        List<String> names = namesStream.collect(Collectors.toList());

        System.out.println(names);

    }
}
