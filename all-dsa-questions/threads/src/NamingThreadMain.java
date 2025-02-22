public class NamingThreadMain {

  public static void main(String[] args) {
    NamingThread name0 = new NamingThread("First");
    NamingThread name1 = new NamingThread("Second");
    NamingThread name2 = new NamingThread("Third");

    Thread t0 = new Thread(name0);
    Thread t1 = new Thread(name1);
    Thread t2 = new Thread(name2);

    t0.start();
    t1.start();
    t2.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException ignored) {}

    System.out.println(Thread.currentThread());
  }
}
