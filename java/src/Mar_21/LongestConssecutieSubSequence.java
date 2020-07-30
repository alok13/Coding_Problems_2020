package Mar_21;

import java.util.HashSet;
import java.util.Set;

public class LongestConssecutieSubSequence {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 100, 200};
        int result = getConsecutive(arr);
        System.out.println(result);
    }

    private static int getConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                int start = 1;
                int num = arr[i];
                while (set.contains(num+1)) {
                    start++;
                    num = num + 1;
                }
                count = Math.max(count, start);
            }

        }
        return count;
    }
}


