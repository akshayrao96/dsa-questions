public class NamingThread implements Runnable {

  private String name;

  public NamingThread(String threadName) {
    this.name = threadName;
    System.out.println("Constructor called: " + threadName);
  }

  @Override
  public void run() {
    System.out.println("Run called " + this.name);
    System.out.println(name + " : " + Thread.currentThread());
  }
}
