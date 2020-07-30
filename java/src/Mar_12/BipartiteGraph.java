package Mar_12;

import java.util.HashMap;
import java.util.HashSet;

public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int N = 5;
        boolean result = getBipartitie(arr, N);
        System.out.println(result);
    }

    private static boolean getBipartitie(int[][] graph, int N) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        int group[] = new int[N + 1];

        for (int i = 0; i < graph.length; i++) {
            map.putIfAbsent(graph[i][0], new HashSet<Integer>());
            map.putIfAbsent(graph[i][1], new HashSet<Integer>());
            map.get(graph[i][0]).add(graph[i][1]);
            map.get(graph[i][1]).add(graph[i][0]);
        }

        for (int i = 1; i <= N; i++) {
            if (group[i] == 0 && !dfs(map, group, 1, i))
                return false;
        }
        return true;
    }

    public static boolean dfs(HashMap<Integer, HashSet<Integer>> map, int[] group, int color, int index) {
        if (group[index] != 0) {
            return group[index] == color;
        }

        group[index] = color;
        if (map.get(index) == null)
            return true;
        for (int i : map.get(index)) {
            if (!dfs(map, group, -color, i))
                return false;
        }
        return true;
    }
}
