package prefix1D;

public class Question {

  public static void main(String[] args) {
    NumArray n = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    System.out.println(n.sumRange(2, 4)); // 0
    System.out.println(n.sumRange(0, 3)); // -4
    System.out.println(n.sumRange(2, 2)); // 3
    System.out.println(n.sumRange(1, 3)); // -2
  }

  public static class NumArray {

    private final int[] prefix;

    public NumArray(int[] nums) {
      prefix = new int[nums.length];
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        prefix[i] = sum;
      }
    }

    public int sumRange(int left, int right) {
      int last = prefix[right];
      int prev = left - 1 == -1 ? 0 : prefix[left - 1];

      return last - prev;

    }
  }
}
