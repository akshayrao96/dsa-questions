package StringMatching;

import Trie.TrieWithCount;
import java.util.ArrayList;
import java.util.List;

public class StringMatching {

  public static void main(String[] args) {
    String[] w = new String[]{"mass","as","hero","superhero"};
    System.out.println(stringMatching(w));
  }

  public static List<String> stringMatching(String[] words) {
    TrieWithCount t = new TrieWithCount();
    for (String w : words) {
      for (int i = 0; i < w.length(); i++) {
        t.insert(w.substring(i));
      }
    }

    int count = 0;

    List<String> res = new ArrayList<>();

    for (String w : words) {
      if (t.getLast(w)) {
        res.add(w);
      }
    }

    return res;
  }
}
