package maxQualityScore;

import java.util.ArrayList;
import java.util.List;

public class Question {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(5);
    list.add(-1);
    list.add(-5);
    list.add(4);

    List<Integer> subList = new ArrayList<>();
    subList.add(4);
    subList.add(-5);
    subList.add(5);
    subList.add(-7);
    subList.add(1);

    System.out.println(maxQualityScore(2, list));
    System.out.println(maxQualityScore(2, subList));

  }

  public static long maxQualityScore(int impactFactor, List<Integer> list) {
    long firstMaxScore = multiplyScore(impactFactor, list);
    long secondMaxScore = divideScore(impactFactor, list);

    return Math.max(firstMaxScore, secondMaxScore);
  }

  private static long multiplyScore(int impactFactor, List<Integer> list) {
    long maxScore = (long) list.get(0) * impactFactor;
    long currScore = 0;

    for (int num : list) {
      int newScore = num * impactFactor;
      currScore += newScore;

      if (newScore >= currScore) currScore = newScore;
      maxScore = Math.max(maxScore, currScore);
    }
    return maxScore;
  }

  private static long divideScore(int impactFactor, List<Integer> list) {
    long maxScore = (long) list.get(0) / impactFactor;
    long currScore = 0;

    for (int num : list) {
      int newScore = num / impactFactor;
      currScore += newScore;

      if (newScore >= currScore) currScore = newScore;
      maxScore = Math.max(maxScore, currScore);
    }
    return maxScore;
  }
}
