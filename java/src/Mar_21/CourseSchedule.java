package Mar_21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        boolean canFinish = getResult(numCourses, prerequisites);
        System.out.println(canFinish);
    }

    private static boolean getResult(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++)
            graph[i] = new ArrayList<Integer>();

        for (int i = 0; i < prerequisites.length; i++) {
            int dependentClass = prerequisites[i][0];
            graph[dependentClass].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int currentClass = queue.poll();
            List<Integer> classes = graph[currentClass];
            for (int j : classes) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    queue.add(j);
                    count++;
                }
            }
        }
        return count == numCourses;

    }
}
