package Mar_7.Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int arr[] = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(arr);
        boolean[] visited = new boolean[arr.length];
        getResult(list, arr, target, tempList, 0, 0, visited);
        System.out.println(list);
    }

    private static void getResult(List<List<Integer>> list, int[] arr, int target, List<Integer> tempList, int sum, int start, boolean[] visited) {
        if (sum == target) {
            list.add(new ArrayList<>(tempList));
        }

        for (int i = start; i < arr.length; i++) {
            if (visited[i] || i != start && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            tempList.add(arr[i]);
            visited[i] = true;
            getResult(list, arr, target, tempList, sum + arr[i], i + 1, visited);
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
