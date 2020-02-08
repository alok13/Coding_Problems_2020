package Round2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.techiedelight.com/find-subarrays-given-sum-array/
public class AllSubarrraysOfGivenSum {
    public static void main(String[] args) {
        int arr[] = {3, 4, -7, 1, 3, 3, 1, -4};
        int target = 7;
        List<List<String>> result = getResult(arr, target);
    }

    private static List<List<String>> getResult(int[] arr, int target) {
        int[] aux = new int[arr.length];
        int sum = 0;
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            int diff=target-sum;
            if (sumMap.containsKey(target - sum)) {
                List<Integer> list = sumMap.get(target - sum);
                for (int l : list) {
                    System.out.println(arr[l+1] + " " + arr[i]);
                }
            }
            if (sumMap.containsKey(sum)) {
                List<Integer> list = sumMap.get(sum);
                list.add(i);
                sumMap.put(sum, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                sumMap.put(sum, list);
            }
        }
        return null;
    }
}
