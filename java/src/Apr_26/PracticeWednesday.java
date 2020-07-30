package Apr_26;

import java.util.LinkedList;
import java.util.Queue;

public class PracticeWednesday {
    public static void main(String[] args) {
        String test = "aabb";
        // getUniQue(test);

        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);
//        ListNode node6 = new ListNode(7);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
//        node4.next = node5;
//        node5.next = node6;

        printList(node);
        System.out.println();
        ListNode result = reverseInK(node, 2);
        printList(result);
    }

    public boolean divideInTwo(int[] arr) {
        int sum = 0;
        for (int a : arr)
            sum += a;
        if (sum % 2 != 0)
            return false;
        return canBeDivided(arr, 0, sum / 2, 0);
    }

    public boolean canBeDividedInK(int[] arr, int currentSum, int target, int index, int K, boolean visited[]) {
        if (K == 1)
            return true;
        if (currentSum == target) {
            canBeDividedInK(arr, 0, target, 0, K - 1, visited);
        }
        for (int i = index; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canBeDividedInK(arr, currentSum + arr[i], target, index + 1, K, visited)) {
                    return true;
                } else
                    visited[i] = false;
            }
        }
        return false;
    }

    private boolean canBeDivided(int[] arr, int currentSum, int target, int index) {
        if (currentSum == target)
            return true;
        if (index >= arr.length)
            return false;
        return canBeDivided(arr, currentSum + arr[index], target, index + 1) ||
                canBeDivided(arr, currentSum, target, index + 1);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        ListNode start = dmy, end = dmy.next; //s: start, e: end
        for (int i = n; i >= k; i -= k) {
            for (int j = 1; j < k; j++) { // reverse group
                ListNode next = end.next;
                end.next = next.next;
                next.next = start.next;
                start.next = next;
            }
            start = end;
            end = start.next;
        }
        return dmy.next;
    }

    private static ListNode reverseInK(ListNode head, int k) {
        int n = 0;
        for (ListNode i = head; i != null; n++, i = i.next) ;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode prev = dummy, tail = head; n >= k; n -= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }
            prev = tail;
            tail = tail.next;
        }
        return dummy.next;
    }



    private static ListNode reverse(ListNode start, ListNode end) {
        ListNode head = start.next;
        ListNode prev = start;
        while (head.next != end) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        ListNode newHead = start.next;
        start.next = head;
        return newHead;
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.value + " ->");
            node = node.next;
        }
    }

    private static void getUniQue(String test) {
        int[] arr = new int[26];
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < test.length(); i++) {
            System.out.println(getFirst(test.charAt(i), arr, queue));
        }

    }

    private static String getFirst(char c, int[] arr, Queue<Character> queue) {
        arr[c - 'a']++;
        if (arr[c - 'a'] == 1)
            queue.add(c);
        while (!queue.isEmpty() && arr[queue.peek() - 'a'] != 1) {
            queue.remove();
        }
        return queue.isEmpty() ? "-1" : queue.poll().toString();
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}