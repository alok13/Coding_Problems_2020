package Round1;//https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/

import java.util.Arrays;

public class SmallestDifferenceBetweenTwoSortedArray {

    public static void main(String[] args) {

        // Input given array A
        int A[] = {1, 2, 11, 5};

        // Input given array B
        int B[] = {4, 12, 19, 23, 127, 235};

        // Call function to
        // print smallest result
        System.out.println(findSmallestDifference(A, B));
    }

    private static int findSmallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        int count = Integer.MAX_VALUE;

        while (i < a.length && j < b.length) {
            int diff = Math.abs(a[i] - b[j]);
            count = Math.min(diff, count);
            if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
        return count;
    }
}
