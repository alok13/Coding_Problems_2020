package Mar_12;

import java.util.*;

public class ThreeSumProblem {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = getNumbers(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> getNumbers(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || (arr[i] != arr[i - 1])) {
                int start = 0 - arr[i];
                int high = arr.length - 1;
                int low = i + 1;
                while (low < high) {
                    if (arr[low] + arr[high] == start) {
                        List<Integer> list = new ArrayList<>();
                        list.add(start);
                        list.add(arr[low]);
                        list.add(arr[high]);

                        result.add(list);
                        while (low < high && arr[high] == arr[high - 1]) high--;
                        while (low < high && arr[low] == arr[low + 1]) low++;

                        low++;
                        high--;
                    } else if (arr[low] + arr[high] < start) low++;
                    else high--;
                }
            }
        }
        return result;
    }
}
