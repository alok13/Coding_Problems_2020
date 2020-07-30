package Mar_7;

import java.util.ArrayList;

public class FriendsOfCircle {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int result = getCircles(arr);
        System.out.println(result);
    }

    private static int getCircles(int[][] arr) {
        ArrayList<Integer>[] graph = new ArrayList[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    if (graph[i] == null) {
                        ArrayList l = new ArrayList<>();
                        l.add(j);
                        graph[i] = l;
                    } else {
                        graph[i].add(j);

                    }
                }
            }
        }
        int count = 0;
        boolean visited[] = new boolean[arr.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                visited[i]=true;
                dfs(graph[i], visited, i, graph);
                count++;
            }

        }
        return count;
    }

    private static void dfs(ArrayList<Integer> integers, boolean[] visited, int i, ArrayList<Integer>[] graph) {
        for (int k = 0; k < integers.size(); k++) {
            if (!visited[k]) {
                visited[k]=true;
                dfs(graph[i], visited, i, graph);
            }
        }
    }
}
