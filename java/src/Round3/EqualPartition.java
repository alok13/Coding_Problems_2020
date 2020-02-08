package Round3;


public class EqualPartition {
    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        int target = sum / 2;
        boolean result = canPartitioned(0, 0, target, arr);
        System.out.println(result);
    }

    private static boolean canPartitioned(int start, int currentSum, int target, int[] arr) {
        if (currentSum == target)
            return true;
        if (start >= arr.length || arr.length % 2 != 0)
            return false;
        return canPartitioned(start + 1, currentSum + arr[start], target, arr) || canPartitioned(start + 1, currentSum, target, arr);

    }
}
