package Mar_31;

import java.util.*;

public class BiPartiteGraph {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        boolean result = isBipartite(arr);
        boolean result1 = isBipartite2(arr);
        System.out.println(result);
    }

    private static boolean isBipartite2(int[][] graph) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            map.putIfAbsent(graph[i][0], new HashSet<Integer>());
            map.putIfAbsent(graph[i][1], new HashSet<Integer>());
            map.get(graph[i][0]).add(graph[i][1]);
            map.get(graph[i][1]).add(graph[i][0]);
        }
        int[] colors = new int[map.size()];
        for (int c : map.keySet()) {
            if (colors[c] == 0 && !dfs(graph, colors, 1, map, c))
                return false;
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int[] colors, int color, HashMap<Integer, HashSet<Integer>> map, int index) {
        if (colors[index] != 0)
            return color == colors[index];

        colors[index] = color;

        for (int c : map.get(index)) {
            if (!dfs(graph, colors, -color, map, index))
                return false;
        }
        return true;
    }

    public static boolean isBipartite(int[][] g) {
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; i++)
            if (colors[i] == 0 && !validColor(g, colors, 1, i))
                return false;
        return true;
    }

    static boolean validColor(int[][] g, int[] colors, int color, int node) {
        if (colors[node] != 0)
            return colors[node] == color;
        colors[node] = color;
        for (int adjacent : g[node])
            if (!validColor(g, colors, -color, adjacent))
                return false;
        return true;
    }
}


