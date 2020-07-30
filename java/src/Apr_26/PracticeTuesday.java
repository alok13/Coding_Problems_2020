package Apr_26;

import java.util.*;

public class PracticeTuesday {
    static Node head = null;
    static Node tail = null;

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(i + "," + j + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(j + "," + i + " ");
            }
            System.out.println();
        }

        HashMap<Character, Node> map = new HashMap<>();
        insert("a", head, tail);
    }

    private static void insert(String a, Node head, Node tail) {
        Node node = new Node(a);
        if (head == tail && head == null) {
            head = node;
            tail = node;
        } else if (head == tail) {
            head.next = node;
            node.prev = head;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    public boolean isMatch(String str, String pattern) {
        boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i - 1) == '*') {
                if (dp[0][i - 1] || (i > 1 && dp[0][i - 2])) {
                    dp[0][i] = true;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pattern.charAt(j - 1) == '*') {
                    if (str.charAt(i - 1) != pattern.charAt(j - 2) || pattern.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[str.length()][pattern.length()];
    }

    private static boolean canJump(int[] stones) {
        HashSet<Integer> stoneSet = new HashSet<>();
        for (int s : stones)
            stoneSet.add(s);

        Stack<Integer> jumps = new Stack<>();
        Stack<Integer> positions = new Stack<>();

        jumps.add(stones[0]);
        positions.add(stones[0]);

        while (!positions.isEmpty()) {
            int currPosition = positions.pop();
            int currJump = jumps.pop();
            for (int i = currJump - 1; i < currJump + 1; i++) {
                if (i <= 0)
                    continue;
                int nextPosition = currPosition + i;
                if (nextPosition == stones[stones.length - 1])
                    return true;
                if (stoneSet.contains(nextPosition)) {
                    jumps.add(i);
                    positions.add(nextPosition);
                }
            }
        }
        return false;
    }
}

class Node {
    Node next;
    Node prev;
    String value;

    public Node(String value) {
        this.value = value;
        next = null;
        prev = null;
    }
}
