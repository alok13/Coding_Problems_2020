package CTCI.LinkedLists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//Remove Dups! Write code to remove duplicates from an unsorted linked list.
public class RemoveDuplicate {
    public static void main(String[] args) {
        CustomList list = new CustomList();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked List before removing duplicates : \n ");
        printList(list.head);
        removeDuplicate(list.head);
        System.out.println();
        printList(list.head);


    }

    private static void removeDuplicate(Node head) {
        Set<Integer> valueSet = new HashSet<>();
        Node root = head.next;
        Node previous = head;
        valueSet.add(head.data);
        while (root != null) {
            if (valueSet.contains(root.data)) {
                previous.next = root.next;
                root = root.next;
            } else {
                valueSet.add(root.data);
                previous = root;
                root = root.next;
            }
        }
    }

    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.next;
        }
    }
}

class CustomList {
    Node head;
}

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

