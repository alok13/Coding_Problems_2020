package Round2;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseSchedule2 {
    public static void main(String[] args) {
        int n = 4;
        int arr[][] = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result = getResult(n, arr);
        for (int i : result)
            System.out.println(i);
    }

    private static int[] getResult(int n, int[][] arr) {
        int[] result = new int[arr.length];
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        Map<Integer, Integer> nodeCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeCount.put(i, 0);
        }

        for (int[] num : arr) {
            if (nodeMap.containsKey(num[1])) {
                List<Integer> list = nodeMap.get(num[1]);
                list.add(num[0]);
                nodeMap.put(num[1], list);

            } else {
                List<Integer> list = new ArrayList<>();
                list.add(num[0]);
                nodeMap.put(num[1], list);
            }

            if (nodeCount.containsKey(num[0])) {
                nodeCount.put(num[0], nodeCount.get(num[0]) + 1);
            }

        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : nodeCount.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        int count = 0;
        //int i=0;
        while (!queue.isEmpty() && count < n) {
            int current = queue.poll();
            List<Integer> list = nodeMap.get(current);
            result[count] = current;
            count++;
            if (count == n)
                return result;
            queue.addAll(list);
        }


        return result;
    }

}
