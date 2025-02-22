import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExecutor {

  public static void main(String[] args) {

    SharedBuffer buffer = new SharedBuffer();
    ExecutorService executor = Executors.newFixedThreadPool(8);

    // Create 3 producers
    for (int i = 0; i < 3; i++) {
      executor.execute(new Producer(buffer));
    }

    // Create 5 consumers
    for (int i = 0; i < 5; i++) {
      executor.execute(new Consumer(buffer));
    }

    executor.shutdown(); // Gracefully shut down executor
  }
}
