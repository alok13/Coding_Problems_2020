package Round1;

//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPath {
    public static void main(String[] args) {
        // int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] arr = {{0, 1}, {1, 0}};
        int result = findPaths(arr);
        System.out.println(result);
    }

    private static int findPaths(int[][] arr) {
        if (arr == null)
            return 0;
        if (arr.length == 0 && arr[0].length == 0)
            return 0;

        int m = arr.length;
        int n = arr[0].length;
        int sum[][] = new int[m][n];
        sum[0][0] = arr[0][0];

        for (int i = 1; i < arr.length; i++) {
            sum[i][0] = arr[i][0] + sum[i - 1][0];
        }

        for (int i = 1; i < arr[0].length; i++) {
            sum[0][i] = arr[0][i] + sum[0][i - 1];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                sum[i][j] = arr[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
            }
        }
        return sum[m - 1][n - 1];
    }
}
