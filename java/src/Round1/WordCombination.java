package Round1;//https://leetcode.com/problems/combination-sum-iv/

import java.util.Arrays;

public class WordCombination {
    static int[] sums;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = getResult(target, nums);
        System.out.println(result);
    }

    private static int getResult(int target, int[] nums) {

        sums = new int[target+1];
        Arrays.fill(sums, -1);
        sums[0]=1;
        return helpMe(target, nums);

    }

    private static int helpMe(int target, int[] nums) {
        if (sums[target] != -1)
            return sums[target];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                {
                    res += helpMe(target - nums[i], nums);
                }
            }
        }
        sums[target] = res;
        return res;
    }
}
