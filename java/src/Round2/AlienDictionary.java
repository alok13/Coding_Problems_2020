package Round2;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] arr = {"baa", "abcd", "abca", "cab", "cad"};
        List<Character> result = getOrder(arr);
        System.out.println(result);
    }

    private static List<Character> getOrder(String[] arr) {
        Map<Character, Character> result = new HashMap<>();

        return null;
    }
}

class Graph {
    LinkedList<Integer>[] adjacencyList;
    Graph(int n) {
        adjacencyList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }
    int getNumberofVertices() {
        return adjacencyList.length;
    }
    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }
    void sortGraph() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[getNumberofVertices()];
        for (int i = 0; i < getNumberofVertices(); i++) {
            if (!visited[i])
                sortUtil(i, visited, stack);
        }
        // Print contents of stack
        while (!stack.isEmpty()) {
            System.out.print((char) ('a' + stack.pop()) + " ");
        }
    }
    private void sortUtil(int i, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        for (int num : adjacencyList[i]) {
            if (!visited[num]) {
                sortUtil(num, visited, stack);
            }
        }
        stack.push(i);
    }
}
