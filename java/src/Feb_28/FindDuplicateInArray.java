package Feb_28;

public class FindDuplicateInArray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(arr));

    }


    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        // fast works same as slow but moves twice fast
        int fast = nums[nums[0]];
        while (fast != slow) {
            slow = nums[slow];
            // fast works same as slow but moves twice fast
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }


}
