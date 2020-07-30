package Feb_28;

import java.util.*;

public class ViewOfTree {

    public static void main(String[] args) {
        // construct binary tree as shown in
        // above diagram
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right.left = new Node(14);

        //printRightView(root);
        // topView(root);
        // Node result = lowestCommonAncestor(root, 12, 14);
        //  System.out.println(result.data);
        inOrderTraversalUsingStack(root);
    }

    private static void inOrderTraversalUsingStack(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            Node next = stack.pop();
            root = next.right;
            System.out.println(next.data);
        }
    }

    private static Node lowestCommonAncestor(Node root, int num, int num2) {
        if (root == null)
            return null;
        if (root.data == num || root.data == num2)
            return root;
        Node left = lowestCommonAncestor(root.left, num, num2);
        Node right = lowestCommonAncestor(root.right, num, num2);
        if (left == null)
            return right;
        else if (right == null)
            return left;
        return root;
    }

    private static void topView(Node root) {
        Map<Integer, Node> map = new HashMap<>();
        map.putIfAbsent(0, root);
        traverseTree(root, map, 0);

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            System.out.println(entry.getValue().data);
        }
    }

    private static void traverseTree(Node root, Map<Integer, Node> map, int D) {
        if (root.left == null && root.right == null)
            return;
        if (root.left != null) {
            if (!map.containsKey(D - 1))
                map.put(D - 1, root.left);
            traverseTree(root.left, map, D - 1);
        }
        if (root.right != null) {
            if (!map.containsKey(D + 1))
                map.put(D + 1, root.right);
            traverseTree(root.right, map, D + 1);
        }
    }

    private static void printRightView(Node root) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            System.out.println(q1.peek().data);
            while (!q1.isEmpty()) {
                Node n = q1.poll();
                if (n.right != null) {
                    q2.add(n.right);
                }
                if (n.left != null) {
                    q2.add(n.left);
                }
            }
            System.out.println(q2.peek().data);
            while (!q2.isEmpty()) {
                Node n = q2.poll();
                if (n.right != null) {
                    q1.add(n.right);
                }
                if (n.left != null) {
                    q1.add(n.left);
                }
            }
        }
    }


}


class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}



