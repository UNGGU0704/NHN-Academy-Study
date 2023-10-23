import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    Store store;
    Thread thread;
    String str;
    int index = 0;

    public Producer(Store store) {
        this.thread = new Thread(this);
        this.store = store;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                index++;
                str = index + "번 째 물건";
                store.sell(new Thing(str));
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,10000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}