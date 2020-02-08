package Round2;

//https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
public class LargestSumOfNonAdjacentNumbers {
    public static void main(String[] args) {
        int arr[] = {5, 5, 10, 100, 10, 5};
        int result = getSum(arr);
        System.out.println(result);
    }

    private static int getSum(int[] arr) {
        int[] sum = new int[arr.length];

        sum[0] = arr[0];
        sum[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            sum[i] = Math.max(sum[i - 2] + arr[i], sum[i - 1]);
        }
        return sum[arr.length - 1];
    }
}
