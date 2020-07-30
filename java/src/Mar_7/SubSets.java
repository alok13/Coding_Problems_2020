package Mar_7;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
        //getAllSubset(list, nums, 0, new ArrayList<>());
        boolean[] visited = new boolean[nums.length];
        getAllPermution(list, nums, 0, new ArrayList<>(), visited);
        System.out.println(list);
    }

    private static void getAllPermution(List<List<Integer>> list, int[] nums, int start, ArrayList<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            temp.add(i);
            visited[i] = true;
            getAllPermution(list, nums, i + 1, temp, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    private static void getAllSubset(List<List<Integer>> list, int[] nums, int start, ArrayList<Integer> temp) {
        list.add(new ArrayList(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            getAllSubset(list, nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
