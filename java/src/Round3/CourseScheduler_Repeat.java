package Round3;

import java.util.*;

public class CourseScheduler_Repeat {

    public static void main(String[] args) {
        int n = 4;
        int arr[][] = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        //int arr[][] = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        boolean possible = getResult(arr, n);
        System.out.println(possible);
    }

    private static boolean getResult(int[][] preReq, int numCourses) {
        int[] inDegrees = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        //Create
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        // Populate degree
        for(int i = 0; i < preReq.length; i++) {
            inDegrees[preReq[i][1]]++;
            graph[preReq[i][0]].add(preReq[i][1]);
        }

        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int currentNum = queue.poll();
            for (int i = 0; i < graph[currentNum].size(); i++) {
                int curr = (int) graph[currentNum].get(i);
                inDegrees[curr]--;
                if (inDegrees[curr] == 0) {
                    queue.add(curr);
                    count++;
                }
            }
        }

        return (count == numCourses);

    }


}
