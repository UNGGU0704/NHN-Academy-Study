import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Store {
    private final int maxThings = 5;
    private final int maxCustomers = 10;
    private final int maxBuy = 1;
    private final int maxSupply = 1;

    int thingscount = 0;
    int customercount = 0;
    Queue<Thing> queue;

    public Store() {
        queue = new LinkedList<Thing>();

        Producer producer = new Producer(this);
        Consumer consumer = new Consumer(this);

        System.out.println("thread 시작! ");
        producer.start();
        consumer.start();
    }

    /**
     * 손님이 들어옵니다.
     */
    public void enter() {
        if (customercount >= maxCustomers) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("손님 한명 입장! ");
        customercount++;
        notifyAll();
    }

    /**
     * 손님이 나갑니다.
     */
    public void exit() {
		customercount--;
        notifyAll();
    }

    /**
     * 손님이 구매합니다.
     */
    public synchronized void buy() {
		System.out.println(queue.poll().toString() + "이 팔립니다! ");
        exit();
    }

    /**
     * 생산자가 납품합니다.
     */
    public synchronized void sell(Thing thing) {
		if (queue.size() >= maxThings) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println(thing.toString() + " 납품됨 ");
        queue.add(thing);
        notifyAll();
    }
}