package CTCI.LinkedLists;

//Implement an algorithm to delete a node in the middle (i.e., any node but
//the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
//that node.
//EXAMPLE
//lnput:the node c from the linked lista->b->c->d->e->f
//Result: nothing is returned, but the new linked list looks like a->b->d->e- >f
public class DeleteNode {
    public static void main(String[] args) {
        CustomList list = new CustomList();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(13);
        list.head.next.next.next = new Node(14);

        deleteNode(list.head, 12);
        printList(list.head);
    }

    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.next;
        }
    }

    private static void deleteNode(Node node, int i) {
        Node previous = node;
        Node next = node.next;

        while (next != null) {
            if (next.data == i) {
                previous.next = next.next;
                return;
            }
            previous = next;
            next = next.next;

        }
    }
}
