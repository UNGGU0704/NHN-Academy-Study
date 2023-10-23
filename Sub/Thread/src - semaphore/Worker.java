
public class Worker implements Runnable {

    Thread thread;
    String name;
    int number;

    Worker (int n ) {
        this.number = n;
    //    thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            System.out.println(number);
            Thread.sleep(1999);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupted();
        }
    }
}