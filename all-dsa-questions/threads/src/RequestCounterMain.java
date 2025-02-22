public class RequestCounterMain {

  final static private int NUM_THREADS = 50000;

  public static void main(String[] args) throws InterruptedException {
    RequestCounter rc = new RequestCounter();
    for (int i = 0; i < NUM_THREADS; i++) {
      Runnable thread = () -> {
        try {
          rc.inc();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      };
      new Thread(thread).start();
      Thread.sleep(1);
    }
    Thread.sleep(5000);
    System.out.println(rc.getVal());
  }
}
