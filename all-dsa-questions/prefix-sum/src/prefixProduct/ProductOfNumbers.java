package prefixProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

  private final List<Integer> nums;
  private final List<Integer> prefixProduct;
  private int zeroTracker;
  private int currProduct;
  private int size;

  public ProductOfNumbers() {
    this.nums = new ArrayList<>();
    this.prefixProduct = new ArrayList<>();
    this.zeroTracker = -1;
    this.currProduct = 1;
    this.size = 0;
  }

  public void add(int num) {
    this.nums.add(num);
    this.currProduct *= num;
    this.prefixProduct.add(this.currProduct);
    if (num == 0) {
      this.currProduct = 1;
      this.zeroTracker = this.size;
    }
    this.size += 1;
  }

  public void getProduct(int k) {

    // handle 0 product
    if (this.size - k <= this.zeroTracker)
      return;

    int totalProduct = this.prefixProduct.get(this.size - 1);

    if (this.size - k <= 0)
      return;
    int initProduct = this.prefixProduct.get(this.size - k - 1);

    // case handles new product from a 0 tracking value
    if (initProduct == 0)
      return;

    // case with no zeros
    int result = totalProduct / initProduct;
  }
}
