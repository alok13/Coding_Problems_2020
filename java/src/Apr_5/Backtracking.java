package Apr_5;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(getPermutations(arr));
        int arr1[] = {1, 2, 2, 3};
        System.out.println(getPermutationsNonRepeated(arr1));
        System.out.println(getCombinationSum(arr));
    }

    private static List<List<Integer>> getCombinationSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backTrackingCombination(arr, result, 3, 0, 0, new ArrayList<Integer>());
        return result;
    }

    private static void backTrackingCombination(int[] arr, List<List<Integer>> result, int target, int index, int currentSum, ArrayList<Integer> list) {
        if (currentSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (currentSum > target)
            return;
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            backTrackingCombination(arr, result, target, i+1, currentSum + arr[i], list);
            list.remove(list.size() - 1);
        }
    }


    private static List<List<Integer>> getPermutationsNonRepeated(int[] arr1) {
        List<List<Integer>> result = new ArrayList<>();
        boolean visited[] = new boolean[arr1.length];
        Arrays.sort(arr1);
        backTrackingPermutation(arr1, result, visited, new ArrayList<>());
        return result;
    }

    private static void backTrackingPermutation(int[] arr, List<List<Integer>> result, boolean[] visited, ArrayList<Integer> list) {
        if (arr.length == list.size()) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || i > 0 && arr[i - 1] == arr[i] && !visited[i - 1])
                continue;
            list.add(arr[i]);
            visited[i] = true;
            backTrackingPermutation(arr, result, visited, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }


    private static List<List<Integer>> getPermutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(arr, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private static void backTracking(int[] arr, List<List<Integer>> result, ArrayList<Integer> list, int index) {
        if (list.size() == arr.length) {
            result.add(new ArrayList<>(list));
        }

        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) continue;
            list.add(arr[i]);
            backTracking(arr, result, list, index);
            list.remove(list.size() - 1);
        }
    }


}
