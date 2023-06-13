import java.util.Random;

public class Philosphers implements Runnable {
    private int id;
    private volatile boolean full;
    private Chopsticks leftChopstick;
    private Chopsticks rightChopstick;
    private Random random;
    private int eatingCounter;

    public Philosphers(int id, Chopsticks lefChopstick, Chopsticks rightChopstick){
        this.id = id;
        this.leftChopstick = lefChopstick;
        this.rightChopstick = rightChopstick;
        this.random = new Random();
    }

    @Override
    public void run() {
        
        try {
            while(!full){
                think();

                if(leftChopstick.pickUp(this, State.LEFT)){
                    // philosopher is able to acquire the left chopstick

                    if(rightChopstick.pickUp(this, State.RIGHT)){
                        eat();
                        rightChopstick.putDown(this, State.RIGHT);
                    }

                    leftChopstick.putDown(this, State.LEFT);
                }
            }
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }
    }

    private void think() throws InterruptedException{
        System.out.println(this + " is thinking...");
        // the philosopher thinks for a random time [0,1000]
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException{
        System.out.println(this+" is eating....");
        this.eatingCounter++;
        Thread.sleep(random.nextInt(1000));
    }



    public void setFull(boolean full){
        this.full = full;
    }

    public boolean isFull(){
        return this.full;
    }

    public int getEatingCounter(){
        return this.eatingCounter;
    }

    @Override
    public String toString() {
        return "Philosopher "+id;
    }

}
