package maze1;

import java.util.LinkedList;
import java.util.Queue;

public class Question {

  public static void main(String[] args) {
    int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1},
        {0, 0, 0, 0, 0}};
    System.out.println(hasPath(maze, new int[]{0, 4}, new int[]{4, 4}));
  }

  public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int n = maze.length;
    int m = maze[0].length;
    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    Queue<int[]> q = new LinkedList<>();
    maze[start[0]][start[1]] = -1;
    q.offer(new int[]{start[0], start[1]});

    while (!q.isEmpty()) {
      int[] curr = q.poll();
      int i = curr[0];
      int j = curr[1];

      if (maze[i][j] == -1) {
        continue;
      }

      maze[start[0]][start[1]] = -1;

      if (i == destination[0] && j == destination[1]) {
        return true;
      }

      for (int[] d : dir) {
        int[] arr = getIndex(maze, i, j, d, n, m);
        if (arr[0] != -1 && arr[1] != -1) {
          q.offer(arr);
        }
      }
    }

    return false;
  }

  private static int[] getIndex(int[][] maze, int i, int j, int[] d, int n, int m) {
    int x = i;
    int y = j;

    while (x + d[0] < n && x + d[0] >= 0 && y + d[1] < m && y + d[1] >= 0
        && (maze[x + d[0]][y + d[1]] != 1)) {
      x += d[0];
      y += d[1];
    }

    return maze[x][y] == -1 ? new int[]{-1, -1} : new int[]{x, y};
  }
}
