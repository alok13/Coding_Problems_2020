package CTCI.LinkedLists;

public class PartitionList {
    public static void main(String[] args) {
        CustomList list = new CustomList();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(15);
        list.head.next.next.next.next = new Node(14);
        list.head.next.next.next.next.next = new Node(13);
        list.head.next.next.next.next.next.next = new Node(10);

        partitionList(list.head, 12);
    }

    private static void partitionList(Node head, int i) {
    }
}
