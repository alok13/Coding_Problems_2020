package Mar_12;

public class MultiplyExcpetSelf {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        int[] result = mul(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(result[i] + " ");
    }

    private static int[] mul(int[] arr) {
        int result = 1;
        int res[] = new int[arr.length];
        res[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            result = result * arr[i - 1];
            res[i] = result;
        }

        int right = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            right = right * arr[i + 1];
            res[i] = res[i] * right;

        }
        return res;
    }
}
