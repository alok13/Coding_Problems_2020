package Round1;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = getResult(arr);
        System.out.println(result);
    }

    private static int getResult(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int sum = Integer.MIN_VALUE;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max + arr[i]);
            sum = Math.max(sum, max);
        }
        return sum;
    }
}
