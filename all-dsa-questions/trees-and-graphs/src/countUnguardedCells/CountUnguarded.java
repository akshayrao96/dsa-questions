package countUnguardedCells;

public class CountUnguarded {

  public static void main(String[] args) {
    int[][] g = new int[][]{{0,6},{2,2},{2,5},{1,2},{4,9},{2,9},{5,6},{4,6}};
    int[][] w = new int[][]{{1,5}};

    int res = countUnguarded(6, 10, g, w);

    System.out.println(res);

  }

  public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    int[][] grid = new int[m][n];
    for (int[] g : guards) {
      grid[g[0]][g[1]] = 1;
    }
    for (int[] w : walls) {
      grid[w[0]][w[1]] = 2;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          runDFS(i, j - 1, m, n, grid, '0');
          runDFS(i, j + 1, m, n, grid, '1');
          runDFS(i + 1, j, m, n, grid, '2');
          runDFS(i - 1, j, m, n, grid, '3');
        }
      }
    }

    int count = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          count++;
        }
      }
    }

    return count;

  }

  private static void runDFS(int i, int j, int m, int n, int[][] grid, char dir) {
    if (invalid(i, j, m, n, grid)) {
      return;
    }
    grid[i][j] = 3;
    if (dir == '0') {
      runDFS(i, j - 1, m, n, grid, dir);
    } else if (dir == '1') {
      runDFS(i, j + 1, m, n, grid, dir);
    } else if (dir == '2') {
      runDFS(i + 1, j, m, n, grid, dir);
    } else if (dir == '3') {
      runDFS(i - 1, j, m, n, grid, dir);
    }
  }

  private static boolean invalid(int i, int j, int m, int n, int[][] grid) {
    return i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1 || grid[i][j] == 2;
  }


}
