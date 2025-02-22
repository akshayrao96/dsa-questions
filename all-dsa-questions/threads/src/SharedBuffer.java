import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class SharedBuffer {

  protected BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

  public synchronized void produce(int value) {
    int MAX_CAPACITY = 5;
    while (queue.size() == MAX_CAPACITY) {
      try {
        System.out.println(Thread.currentThread().getName() + " waiting to produce...");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    queue.offer(value);
    System.out.println(Thread.currentThread().getName() + " produced: " + value);
    System.out.println("Monitor held by producer: " + Thread.holdsLock(this));
    notify();
  }

  public synchronized void consume() {
    while (queue.isEmpty()) { // Guard clause: Buffer empty, wait for data
      try {
        System.out.println(Thread.currentThread().getName() + " waiting to consume...");
        wait(); // Release lock and wait
      } catch (InterruptedException e) { e.printStackTrace(); }
    }
    int value = queue.poll();
    System.out.println(Thread.currentThread().getName() + " consumed: " + value);
    System.out.println("Monitor held by consumer: " + Thread.holdsLock(this));
    notify();
  }
}


