package DataStructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, MyNode> data;
    private MyNode head;
    private MyNode end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.data = new HashMap<>();
    }

    public void add(MyNode node) {
        node.next = null;
        node.previous = null;
        if (null == this.head) {
            head = node;
            end = node;
            return;
        }

        this.head.previous = node;
        node.next = head;
        this.head = node;

    }

    public void remove(MyNode node) {
        if (this.head == null || node == null)
            return;
        // only item
        if (head == end && node == head) {
            head = null;
            end = null;
            return;
        }
        if (head == node) {
            node.next = head;
            head.previous = null;
            return;
        }
        if (end == node) {
            end = node.previous;
            node.previous.next = null;
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

}

class MyNode {
    int value;
    int key;
    MyNode next;
    MyNode previous;


}
