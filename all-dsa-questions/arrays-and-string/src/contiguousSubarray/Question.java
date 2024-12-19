package contiguousSubarray;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Question {

  public static void main(String[] args) {
    System.out.println(continuousSubarrays(new int[]{5, 4, 2, 4}));
    System.out.println(continuousSubarrays(new int[]{1, 2, 3}));
    System.out.println(continuousSubarrays(new int[]{65, 66, 67, 66, 66, 65, 64, 65, 65, 64}));
    System.out.println(continuousSubarrays(new int[]{5, 4, 2, 4}));
  }

  public static long continuousSubarrays(int[] nums) {
    int n = nums.length;

    Deque<Integer> max = new ArrayDeque<>();
    Deque<Integer> min = new ArrayDeque<>();

    int left = 0;
    long res = 0;

    for (int i = 0; i < n; i++) {
      while (!max.isEmpty() && (left > max.peekFirst()
          || Math.abs(nums[i] - nums[max.peekFirst()]) > 2)) {
        if (left > max.peek()) {
          max.pollFirst();
        } else if (Math.abs(nums[i] - nums[max.peekFirst()]) > 2) {
          left++;
        }
      }

      while (!min.isEmpty() && (left > min.peekFirst()
          || Math.abs(nums[i] - nums[min.peekFirst()]) > 2)) {
        if (left > min.peekFirst()) {
          min.pollFirst();
        } else if (Math.abs(nums[i] - nums[min.peekFirst()]) > 2) {
          left++;
        }
      }

      res += (i - left + 1);

      while (!min.isEmpty() && nums[i] < nums[min.peekLast()]) {
        min.pollLast();
      }
      min.offerLast(i);

      while (!max.isEmpty() && nums[i] > nums[max.peekLast()]) {
        max.pollLast();
      }
      max.offerLast(i);
    }

    return res;

  }
}