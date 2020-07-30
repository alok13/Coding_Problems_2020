package Mar_7;

public class Test1 {
    public static void main(String[] args) {
        int N = -5;
        int K = -10;
        int result = getResult(N, K);
        System.out.println(result);
    }

    private static int getResult(int n, int k) {
        if(k>n)
            return -1;
        if (k > n - k)
            k = n - k;

        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n + 1 - i) / i;
            if (result > 1000000000){
                return -1;
            }

        }

        return (int)result;
    }


}
