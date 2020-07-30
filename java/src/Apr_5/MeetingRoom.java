package Apr_5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class MeetingRoom {

    public static void main(String[] args) {
//        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
//        boolean result = isMeetingPossible(arr);
//
//        System.out.println(result);
//        int result1 = numberOfRoom(arr);
//        System.out.println(result1);


        int[] arr1 = {3, 4, -1, 1};
        int rsult1 = getMissingPositve(arr1);
        int rsult2 = getMissingPositve1(arr1);
        System.out.println(rsult2);
    }

    private static int getMissingPositve1(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] <= 0 || arr[i] > length)
                arr[i] = length + 1;
        }


        for (int i = 0; i < length; i++) {
            int num = Math.abs(arr[i]);
            if (num > length)
                continue;
            int index = num - 1;
            if (arr[index] > 0)
                arr[index] = -1 * arr[index];
        }
        for (int i = 0; i < length; i++) {
            if (arr[i] >= 0)
                return i + 1;
        }
        return length + 1;
    }

    private static int getMissingPositve(int[] arr) {
        int ans = 0;
        int length = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > length || arr[i] <= 0)
                arr[i] = length + 1;
        }

        for (int i = 0; i < arr.length; i++) {
            int num = Math.abs(arr[i]);
            if (num > length)
                continue;
            ;
            int index = num - 1;
            if (arr[index] > 0) {
                arr[index] = -1 * arr[index];
            }
        }


        for (int i = 0; i < length; i++) {
            if (arr[i] > 0)
                ans = i + 1;
        }
        return ans;
    }

    private static int numberOfRoom(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.add(arr[0][1]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < queue.peek())
                queue.poll();
            queue.offer(arr[i][1]);
        }
        return queue.size();
    }

    private static boolean isMeetingPossible(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i][1] < arr[i + 1][0])
                return false;
        }
        return true;
    }


    boolean frogJump(int arr[]) {
        HashSet<Integer> jumpPosition = new HashSet<>();
        for (int i : arr)
            jumpPosition.add(arr[i]);

        Stack<Integer> stone = new Stack<>();
        Stack<Integer> jump = new Stack<>();

        stone.add(arr[0]);
        jump.add(arr[0]);

        while (!stone.isEmpty()) {
            int currentStone = stone.pop();
            int currentDistance = jump.pop();

            for (int i = currentDistance - 1; i <= currentDistance + 1; i++) {
                if (i <= 0)
                    continue;
                int nextPosition = currentDistance + i;
                if (currentDistance == arr[arr.length - 1])
                    return true;
                if (jumpPosition.contains(nextPosition)) {
                    stone.add(nextPosition);
                    jump.add(i);
                }
            }
        }
        return false;

    }
}
