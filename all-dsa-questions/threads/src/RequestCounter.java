public class RequestCounter {

  private int count = 0;

  synchronized public void inc() throws InterruptedException {
    Thread.sleep(1);
    this.count += 1;
  }

  public int getVal() {
    return this.count;
  }
}
