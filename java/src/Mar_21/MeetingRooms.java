package Mar_21;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        int result = getMeetingRooms(arr);
        System.out.println(result);
    }

    private static int getMeetingRooms(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] >= queue.peek()[1]) {
                queue.remove();
            }
            queue.add(arr[i]);
        }
        return queue.size();
    }
}
