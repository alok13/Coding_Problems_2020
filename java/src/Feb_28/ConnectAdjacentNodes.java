package Feb_28;

public class ConnectAdjacentNodes {
    public static void main(String[] args) {
        Node1 root = new Node1(10);
        root.left = new Node1(8);
        root.right = new Node1(2);
        root.left.left = new Node1(3);
        root.right.right = new Node1(90);

        getConnected(root);

        // Let us check the values of nextRight pointers
        int a = root.nextRight != null ?
                root.nextRight.data : -1;
        int b = root.left.nextRight != null ?
                root.left.nextRight.data : -1;
        int c = root.right.nextRight != null ?
                root.right.nextRight.data : -1;
        int d = root.left.left.nextRight != null ?
                root.left.left.nextRight.data : -1;
        int e = root.right.right.nextRight != null ?
                root.right.right.nextRight.data : -1;

        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the tree(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + root.data + " is " + a);
        System.out.println("nextRight of " + root.left.data + " is " + b);
        System.out.println("nextRight of " + root.right.data + " is " + c);
        System.out.println("nextRight of " + root.left.left.data +
                " is " + d);
        System.out.println("nextRight of " + root.right.right.data +
                " is " + e);
    }

    private static void getConnected(Node1 root) {
        if (root == null)
            return;
        if (root.left != null && root.right != null)
            root.left.nextRight = root.right;
        if (root.right != null && root.nextRight != null) {
            if (root.nextRight.left != null)
                root.right.nextRight = root.nextRight.left;
            else
                root.right.nextRight = root.nextRight.right;
        }

        getConnected(root.left);
        getConnected(root.right);


    }
}


class Node1 {
    int data;
    Node1 left, right, nextRight;

    Node1(int item) {
        data = item;
        left = right = nextRight = null;
    }
}