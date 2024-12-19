package euler;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question {

  public static void main(String[] args) {
    int[][] valid = new int[][]{{0, 1}, {1, 2}, {2, 0}};
    int[][] pathValid1 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {0, 3}};
    int[][] pathValid2 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}};
    int[][] invalid = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {0, 3}, {2, 0}};
    int[][] empty = new int[0][0];

    System.out.println(isEulerUndirected(3, valid));
    System.out.println(isEulerUndirected(4, pathValid1));
    System.out.println(isEulerUndirected(4, pathValid2));
    System.out.println(isEulerUndirected(4, invalid));
    System.out.println(isEulerUndirected(0, empty));
  }

  // class to check if graph is a euler graph
  // 0 indicates is not an euler graph
  // 1 indicates semi-euler graph, that is an euler path
  // 2 indicates full euler graph, that is, an euler circuit

  public static int isEulerUndirected(int n, int[][] edges) {

    // step 1, build an adjacency list with the edges
    List<List<Integer>> adjList = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adjList.add(new LinkedList<>());
    }

    for (int[] e : edges) {
      adjList.get(e[0]).add(e[1]);
      adjList.get(e[1]).add(e[0]);
    }

    // step 2, find out if input is an euler graph
    // do a dfs, start from a vertex with a degree > 0.
    // if no vertices have degree > 0, return 2 (It is a full eulerian graph)

    int start = -1;
    for (int i = 0; i < n; i++) {
      if (adjList.get(i).size() > 0) {
        start = i;
        break;
      }
    }

    if (start == -1) {
      return 2;
    }

    // run a dfs and visit the nodes. This checks for multiconnected component
    // have a boolean visited array.

    boolean[] visited = new boolean[n];

    runDFS(start, visited, adjList);

    // after running dfs, find if connected components exist with seperate edges
    // for each v, if false (not visited), if size > 0, return 0;

    for (int i = 0; i < n; i++) {
      if (!visited[i] && adjList.get(i).size() > 0) {
        return 0;
      }
    }

    // now we do a check for odd number of edges. If 2 odd edges, return 1. If no odd edges, return 2
    // else, return 0

    int odd = 0;
    for (int i = 0; i < n; i++) {
      if (adjList.get(i).size() % 2 == 1) {
        odd++;
      }
    }
    if (odd == 2) {
      return 1;
    }
    if (odd == 0) {
      return 2;
    }
    return 0;
  }

  public static void runDFS(int v, boolean[] visited, List<List<Integer>> adjList) {
    if (visited[v]) {
      return;
    }
    visited[v] = true;
    for (int other : adjList.get(v)) {
      runDFS(other, visited, adjList);
    }
  }
}
