package Round1;

//https://leetcode.com/problems/container-with-most-water/
public class MaximumWaterTrapped {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = getWaterTrapped(arr);
        System.out.println(result);
    }

    private static int getWaterTrapped(int[] arr) {
        int n1 = 0;
        int n2 = arr.length - 1;
        int prod = 0;
        while (n1 < n2) {
            int fill = (n2 - n1) * Math.min(arr[n1], arr[n2]);
            if (fill > prod) {
                prod = fill;
            }

            if (arr[n1] > arr[n2]) {
                n2--;
            } else {
                n1++;
            }
        }
        return prod;
    }
}
