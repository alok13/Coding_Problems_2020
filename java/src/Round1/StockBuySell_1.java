package Round1;//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class StockBuySell_1 {
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        int result = findResult(arr);
        System.out.println(result);
    }

    private static int findResult(int[] arr) {
        if(arr==null || arr.length<2)
            return 0;

        int diff = 0;
        int curr_min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            diff = Math.max(diff, arr[i] - curr_min);
            curr_min = Math.min(curr_min, arr[i]);
        }
        return diff<0?0:diff;
    }
}
