package June_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Paran {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = getParanthesis(n);
        // System.out.println(result);

        String str = "abc";
        List<String> allPerm = geneRateStringPermutation(str);
        System.out.println(allPerm);

    }

    private static List<String> geneRateStringPermutation(String str) {
        List<String> result = new ArrayList<>();
        geneRatePermutation(result, str, "", 0);
        return result;
    }

    private static void geneRatePermutation(List<String> result, String str, String temp, int index) {
        if (str.length() == 0) {
            result.add(temp);
        }
        for (int i = 0; i < str.length(); i++) {
            geneRatePermutation(result, str.substring(0, i) + str.substring(i + 1, str.length()), temp + str.charAt(i), i + 1);
        }
    }

    private static List<List<Integer>> generateNumPerm(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        generateNumberPermutation(result, arr, new ArrayList<Integer>());
        return result;
    }

    private static void generateNumberPermutation(List<List<Integer>> result, int[] arr, ArrayList<Integer> tempList) {
        if (tempList.size() == arr.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (tempList.contains(arr[i])) continue;
            tempList.add(arr[i]);
            generateNumberPermutation(result, arr, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }


    private static String getMinimumSubstringWWindow(String input, String target) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minLeft = 0;
        int start = 0;
        int length = input.length() + 1;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char rightChar = input.charAt(i);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) >= 0)
                    count++;
            }

            while (count == target.length()) {
                if (i - start + 1 < length) {
                    minLeft = start;
                    length = i - start + 1;
                }
                char leftChar = input.charAt(start);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 1)
                        count--;
                }
                start++;
            }
        }
        return length == input.length() ? "" : input.substring(minLeft, minLeft + length + 1);
    }

    private static List<String> getParanthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParanthesis(result, n, 0, 0, "");
        return result;
    }

    private static void generateParanthesis(List<String> result, int n, int start, int end, String str) {
        if (start == end && start == n) {
            result.add(str);
            return;
        }
        if (start < n)
            generateParanthesis(result, n, start + 1, end, str + "(");
        if (end < start)
            generateParanthesis(result, n, start, end + 1, str + ")");
    }


    public void getAllSubSet(int arr[]) {
        List<List<Integer>> result = new ArrayList<>();
        generateAllSubSet(result, arr, 0, new ArrayList<>());
    }

    private void generateAllSubSet(List<List<Integer>> result, int[] arr, int index, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            generateAllSubSet(result, arr, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> getSubSets(int arr[]) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        Arrays.sort(arr);
        generateUniqueSubset(arr, result, 0, new ArrayList<>(), visited);
        return result;
    }

    private void generateUniqueSubset(int[] arr, List<List<Integer>> result, int index, ArrayList<Integer> temp, boolean[] visited) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i - 1] == arr[i]) continue;
            generateUniqueSubset(arr, result, i + 1, temp, visited);
            temp.remove(temp.size() - 1);
        }
    }


}
