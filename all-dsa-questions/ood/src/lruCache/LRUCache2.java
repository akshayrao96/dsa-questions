package lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

  protected Map<Integer, ListNode> map;
  protected ListNode head;
  protected ListNode tail;
  protected int size;
  protected int max;

  public LRUCache2(int capacity) {
    this.map = new HashMap<>();
    this.head = new ListNode(-1, -1); // Dummy head
    this.tail = new ListNode(-1, -1); // Dummy tail
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.size = 0;
    this.max = capacity;
  }

  public int get(int key) {
    if (!this.map.containsKey(key)) {
      return -1;
    }

    ListNode node = this.map.get(key);
    moveToTail(node); // Reuse helper method
    return node.val;
  }

  public void put(int key, int value) {
    if (this.map.containsKey(key)) {
      ListNode node = this.map.get(key);
      node.val = value; // Update value
      moveToTail(node); // Reuse helper method
    } else {
      if (this.size == this.max) {
        removeLeastRecentlyUsed(); // Reuse helper method
      }
      ListNode newNode = new ListNode(key, value);
      addToTail(newNode); // Reuse helper method
      this.map.put(key, newNode);
      this.size++;
    }
  }

  private void moveToTail(ListNode node) {
    removeNode(node);
    addToTail(node);
  }

  private void removeNode(ListNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void addToTail(ListNode node) {
    node.prev = this.tail.prev;
    node.next = this.tail;
    this.tail.prev.next = node;
    this.tail.prev = node;
  }

  private void removeLeastRecentlyUsed() {
    ListNode lru = this.head.next;
    removeNode(lru);
    this.map.remove(lru.key);
    this.size--;
  }

  public class ListNode {

    protected int key;
    protected int val;
    protected ListNode next;
    protected ListNode prev;

    public ListNode(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }
}
