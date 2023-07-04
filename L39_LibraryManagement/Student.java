import java.util.Random;

public class Student implements Runnable{
    private int id;
    private Book[] books;
    private Random random;


    public Student(int id, Book[] books){
        this.id = id;
        this.books = books;
        this.random =new Random();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Student: "+this.id+" ";
    }

    @Override
    public void run() {
        while(true){

            int bookId = random.nextInt(Constants.NUM_0F_BOOKS);
            try {
                books[bookId].read(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
        }
    }
}
