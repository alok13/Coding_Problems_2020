package June_21;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Afternoon {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2};
        int arr1[] = {1, 2, 3};
//        System.out.println(subset(arr));
//        System.out.println(subsetWithoutDuplicate(arr));
//        System.out.println(getSumCombination(arr, 4));
//        System.out.println(getPermutation(arr1));
//        System.out.println(getPermutationWithRep(arr));

        int[] money = {1, 4, 5, 7, 6, 3, 2, 9};
        int result = getMaxFromTwo(money);
        //System.out.println(result);

        int pro[] = {2, 3, 4, 5};
        int[] resu = prodcutExceptSelf(pro);
        for (int i : resu)
            System.out.print(i + " ");
    }

    private static int[] prodcutExceptSelf(int[] pro) {
        int[] result = new int[pro.length];
        result[0] = 1;
        for (int i = 1; i < pro.length; i++) {
            result[i] = result[i - 1] * pro[i - 1];
        }
        int right = 1;
        for (int i = pro.length - 2; i >= 0; i--) {
            result[i] = right * result[i];
            right = right * pro[i];
        }
        return result;
    }

    private static int getMaxFromTwo(int[] money) {
        int left[] = new int[money.length];
        int right[] = new int[money.length];
        int min = money[0];
        for (int i = 1; i < money.length; i++) {
            min = Math.min(min, money[i]);
            left[i] = Math.max(left[i - 1], money[i] - min);
        }
        int max = money[money.length - 1];
        for (int i = money.length - 2; i >= 0; i--) {
            max = Math.max(max, money[i]);
            right[i] = Math.max(right[i + 1], max - money[i]);
        }

        int maxSum = 0;
        for (int i = 0; i < money.length; i++) {
            maxSum = Math.max(maxSum, left[i] + right[i]);
        }
        return maxSum;
    }

    private static List<List<Integer>> getPermutationWithRep(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        boolean visited[] = new boolean[arr.length];
        Arrays.sort(arr);
        permutationWithReps(result, arr, new ArrayList<>(), visited);
        return result;
    }

    private static void permutationWithReps(List<List<Integer>> result, int[] arr, ArrayList<Integer> list, boolean[] visited) {
        if (list.size() == arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || i > 0 && arr[i] == arr[i] - 1 && !visited[i]) continue;
            visited[i] = true;
            list.add(arr[i]);
            permutationWithReps(result, arr, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> getPermutation(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        permutationWithOutDuplicate(result, arr, new ArrayList<>());
        return result;
    }

    private static void permutationWithOutDuplicate(List<List<Integer>> list, int[] arr, ArrayList<Integer> temp) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        //always start 0 in case of permutation
        for (int i = 0; i < arr.length; i++) {
            if (temp.contains(arr[i])) continue;
            temp.add(arr[i]);
            permutationWithOutDuplicate(list, arr, temp);
            temp.remove(temp.size() - 1);
        }
    }


    private static List<List<Integer>> getSumCombination(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getAllCombo(result, 0, new ArrayList<>(), arr, 0, target);
        return result;
    }

    private static void getAllCombo(List<List<Integer>> result, int index, ArrayList<Integer> list, int[] arr, int sum, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (sum > target)
            return;

        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            getAllCombo(result, i + 1, list, arr, sum + arr[i], target);
            list.remove(list.size() - 1);
        }
    }

    private static List<List<Integer>> subsetWithoutDuplicate(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        getAllSubsetNoDup(result, 0, new ArrayList<Integer>(), arr);
        return result;
    }

    private static void getAllSubsetNoDup(List<List<Integer>> result, int index, ArrayList<Integer> list, int[] arr) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i - 1] == arr[i]) continue;
            list.add(arr[i]);
            getAllSubset(result, i + 1, list, arr);
            list.remove(list.size() - 1);
        }
    }

    private static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        getAllSubset(result, 0, new ArrayList<Integer>(), arr);
        return result;
    }

    private static void getAllSubset(List<List<Integer>> result, int index, ArrayList<Integer> list, int[] arr) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            getAllSubset(result, i + 1, list, arr);
            list.remove(list.size() - 1);
        }
    }
}
