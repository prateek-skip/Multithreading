import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        SimpleRecursiveTask task = new SimpleRecursiveTask(200000);
        
        Fib fib = new Fib(3);
        System.out.println(pool.invoke(fib));
    }
}
