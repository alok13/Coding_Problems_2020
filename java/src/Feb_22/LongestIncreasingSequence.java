package Feb_22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int result = getLongestIncreaasing(arr);
        System.out.println(result);
    }

    private static int getLongestIncreaasing(int[] arr) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : arr)
            hashSet.add(i);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!hashSet.contains(arr[i] - 1)) {
                int cunt = 1;
                int num = arr[i];
                while (hashSet.contains(num + 1)) {
                    cunt++;
                    num++;
                }
                count = Math.max(cunt, count);
            }
        }
        return count;

    }

}
