package Round1;

public class MaxiMumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {-4,-3,-2};
        int result = getProduct(arr);
        System.out.println(result);
    }

    private static int getProduct(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int imax = 1;
        int imin = 1;
        int prod = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                imax = Math.max(imax * nums[i], nums[i]);
                imin = Math.min(imin * nums[i], nums[i]);
            } else {
                int temp=imax;
                imax = Math.max(nums[i], imin * nums[i]);
                imin = Math.min(nums[i], temp * nums[i]);
            }

            prod = Math.max(imax, prod);

        }
        return prod;
    }
}
