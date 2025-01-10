package busRoutes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question {

  public static int numBusesToDestination(int[][] routes, int source, int target) {
    Map<Integer, List<int[]>> adjList = new HashMap<>();
    int n = routes.length;

    for (int i = 0; i < n; i++) {
      int[] route = routes[i];
      int m = route.length;
      for (int j = 0; j < m; j++) {
        int curr = route[j];
        int next = j + 1 >= m ? route[0] : route[j + 1];
        if (!adjList.containsKey(curr)) adjList.put(curr, new ArrayList<>());
        adjList.get(curr).add(new int[]{next, i});
      }
    }

    int[] res = new int[]{-1};
    Map<Integer, Integer> seen = new HashMap<>();
    runDFS(adjList, source, target, 0, res, seen, -1);

    return res[0];
  }

  private static void runDFS(Map<Integer, List<int[]>> adjList, int source,
      int target, int stops, int[] res, Map<Integer, Integer> seen, int currRoute) {

    // refactor base cases
    if (source == target) {
      res[0] = res[0] == -1 ? stops : Math.min(res[0], stops);
      return;
    }

    if (seen.containsKey(source) && stops >= seen.get(source)) {
      return;
    }

    seen.put(source, stops);

    for (int[] other : adjList.get(source)) {
      int otherStop = other[0];
      int route = other[1];
      runDFS(adjList, otherStop, target, route != currRoute ? stops + 1 : stops, res, seen, route);
    }
  }

  public static void main(String[] args) {
    int[][] routes = new int[][]{{1,9,12,20,23,24,35,38},{10,21,24,31,32,34,37,38,43},{10,19,28,37},{8},{14,19},
        {11,17,23,31,41,43,44},{21,26,29,33},{5,11,33,41},{4,5,8,9,24,44}};
    int result = numBusesToDestination(routes, 37, 28);

    System.out.println(result);
  }

}
