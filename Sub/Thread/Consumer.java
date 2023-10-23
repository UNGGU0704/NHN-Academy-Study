import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    Store store;
    int customercount = 0;
    Thread thread;

    public Consumer(Store store) {
        this.store = store;
        this.thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
		while (!Thread.interrupted()) {
            if (customercount++ < 5) {
                store.enter();
            } else {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
                    store.buy();
                    customercount--;
               } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();     
               }
            }

        }
    }
}