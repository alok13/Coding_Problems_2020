package Mar_21;

import java.util.*;

public class KNodeInTree {
    public static void main(String[] args) {
        TreeNode1 node = new TreeNode1(3);
        TreeNode1 node1 = new TreeNode1(5);
        TreeNode1 node2 = new TreeNode1(1);
        node.left = node1;
        node.right = node2;

        TreeNode1 node3 = new TreeNode1(6);
        node1.left = node3;

        TreeNode1 node4 = new TreeNode1(2);
        node1.right = node4;
        TreeNode1 node5 = new TreeNode1(7);
        node4.left = node5;
        TreeNode1 node6 = new TreeNode1(4);
        node4.right = node6;

        TreeNode1 node7 = new TreeNode1(0);
        node2.left = node7;

        TreeNode1 node8 = new TreeNode1(8);
        node2.right = node8;

        System.out.println(distanceK(node, node1, 2));

    }

    public static List<Integer> distanceK(TreeNode1 root, TreeNode1 target, int K) {
        HashMap<TreeNode1, TreeNode1> map = new HashMap<>();
        buildMap(root, map, null);

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(target);
        HashSet<TreeNode1> visited = new HashSet<>();
        visited.add(target);

        List<Integer> list = new ArrayList<>();

        int level = 0;
        while (!queue.isEmpty()) {

            if (level == K) {
                for (TreeNode1 node : queue) {
                    list.add(node.val);
                }
                return list;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode1 curr = queue.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                    visited.add(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                    visited.add(curr.right);
                }

                TreeNode1 par = map.get(curr);
                if (par != null && !visited.contains(par)) {
                    queue.offer(par);
                    visited.add(par);
                }

            }

            level++;
        }
        return list;
    }

    public static void buildMap(TreeNode1 node, HashMap<TreeNode1, TreeNode1> map, TreeNode1 parent) {
        if (node == null)
            return;
        map.put(node, parent);
        buildMap(node.left, map, node);
        buildMap(node.right, map, node);

    }


}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int x) {
        val = x;
    }
}
