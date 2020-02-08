package Round1;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductExceptSelf {
    public static void main(String[] args) {
        int arr[] = {2, 3, 0, 5};
        int[] result = getProdcuts(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] getProdcuts(int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;
        int result[] = new int[arr.length];
        int left = 1;
        result[0] = left;
        for (int i = 1; i < result.length; i++) {
            left = left * arr[i - 1];
            result[i] = left;
        }
        int right = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            right = right * arr[i + 1];
            result[i] = result[i] * right;
        }

        return result;
    }
}


