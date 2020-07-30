package Feb_28;

public class MaximumContigousSubArray {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int sum = getSum(a);
        System.out.println(sum);
    }

    private static int getSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] sumArray = new int[arr.length];
        sumArray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int currSum = Math.max(sumArray[i - 1] + arr[i], arr[i]);
            sumArray[i] = currSum;
            max = Math.max(currSum, max);
        }
        return max;
    }
}
