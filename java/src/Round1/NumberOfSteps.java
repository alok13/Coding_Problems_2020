package Round1;

//https://leetcode.com/problems/climbing-stairs/
public class NumberOfSteps {
    public static void main(String[] args) {
        int n = 3;
        int result = getSteps(n);
        System.out.println(result);
    }

    private static int getSteps(int n) {
        int[] arr = new int[n + 1];
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return n;
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];

        }
        return arr[n];
    }
}
