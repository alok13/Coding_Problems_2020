package Mar_18;

//https://leetcode.com/problems/first-missing-positive/
public class MissingPositiveInteger {
    public static void main(String[] args) {

        int[] arr = {3, 4, -1, 1};
        int result = getPPositiveNumber(arr);
        System.out.println(result);
    }

    private static int getPPositiveNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
