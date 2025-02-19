package largestValidSubsequence;

import java.util.Arrays;

public class Question {

  public static void main(String[] args) {
    int[] res = constructDistancedSequence(3);
    int[] res2 = constructDistancedSequence(5);

    System.out.println(Arrays.toString(res));
    System.out.println(Arrays.toString(res2));
  }

  public static int[] constructDistancedSequence(int n) {
    int[] result = new int[n * 2 - 1];
    boolean[] used = new boolean[n + 1];
    backtrack(n, result, used, 0);
    return result;
  }

  private static boolean backtrack(int n, int[] result, boolean[] used, int idx) {
    if (idx == result.length) {
      return true;
    }

    if (result[idx] != 0) {
      return backtrack(n, result, used, idx + 1);
    }

    for (int i = n; i >= 1; i--) {
      if (used[i]) {
        continue;
      }

      if (i == 1) {
        used[i] = true;
        result[idx] = i;
        if (backtrack(n, result, used, idx + 1)) {
          return true;
        }
        used[i] = false;
        result[idx] = 0;
      } else {
        int nextIdx = i + idx;
        if (nextIdx < result.length && result[nextIdx] == 0) {
          used[i] = true;
          result[idx] = i;
          result[nextIdx] = i;
          if (backtrack(n, result, used, idx + 1)) {
            return true;
          }
          used[i] = false;
          result[idx] = 0;
          result[nextIdx] = 0;
        }
      }
    }
    return false;
  }
}
