package Round1;//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class StockBuySell_2 {

    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        int result = findResult(arr);
        System.out.println(result);
    }

    private static int findResult(int[] arr) {
        if(arr==null || arr.length<2)
            return 0;
        int total = 0;
        for (int i=0; i< arr.length-1; i++) {
            if (arr[i+1]>arr[i])
                total += arr[i+1]-arr[i];
        }

        return total;
    }
}
