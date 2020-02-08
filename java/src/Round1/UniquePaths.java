package Round1;//https://leetcode.com/problems/unique-paths/

public class UniquePaths {
    public static void main(String[] args) {
        int m = 7;
        int n = 3;
        int result = getPaths(m, n);
        System.out.println(result);
    }

    private static int getPaths(int m, int n) {
        if (m == 0 && n == 0)
            return 0;

        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;
        }

        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];

    }
}
