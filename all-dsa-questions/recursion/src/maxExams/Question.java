package maxExams;

public class Question {

  public static void main(String[] args) {
    char[][] seats = new char[][]{{'#', '.', '#', '#', '.', '#'},
        {'.', '#', '#', '#', '#', '.'},
        {'#', '.', '#', '#', '.', '#'}};

    char[][] seats2 = new char[][]{{'.','#'},
        {'#','#'},
        {'#','.'},
        {'#','#'},
        {'.','#'}};

    System.out.println(maxStudents(seats));
    System.out.println(maxStudents(seats2));

  }

  public static int maxStudents(char[][] seats) {
    int n = seats.length;
    int m = seats[0].length;

    int[] res = new int[]{-1};

    maxStudents(seats, n, m, 0, 0, 0, res);

    return res[0];

  }

  private static void maxStudents(char[][] seats, int n, int m, int i, int j, int count,
      int[] res) {
    if (i >= n) {
      return;
    }

    int b = j + 1;
    int a = i;
    if (b >= m) {
      b = 0;
      a += 1;
    }

    if (seats[i][j] == '#' || !valid(seats, n, m, i, j)) {
      maxStudents(seats, n, m, a, b, count, res);
    } else {
      seats[i][j] = 'x';
      maxStudents(seats, n, m, a, b, count + 1, res);
      seats[i][j] = '.';
    }
    res[0] = Math.max(res[0], count);
  }

  private static boolean valid(char[][] seats, int n, int m, int i, int j) {
    return (j - 1 < 0 || seats[i][j - 1] != 'x') && (j + 1 >= m || seats[i][j + 1] != 'x') && (
        i - 1 < 0 || j - 1 < 0 || seats[i - 1][j - 1] != 'x') && (i - 1 < 0 || j + 1 >= m
        || seats[i - 1][j + 1] != 'x');
  }
}
