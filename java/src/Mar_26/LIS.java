package Mar_26;

import java.util.Arrays;

public class LIS {

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 2, 8, 4, 6};
        int length = lengthOfLIS(arr);
        System.out.println(length);

    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if (i == len) len++;
        }

        return len;
    }
}