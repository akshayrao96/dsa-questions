import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumer implements Runnable {

  private final SharedBuffer sharedBuffer;

  public Consumer(SharedBuffer sharedBuffer) {
    this.sharedBuffer = sharedBuffer;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 3; i++) { // Each producer produces 5 items
      sharedBuffer.consume();
      try { Thread.sleep(500); } catch (InterruptedException ignored) {} // Simulate work
    }
  }
}
