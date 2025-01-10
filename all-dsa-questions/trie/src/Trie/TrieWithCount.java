package Trie;

public class TrieWithCount implements Trie {

  private final TrieNode root;

  public TrieWithCount() {
    this.root = new TrieNode();
  }

  @Override
  public void insert(String w) {
    TrieNode curr = this.root;
    for (char c : w.toCharArray()) {
      if (curr.letters[c - 'a'] == null) {
        curr.letters[c - 'a'] = new TrieNode();
      }
      curr = curr.letters[c - 'a'];
      curr.freq += 1;

    }
    curr.isWord = true;
  }

  @Override
  public boolean isWord(String w) {
    TrieNode lastNode = last(w);
    return lastNode != null && lastNode.isWord;
  }

  private TrieNode last(String w) {
    TrieNode curr = this.root;
    for (char c : w.toCharArray()) {
      if (curr.letters[c - 'a'] == null) {
        return null;
      }
      curr = curr.letters[c - 'a'];
    }
    return curr;
  }

  public boolean getLast(String w) {
    TrieNode lastNode = last(w);
    return (lastNode != null ? lastNode.freq : 0) > 1;
  }

  private static class TrieNode {

    private final TrieNode[] letters;
    private boolean isWord;
    private int freq;

    public TrieNode() {
      this.letters = new TrieNode[26];
      this.isWord = false;
      this.freq = 0;
    }
  }
}
