package Round4;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        // String[] words = {"caa", "aaa", "aab"};
        String[] words = {"wrt", "wrf", "er", "est", "rftt"};
        printOrder(words);
    }

    private static void printOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        //Basic setup
        for (int i = 0; i < words.length; i++)
            for (int j = 0; j < words[i].length(); j++)
                graph.putIfAbsent(words[i].charAt(j), new HashSet<>());


        //Graph setup
        int[] inDegree = new int[26];
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    if (graph.containsKey(words[i].charAt(j))) {
                        Set<Character> set = graph.get(words[i].charAt(j));
                        char c = words[i + 1].charAt(j);
                        if (set.add(c))
                            inDegree[c - 'a']++;
                        graph.put(words[i].charAt(j), set);

                    }
                }
            }
        }

        // Execution and putting 0 indegree

        Queue<Character> queue = new LinkedList<>();
        for (Character c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0)
                queue.add(c);
        }

        while (!queue.isEmpty()) {
            char current = queue.poll();
            System.out.println(current);
            Set<Character> currentSet = graph.get(current);
            for (char setChar : currentSet) {
                inDegree[setChar - 'a']--;
                if (inDegree[setChar - 'a'] == 0) {
                    queue.add(setChar);
                }
            }
        }
        return;
    }
}


