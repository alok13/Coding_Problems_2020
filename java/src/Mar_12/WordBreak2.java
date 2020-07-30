package Mar_12;

import java.util.*;

public class WordBreak2 {
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};

        List<String> result = getResult(s, wordDict);
        System.out.println(result);
    }

    private static List<String> getResult(String str, String[] wordDict) {
        HashSet<String> set = new HashSet(Arrays.asList(wordDict));
        ArrayList[] graph = new ArrayList[str.length() + 1];


        for (int i = 0; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                String curr = str.substring(j, i);
                if (set.contains(curr)) {
                    if (graph[i] == null) {
                        graph[i] = new ArrayList();
                    }
                    graph[i].add(curr);
                }
            }
        }

        List<String> result = new ArrayList<>();

        if (graph[str.length()] == null)
            return null;
        else {
            dfs(result, graph, str.length(), "");

        }


        return result;
    }

    private static void dfs(List<String> result, ArrayList<String>[] graph, int index, String list) {
        if (index == 0) {
            result.add(list);
            return;
        }

        for (String s : graph[index]) {
            String comb = list + " " + s;
            dfs(result, graph, index - s.length(), list + " " + s);
        }

    }
}
