import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;


public class Store {
    private final int maxThings = 5;
    private final int maxCustomers = 10;
    
    int thingscount = 0;
    int customercount = 0;
    Queue<Thing> queue;
    Semaphore customerSemaphore;
    Semaphore thingSemaphore;

    public Store() {
        queue = new LinkedList<Thing>();

        customerSemaphore = new Semaphore(maxCustomers);
        thingSemaphore = new Semaphore(maxThings);

        Producer producer = new Producer(this);
        Consumer consumer = new Consumer(this);

        System.out.println("thread 시작! ");
        producer.start();
        consumer.start();
    }

    /**
     * 손님이 들어옵니다.
     * @throws InterruptedException
     */
    public void enter() throws InterruptedException {
        customerSemaphore.acquire();
        synchronized (this) {
            if (customercount >= maxCustomers) {
                wait();
            }
            System.out.println("손님 한명 입장! ");
            customercount++;
            notifyAll();
         }
    }

    /**
     * 손님이 나갑니다.
     */
    public synchronized void exit() {
        customerSemaphore.release();
        synchronized (this) {
            customercount--;
            System.out.println("손님이 나갑니다.");
            notifyAll();
        }
    }

    /**
     * 손님이 구매합니다.
     * @throws InterruptedException
     */
    public void buy() throws InterruptedException {
        
        synchronized (this) {
            thingSemaphore.acquire();
            if (queue.isEmpty()) {
                wait();
            }
            System.out.println(queue.poll().toString() + "이 팔립니다! ");
            notifyAll();
            exit();
        }
    }

    /**
     * 생산자가 납품합니다.
     * @throws InterruptedException
     */
    public synchronized void sell(Thing thing) throws InterruptedException {
        synchronized (this) {
            if (queue.size() >= maxThings) {
                wait();
            }
            System.out.println(thing.toString() + " 납품됨 ");
            queue.add(thing);
            notifyAll();
        }
    }
}