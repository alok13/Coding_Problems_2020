package Round1;

public class ReverserLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        printList(n1);
        System.out.println();
        Node root = getReversedList(n1);
        printList(root);
    }

    private static Node getReversedList(Node n1) {
        Node prev = null;
        while (n1 != null) {
            Node temp=n1.next;
            n1.next = prev;
            prev=n1;
            n1 = temp;
        }
        return prev;
    }

    private static void printList(Node n) {
        while (n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }
    }
}


class Node {
    int value;
    Node next = null;

    public Node(int value) {
        this.value = value;
    }
}