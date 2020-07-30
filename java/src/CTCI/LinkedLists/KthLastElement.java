package CTCI.LinkedLists;

//Implement an algorithm to find the kth to last element of a singly linked list
public class KthLastElement {
    public static void main(String[] args) {
        CustomList1 list = new CustomList1();
        list.head = new Node1(16);
        list.head.next = new Node1(15);
        list.head.next.next = new Node1(14);
        list.head.next.next.next = new Node1(13);
        list.head.next.next.next.next = new Node1(12);
        list.head.next.next.next.next.next = new Node1(11);
        list.head.next.next.next.next.next.next = new Node1(10);

        System.out.println("Linked List before removing duplicates : \n ");
        printList(list.head);
        int value = getKthNode(list.head, 3);
        int value1 = getKthNodeByRecursion(list.head, 3);
        System.out.println();
        System.out.println(value);
        System.out.println(value1);

    }

    private static int getKthNodeByRecursion(Node1 head, int K) {
        if (head == null)
            return 0;
        int i = getKthNodeByRecursion(head.next, K) + 1;
        if (i == K) {
            return head.data;
        }
        return i;
    }

    private static int getKthNode(Node1 head, int K) {
        int length = 0;
        Node1 root = head;
        while (head != null) {
            length++;
            head = head.next;
        }
        int count = 0;
        while (root != null) {
            if (length - count == K) {
                return root.data;
            } else {
                count++;
                root = root.next;
            }
        }
        return 0;
    }

    private static void printList(Node1 node) {
        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.next;
        }
    }
}


class CustomList1 {
    Node1 head;
}

class Node1 {

    int data;
    Node1 next;

    Node1(int d) {
        data = d;
        next = null;
    }
}
