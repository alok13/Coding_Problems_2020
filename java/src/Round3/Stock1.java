package Round3;

public class Stock1 {
    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        int[] arr = {2, 5, 7, 1, 4, 3, 1, 3};
        int K = 3;
        int result = getResult(price);
        int result2 = getResult2(price);
        int result3 = getResult3(arr, K);
        System.out.println(result3);
    }

    private static int getResult3(int[] arr, int K) {
        int[][] dp = new int[K + 1][arr.length];
        for (int i = 1; i < dp.length; i++) {
            int maxDiff = dp[i - 1][0] - arr[0];
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], arr[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - arr[j]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    private static int getResult2(int[] arr) {
        int max_sum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i])
                max_sum = max_sum + arr[i] - arr[i - 1];
        }
        return max_sum;
    }

    private static int getResult(int[] price) {
        int min = price[0];
        int max_sum = 0;
        for (int i = 0; i < price.length; i++) {
            min = Math.min(min, price[i]);
            max_sum = Math.max(max_sum, price[i] - min);
        }
        return max_sum;
    }

    /**
     * This is slow method but easier to understand.
     * Time complexity is O(k * number of days ^ 2)
     * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is 0...j-1
     */
    public int maxProfitSlowSolution(int prices[], int K) {
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[K+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                int maxVal = 0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i-1][m]);
                }
                T[i][j] = Math.max(T[i][j-1], maxVal);
            }
        }
        return T[K][prices.length - 1];
    }




}
