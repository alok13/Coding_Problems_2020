package Round1;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        int result = getLIS(arr);
        System.out.println(result);
    }

    private static int getLIS(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int dis[] = new int[arr.length];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    dis[i] = Math.max(dis[j] + 1, dis[i]);
                    max = Math.max(max, dis[i]);
                }
            }

        }
        return max;
    }
}
