import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = null;
        Philosphers[] philosphers = null;
        Chopsticks[] chopsticks = null;
        try {
            philosphers = new Philosphers[Constants.NUMBER_OF_PHILOSOPHERS];
            chopsticks = new Chopsticks[Constants.NUMBER_OF_CHOPSTICKS];

            for(int i=0;i<Constants.NUMBER_OF_CHOPSTICKS;i++){
                chopsticks[i] = new Chopsticks(i);
            }

            executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);

            for(int i=0;i<Constants.NUMBER_OF_PHILOSOPHERS;++i){
                 philosphers[i] = new Philosphers(i, chopsticks[i], chopsticks[(i+1)%Constants.NUMBER_OF_CHOPSTICKS]);
                 executorService.execute(philosphers[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            executorService.shutdown();

            for(Philosphers philospher : philosphers){
                philospher.setFull(true);
            }
        } finally {
            executorService.shutdown();

            while(!executorService.isTerminated()){
                Thread.sleep(1000);
            }

            for(Philosphers philospher : philosphers){
                System.out.println(philospher+" eat #"+philospher.getEatingCounter()+" times!!!");
            }
        }
    }    
}
