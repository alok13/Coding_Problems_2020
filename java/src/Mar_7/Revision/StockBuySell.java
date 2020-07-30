package Mar_7.Revision;

public class StockBuySell {
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        int result = getResult(arr);
        int result1 = getResultAsManyAsWnat(arr);
        System.out.println(result);
        System.out.println(result1);
    }

    private static int getResultAsManyAsWnat(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                sum += arr[i + 1] - arr[i];
            }
        }
        return sum;
    }

    private static int getResult(int[] arr) {
        int sum = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            sum = Math.max(sum, arr[i] - min);
        }
        return sum;
    }
}
