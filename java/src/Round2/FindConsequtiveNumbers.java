package Round2;
//https://www.geeksforgeeks.org/longest-consecutive-subsequence/

import java.util.Arrays;
import java.util.HashSet;

public class FindConsequtiveNumbers {
    public static void main(String[] args) {
        //int[] arr = {1, 9, 3, 4, 10, 2, 11};
        int[] arr = {100,4,200,1,3,2};
        int result = getLength(arr);
        System.out.println(result);
    }


    private static int getLength(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                int j = 1;
                int start = arr[i];
                while (set.contains(start + 1)) {
                    j++;
                    start = start + 1;
                }
                result = Math.max(result, j );

            }
        }
        return result;
    }
}
