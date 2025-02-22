import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

  private final SharedBuffer sharedBuffer;

  public Producer(SharedBuffer sharedBuffer) {
    this.sharedBuffer = sharedBuffer;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 5; i++) { // Each producer produces 5 items
      sharedBuffer.produce(i);
      try { Thread.sleep(200); } catch (InterruptedException ignored) {} // Simulate work
    }
  }
}

