package Feb_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetCombination {
    public static void main(String[] args) {
        //int[] arr = {2, 3, 6, 7};
        int[] arr = {10,1,2,7,6,1,5};
        int sum = 8;
       // getSumCombo(arr, sum);
        combinationSum2(arr,sum);
    }

    private static void getSumCombo(int[] arr, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        //searchAll(list, arr, new ArrayList<>(), sum, 0);
        //getAllSubSets(list, arr, new ArrayList<>(), sum, 0);
        Arrays.sort(arr);
        //getAllSubSetsWithoutDuplicate(list, arr, new ArrayList<>(), sum, 0);
        //permutationWithOutDuplicate(list, arr, new ArrayList<>());
        boolean used[] = new boolean[arr.length];
        permutationWithDuplicate(list, arr, new ArrayList<>(), used);
        System.out.println(list);
    }

    //when a number has the same value with its previous, we can use this number only if his previous is used
    //Sorting is important in this one.
    private static void permutationWithDuplicate(List<List<Integer>> list, int[] arr, ArrayList<Integer> temp, boolean[] used) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        //always start from start not 0
        for (int i = 0; i < arr.length; i++) {
            //when a number has the same value with its previous, we can use this number only if his previous is used
            if (used[i] || i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;
            temp.add(arr[i]);
            used[i] = true;
            permutationWithDuplicate(list, arr, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    private static void permutationWithOutDuplicate(List<List<Integer>> list, int[] arr, ArrayList<Integer> temp) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        //always start from start not 0
        for (int i = 0; i < arr.length; i++) {
            if (temp.contains(arr[i])) continue;
            temp.add(arr[i]);
            permutationWithOutDuplicate(list, arr, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private static void getAllSubSetsWithoutDuplicate(List<List<Integer>> list, int[] arr, ArrayList<Integer> temp, int target, int start) {
        list.add(new ArrayList<>(temp));
        //always start from start not 0
        for (int i = start; i < arr.length; i++) {
            //Sorting is important due to this conditions
            if (i > start && arr[i - 1] == arr[i]) continue;
            temp.add(arr[i]);
            getAllSubSetsWithoutDuplicate(list, arr, temp, target - arr[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    //can be done without sorting and target is not necessary
    private static void getAllSubSets(List<List<Integer>> list, int[] arr, ArrayList<Integer> temp, int target, int start) {
        list.add(new ArrayList<>(temp));
        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            getAllSubSets(list, arr, temp, target - arr[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    // Find combination of sums where duplicates are allowed/ repetition of number is allowed.
    //Every time you have N choice (since you can use number repeatedly), and you can choose at most target times
    // (actually it's smaller than target),
    // so we can assume the worst-case time complexity is O(N^target)
    private static void searchAll(List<List<Integer>> list, int[] arr, ArrayList<Integer> temp, int target, int start) {
        if (target == 0) {
            //Remember to copy in this fashion
            list.add(new ArrayList<>(temp));
            return;
        } else if (target < 0)
            return;

        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            searchAll(list, arr, temp, target - arr[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    //Return all possible palindrome partitioning of s.
    //Time complexity: O(n*(2^n))
    //For a string with length n, there will be (n - 1) intervals between chars.
    //For every interval, we can cut it or not cut it, so there will be 2^(n - 1) ways to partition the string.
    //For every partition way, we need to check if it is palindrome, which is O(n).
    //So the time complexity is O(n*(2^n))

    public void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
        if (start == s.length())
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }


    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack1(list, new ArrayList<>(), nums, target, 0);
        System.out.println(list);
        return list;

    }

    private static void backtrack1(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack1(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
