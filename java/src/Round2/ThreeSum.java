package Round2;

import java.util.Arrays;
import java.util.HashSet;

public class ThreeSum {
    public static void main(String[] args) {
        Integer A[] = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        int arr_size = A.length;

        find3Numbers(A, arr_size, sum);
        find3NumbersPractice(A, arr_size, sum);
    }

    private static void find3NumbersPractice(Integer[] a, int arr_size, int sum) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(a));

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (set.contains(sum - (a[i] + a[j]))) {
                    System.out.println(a[i] + " " + a[j] + " " + (sum - (a[i] + a[j])));
                    return;
                }
            }
        }
    }

    private static void find3Numbers(Integer[] arr, int arr_size, int sum) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));

        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(sum - (first + arr[j]))) {
                    System.out.println(first + " " + arr[j] + " " + (sum - (first + arr[j])));
                    return;
                }
            }
        }
    }
}
