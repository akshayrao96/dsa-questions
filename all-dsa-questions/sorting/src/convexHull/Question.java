package convexHull;

/*
Writing a o convex hull algorithm, the minimum vertices of a set that form the
perimeter of an area

We will assume many points as input, and our algorithm will return the list of points
that form the convex hull
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Question {

  public static void main(String[] args) {
    List<int[]> points1 = createPoints(0);
    List<int[]> points2 = createPoints(1);
//    List<int[]> res = convexHull(points1);
//    System.out.println(res.toString());

  }

  //sort points based on polar angle from p
  private static void convexHull(List<int[]> points1) {
    // get bottom right most point. If x's are equal, get lowest y value
    int start = getStart(points1);
    int[] p = points1.remove(start);

    points1.sort((a, b) -> {
      double g1 = (double) (a[1] - p[1]) / (a[0] - p[0]);
      double g2 = (double) (b[1] - p[1]) / (b[0] - p[0]);
      return Double.compare(g1, g2);
    });

    // need a stack to hold our points data structure
    Stack<int[]> stack = new Stack<>();
    stack.push(p);
    stack.push(points1.get(1));

    // Always assume the next point is good
    //TODO
    // change return type



  }

  private static void gradient(Object a, int[] p) {

    //TODO change return type
  }

  private static int getStart(List<int[]> points) {
    int x = Integer.MIN_VALUE;
    int y = Integer.MAX_VALUE;
    int idx = -1;
    int i = 0;
    for (int[] p : points) {
      if (p[0] > x || p[0] == x && p[1] < y) {
        idx = i;
      }
      i++;
    }
    return i;
  }


  private static List<int[]> createPoints(int useCase) {
    return useCase == 0 ? createPoints1() : createPoints2();
  }

  private static List<int[]> createPoints1() {
    List<int[]> list = new ArrayList<>();
    list.add(new int[]{3, 3});
    list.add(new int[]{2, 2});
    list.add(new int[]{4, 2});
    list.add(new int[]{8, 2});
    list.add(new int[]{3, 1});
    list.add(new int[]{1, -6});
    list.add(new int[]{5, -1});
    return list;
  }

  private static List<int[]> createPoints2() {
    List<int[]> list = new ArrayList<>();
    //TODO
    return list;
  }
}

/*
case 1:
      .
    .   .     .
      .
          .
    .

4 points in convex hull [3,3] [2,2] [1,-6] [8,2] MAYBE [5,-1], change accordingly

case 2:
 .      .
  .   .     .
 .            .
    .   .   .
.   .



Firstly, I want to sort the points with a custom comparator. Sort by the most bottom right
point being first.

Secondly, I want to run the algorithm. How do I do this?

Essentially, I need a comparison of 3 different points

p1, p2, p3

I now want to
 */