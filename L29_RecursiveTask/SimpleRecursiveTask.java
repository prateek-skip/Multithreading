
import java.util.concurrent.RecursiveTask;
// a parallel program to double the given number
public class SimpleRecursiveTask extends RecursiveTask<Double>{
    private double num;

    public SimpleRecursiveTask(double num){
        this.num = num;
    }

    @Override
    protected Double compute() {
        if(num > 100){
            double total =0;
            SimpleRecursiveTask action1 = new SimpleRecursiveTask(num/2);
            SimpleRecursiveTask action2 = new SimpleRecursiveTask(num/2);
            action1.fork();
            action2.fork();

            total+=action1.join();
            total+=action2.join();

            return total;
        } else {
            return 2*num;
        }
    }

}
