package Mar_7.Revision;

public class FrogJump {
    public static void main(String[] args) {
        int arr[] = {0, 1, 3, 5, 6, 8, 12, 17};

        boolean jump = canCross(arr);
        System.out.println(jump);

    }

    public static boolean canCross(int[] stones) {
        int k = 1;
        int start = 0;
        boolean[] visited = new boolean[stones.length];
        visited[0] = true;
        visited[1] = true;
        return canJump(start, k, stones) || canJump(start, k - 1, stones) || canJump(start, k + 1, stones);

    }

    private static boolean canJump(int start, int k, int[] stones) {
        if (start + k == stones.length)
            return true;
        else if (start + k > stones.length || k < 0)
            return false;
        return canJump(start + k, k - 1, stones) ||
                canJump(start + k, k, stones) ||
                canJump(start + k, k + 1, stones);
    }
}
