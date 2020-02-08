package Round3;

public class MinimumSumTriangle {
    public static void main(String[] args) {
        int arr[][] = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int result = getResult(arr);
        System.out.println(result);
    }

    private static int getResult(int[][] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                min = Math.min(min, arr[i][j]);
            }
            result += min;
        }
        return result;
    }
}
