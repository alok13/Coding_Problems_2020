package Mar_21;

import java.util.*;

public class TaskScehduler {

    public static void main(String[] args) {
        char[] arr = {'A', 'A', 'A', 'B', 'B', 'B'};
        int N = 2;
        int result = getTasks(arr, N);
        System.out.println(result);
    }

    private static int getTasks(char[] arr, int n) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            charMap.put(arr[i], charMap.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> taskList = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        taskList.addAll(charMap.entrySet());
        int count = 0;
        while (!taskList.isEmpty()) {
            int intervals = n + 1;
            List<Map.Entry<Character, Integer>> excutedTask = new ArrayList<>();
            while (intervals > 0 && !taskList.isEmpty()) {
                Map.Entry<Character, Integer> entry = taskList.poll();
                entry.setValue(entry.getValue() - 1);
                excutedTask.add(entry);
                intervals--;
                count++;
            }
            for (Map.Entry<Character, Integer> e : excutedTask) {
                if (e.getValue() > 0) {
                    taskList.add(e);
                }
            }
            if (taskList.isEmpty())
                break;
            count += intervals;
        }
        return count;
    }
}
