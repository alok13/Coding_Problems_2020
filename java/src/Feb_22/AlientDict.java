package Feb_22;

import java.util.*;

public class AlientDict {
    public static void main(String[] args) {
        String[] arr = {"wrt", "wrf", "er", "ett", "rftt"};
        String result = getOrder(arr);
        System.out.println(result);
    }
    private static String getOrder(String[] arr) {
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] inDegree = new int[26];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < Math.min(arr[i].length(), arr[i + 1].length()); j++) {
                addInMap(arr[i].charAt(j), arr[i + 1].charAt(j), map, inDegree);
            }
        }
        //Queue setup
        Queue<Character> queue = new LinkedList<>();
        for (char c : map.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.add(c);
            }

        }

        String result = "";
        //Now traversal
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (inDegree[c - 'a'] == 0)
                result = result + c;
            Set<Character> list = map.get(c);
            for (char newChar : list) {
                queue.add(newChar);
                inDegree[newChar - 'a']--;
            }
        }

        return result;
    }

    private static void addInMap(char charAt, char charAt1, Map<Character, Set<Character>> map, int[] inDegree) {
        map.putIfAbsent(charAt, new HashSet<>());
        if (charAt != charAt1) {
            map.get(charAt).add(charAt1);
            inDegree[charAt1 - 'a']++;
        }
    }
}
