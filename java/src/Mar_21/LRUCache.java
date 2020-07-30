package Mar_21;
import java.util.HashMap;
//For your needs, use ConcurrentHashMap. It allows concurrent modification of the Map from several threads without the need to block them.
// Collections.synchronizedMap(map) creates a blocking Map which will degrade performance, albeit ensure consistency (if used properly).
//Use the second option if you need to ensure data consistency, and each thread needs to have an up-to-date view of the map.
// Use the first if performance is critical, and each thread only inserts data to the map, with reads happening less frequently.

//For your needs, use ConcurrentHashMap. It allows concurrent modification of the Map from several threads without the need to block them.
// Collections.synchronizedMap(map) creates a blocking Map which will degrade performance, albeit ensure consistency (if used properly).
//Use the second option if you need to ensure data consistency, and each thread needs to have an up-to-date view of the map.
// Use the first if performance is critical, and each thread only inserts data to the map, with reads happening less frequently.

public class LRUCache {
    private HashMap<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;
    private int capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            moveToFirst(node);
            value = node.value;
        }
        return value;
    }
    public void set(int key, int value) {
        ListNode newNode =map.computeIfPresent(key, (k,v) -> map.get(key));
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            moveToFirst(node);
        }
        if (map.size() == capacity) {
            removeLast();
        }
        ListNode node = new ListNode();
        node.value = value;
        node.key = key;
        addNode(node);
        map.put(key, node);
    }


    private void moveToFirst(ListNode node) {
        remove(node);
        addNode(node);
    }

    private void removeLast() {
        remove(tail);
    }

    private void addNode(ListNode node) {
        node.next = null;
        node.prev = null;
        if (head == tail && head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    private void remove(ListNode node) {
        if (head == tail && head == null) {
            return;
        }
        if (head == tail && head == node) {
            head = null;
            tail = null;
            return;
        }
        if (head == node) {
            head = node.next;
            head.prev = null;
            return;
        }
        if (tail == node) {
            node.prev = tail;
            tail.next = null;
            return;
        }
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }


}

class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;
}
