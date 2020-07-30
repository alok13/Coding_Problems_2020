package CTCI.LinkedLists;

import java.util.LinkedList;

//You have two numbers represented by a linked list, where each node contains a single
//digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
//function that adds the two numbers and returns the sum as a linked list.
//EXAMPLE
//Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
//Output: 2 -> 1 -> 9. That is, 912.
//FOLLOW UP
//Suppose the digits are stored in forward order. Repeat the above problem.
//EXAMPLE
//lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
//Output: 9 - > 1 -> 2. That is, 912.
public class AddNumberInList {
    public static void main(String[] args) {
        CustomList list = new CustomList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);

        CustomList list1 = new CustomList();
        list1.head = new Node(1);
        list1.head.next = new Node(2);
        list1.head.next.next = new Node(3);
        list1.head.next.next.next = new Node(3);

        Node result = addTwoList(list.head, list1.head);
        printList(result);


    }

    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.next;
        }
    }

    private static Node addTwoList(Node list, Node list1) {
        Node head = null;
        Node next = null;
        int carry = 0;
        while (list != null && list1 != null) {
            int sum = list.data + list1.data + carry;
            carry = sum / 10;
            if (head == null) {
                head = new Node(sum % 10);
                next = head;
            } else {
                head.next = new Node(sum % 10);
                head = head.next;
            }


            list = list.next;
            list1 = list1.next;

        }
        if (list != null) {
            while (list != null) {
                int sum = list.data + carry;
                carry = sum / 10;
                if (head == null)
                    head = new Node(sum % 10);
                else {
                    head.next = new Node(sum % 10);
                    head = head.next;
                }

                list = list.next;
            }

        }

        if (list1 != null) {
            while (list1 != null) {
                int sum = list1.data + carry;
                carry = sum / 10;
                head.next = new Node(sum % 10);
                head = head.next;


                list1 = list1.next;
            }

        }

        return next;
    }
}

