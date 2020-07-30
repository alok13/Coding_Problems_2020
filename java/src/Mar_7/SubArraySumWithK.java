package Mar_7;


import java.util.*;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubArraySumWithK {
    public static void main(String[] args) {
        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8,0};
        int k = 15;
        System.out.println(getSum(arr, k));
    }

    private static int getSum(Integer[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}