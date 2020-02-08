package Round1;

public class StockBuySell_4 {

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 1, 4, 3, 1, 3};
        int k = 3;
        int result = getResult(arr, k);
        System.out.println(result);
    }

    private static int getResult(int[] prices, int k) {
        int arr[][] = new int[k + 1][prices.length];

        for (int i = 1; i < arr.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = Math.max(arr[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, arr[i - 1][j] - prices[j]);
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }
}
