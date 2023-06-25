

import java.util.concurrent.RecursiveTask;

// A parallel algo to find the nth fibonacci number

public class Fib extends RecursiveTask<Integer>{
    private int num;

    public Fib(int num){
        this.num = num;
    }

    @Override
    protected Integer compute() {
        if(num==0 || num == 1){
            return num;
        } else {
            Fib t1 = new Fib(num-1);
            Fib t2 = new Fib(num-2);

            t1.fork();
            t2.fork();

            int sum =0;
            sum+=t1.join();
            sum+=t2.join();
            return sum;
        }
    }
    
}
