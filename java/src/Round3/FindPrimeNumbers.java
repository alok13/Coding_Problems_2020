package Round3;

import java.util.Arrays;

public class FindPrimeNumbers {
    public static void main(String[] args) {
        int n = 30;

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                prime[i] = true;
                for (int j = 2; j * i < n; j++) {
                    prime[j * i] = false;
                }
            }
        }
        for (int i = 0; i < prime.length; i++) {
            System.out.println("for i +"+i+" " + prime[i]);
        }
    }

}
