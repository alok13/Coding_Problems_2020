package Mar_12;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUChache {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRUChache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    private HashMap<Integer, Node> cMap;
    private Node head;
    private Node tail;

    public LRUChache(int capacity, int map) {
        this.capacity = capacity;
        cMap = new HashMap<>();
        head = null;
        tail = null;
    }

    public void add(Node node) {
        node.prveious = null;
        node.next = null;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prveious = node;
            head = node;
        }

    }

    public void remove(Node node) {
        if (head == node && head == tail) {
            head = null;
            tail = null;
        } else if (head == node) {
            Node next = head.next;
            head.next.prveious = null;
            head.next = null;
            head = next;
        } else if (node == tail) {
            node.prveious = tail;
            node.prveious.next = null;
            node.prveious = null;
        } else {
            node.prveious.next = node.next;
            node.next.prveious = node.prveious;
            node.next = null;
            node.prveious = null;
        }
    }

    public void moveToFirst(Node node) {
        remove(node);
        add(node);
    }

    public void removeLast() {
        remove(tail);
    }

    public int getKey(int key) {
        if (cMap.containsKey(key)) {
            Node node = cMap.get(key);
            moveToFirst(node);
            return node.data;
        } else
            return -1;
    }

    public void addkey(int key, int value) {
        Node node = new Node(key, value);
        if (cMap.size() > capacity) {
            int id = tail.key;
            removeLast();
            cMap.remove(id);

        }

        cMap.put(key, node);
        add(node);
    }


}

class Node {
    int key;
    int data;
    Node prveious;
    Node next;

    public Node(int key, int data) {
        this.key = key;
        this.data = data;
    }

}
