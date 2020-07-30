package Mar_7;

public class MaximumProductInArray {
    public static void main(String[] args) {
        int arr[] = {2, 3, -2, 4};
        int result = getResult(arr);
        System.out.println(result);
    }

    private static int getResult(int[] arr) {
        int max = 1;
        int min = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                max = Math.max(max * arr[i], arr[i]);
                min = Math.min(min * arr[i], arr[i]);
            } else {
                int temp = max;
                max = Math.max(min * arr[i], arr[i]);
                min = Math.min(temp * arr[i], arr[i]);
            }
            result = Math.max(max, result);
        }
        return result;
    }
}
