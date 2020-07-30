package Mar_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreesumofArray {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = getNumbers(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> getNumbers(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || (arr[i] != arr[i - 1])) {
                int sum = 0 - arr[i];
                int start = i + 1;
                int end = arr.length - 1;
                while (start < end) {
                    if (arr[start] + arr[end] == sum) {
                        Integer[] curr = {arr[i], arr[start], arr[end]};
                        result.add(Arrays.asList(curr));
                        while (start < end && arr[end] == arr[end - 1]) end--;
                        while (start < end && arr[start] == arr[start + 1]) start++;
                        start++;
                        end--;
                    } else if (arr[start] + arr[end] > sum) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }

        }
        return result;
    }
}
