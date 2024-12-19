package lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  protected Map<Integer, ListNode> map;
  protected ListNode head;
  protected ListNode tail;
  protected int size;
  protected int max;

  public LRUCache(int capacity) {
    this.map = new HashMap<>();
    this.head = new ListNode(-1, -1, null);
    this.tail = this.head;
    this.size = 0;
    this.max = capacity;

  }

  public int get(int key) {
    // If our key is not in the LRU Cache, return -1
    if (!map.containsKey(key)) {
      return -1;
    }
    int val = map.get(key).val;

    ListNode node = map.get(key);

    // If our node is at the end of the LRU cache, we can keep it there
    if (node == this.tail) return val;

    // Remove the node from our list
    node.prev.next = node.next;
    node.next.prev = node.prev;

    // change our tail to be the same node
    this.tail.next = new ListNode(key, val, this.tail);
    this.tail = this.tail.next;

    map.put(key, this.tail);
    return val;
  }

  public void put(int key, int value) {
    // If key is in our LRU cache, run get on it, since that moves it to the back
    // Then we just need to change the value
    if (map.containsKey(key)) {

      this.get(key);
      this.tail.val = value;
      map.put(key, this.tail);

    } else {

      // If we still have capacity, just add our entry to the end of the list
      if (this.size < this.max) {
        this.tail.next = new ListNode(key, value, this.tail);
        this.tail = this.tail.next;
        map.put(key, this.tail);
        this.size++;
      } else {

        // No capacity. Remove the front entry of the list
        // Then add the node to the end of the list
        
        map.remove(this.head.next.key);
        this.head.next = this.head.next.next;

        if (this.head.next == null) {
          this.tail = this.head;
        } else {
          this.head.next.prev = this.head;
        }

        this.tail.next = new ListNode(key, value, this.tail);
        this.tail = this.tail.next;
        map.put(key, this.tail);
      }
    }
  }

  public class ListNode {

    protected int key;
    protected int val;
    protected ListNode next;
    protected ListNode prev;

    public ListNode(int key, int val, ListNode prev) {
      this.key = key;
      this.val = val;
      this.prev = prev;
      this.next = null;
    }
  }
}
