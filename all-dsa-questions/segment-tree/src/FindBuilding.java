import java.util.Arrays;

public class FindBuilding {

  public static void main(String[] args) {
    int[] h = new int[]{6, 4, 8, 5, 2, 7};
    int[][] queries = new int[][]{{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};

    int[] h2 = new int[]{302436007,903697980,796132976,856813675,195725903,244714044,86478750,901043629,549082834,835103919};
    int[][] queries2 = new int[][]{{3,1},{1,4},{0,1},{6,2},{5,0},{7,4},{5,4},{2,0},{4,5},{8,0}};

    System.out.println(Arrays.toString(leftmostBuildingQueries(h, queries)));
    System.out.println(Arrays.toString(leftmostBuildingQueries(h2, queries2)));
  }

  public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
    int n = heights.length;
    int m = queries.length;

    RangeMax r = new RangeMax(heights);

    int[] res = new int[m];

    for (int i = 0; i < m; i++) {
      int[] q = queries[i];
      int alice = Math.min(q[0], q[1]);
      int bob = Math.max(q[0], q[1]);

      int val1 = heights[alice];
      int val2 = heights[bob];

      if (alice == bob || val2 > val1) {
        res[i] = bob;
        continue;
      }

      res[i] = nextGreater(heights, Math.max(val1, val2), bob + 1, n - 1, r);

    }
    return res;
  }

  private static int nextGreater(int[] heights, int val, int left, int right, RangeMax r) {
    int max = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int[] maxResults = r.getMax(left, mid);

      if (maxResults[0] > val) {
        max = maxResults[1];
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return max;

  }

  public static class RangeMax {

    private int[][] arr;
    private int size;

    public RangeMax(int[] heights) {
      this.arr = new int[heights.length * 2][2];
      int n = this.arr.length;

      this.size = heights.length;

      for (int i = this.size; i < n; i++) {
        this.arr[i][0] = heights[i - size];
        this.arr[i][1] = i - size;
      }

      for (int i = this.size - 1; i >= 0; i--) {
        if (this.arr[i * 2][0] >= this.arr[i * 2 + 1][0]) {
          this.arr[i][0] = this.arr[i * 2][0];
          this.arr[i][1] = this.arr[i * 2][1];
        } else {
          this.arr[i][0] = this.arr[i * 2 + 1][0];
          this.arr[i][1] = this.arr[i * 2 + 1][1];
        }
      }
    }

    public int[] getMax(int left, int right) {
      left += this.size;
      right += this.size;

      int[] res = new int[]{0, -1};

      while (left <= right) {
        if (left % 2 == 1) {
          checkRange(left, res);
          left++;
        }

        if (right % 2 == 0) {
          checkRange(right, res);
          right--;
        }

        left /= 2;
        right /= 2;
      }
      return res;
    }

    private void checkRange(int left, int[] res) {
      if (this.arr[left][0] > res[0] || (this.arr[left][0] == res[0] && this.arr[left][1] < res[1])) {
        res[0] = this.arr[left][0];
        res[1] = this.arr[left][1];
      }
    }
  }
}
