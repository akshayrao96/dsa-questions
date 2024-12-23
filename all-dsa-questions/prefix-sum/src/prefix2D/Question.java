package prefix2D;

public class Question {

  public static void main(String[] args) {
    NumMatrix n = new NumMatrix(new int[][]{{3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});

    

    //[2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
    System.out.println(n.sumRegion(0, 3, 0, 4));
    System.out.println(n.sumRegion(2, 1, 4, 3));
    System.out.println(n.sumRegion(1, 1, 2, 2));
    System.out.println(n.sumRegion(1, 2, 2, 4));

  }

  public static class NumMatrix {

    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
      int n = matrix.length;
      int m = matrix[0].length;

      prefix = new int[n + 1][m + 1];

      for (int i = 1; i < n + 1; i++) {
        for (int j = 1; j < m + 1; j++) {
          prefix[i][j] =
              matrix[i - 1][j - 1] + (prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1]);
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      return (prefix[row2 + 1][col2 + 1]) - prefix[row1][col2 + 1] - prefix[row2 + 1][col1]
          + prefix[row1][col1];
    }
  }

}

/*
For vertex {i, j}, find sum of rectangle where {i, j} is the bottom right of the rectangle
Once I solve the prefix sum and cache the answers, I do the following:

When given the row and columns of the rectangle, the sum will be:

dp{i2, j2} - (dp{i1 - 1, j2} - dp{i2, j1 - 1} + dp{i1 - 1, j1 - 1}}

dp as i build the 2d array:

dp{i, j} = dp{i, j - 1) + dp{i - 1, j} - dp {i - 1, j - 1}





 */