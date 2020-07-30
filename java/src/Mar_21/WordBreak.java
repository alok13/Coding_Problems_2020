package Mar_21;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String str = "leetcode";
        String[] wordDict = {"leet", "code"};
        boolean contains = wordSerach(str, wordDict);
        System.out.println(contains);

        String s = "catsanddog";
        String[] wordDict1 = {"cat", "cats", "and", "sand", "dog"};
        List<String> result = wordSearch2(s, wordDict1);
        System.out.println(result);
    }

    private static List<String> wordSearch2(String s, String[] wordDict) {
        Set<String> set = new HashSet<>(Arrays.asList(wordDict));
        ArrayList[] graph = new ArrayList[s.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i))) {
                    if (graph[i] == null)
                        graph[i] = new ArrayList();
                    graph[i].add(s.substring(j, i));
                }
            }
        }
        List<String> result = new ArrayList<>();
        dfs(graph, graph.length - 1, "", result);
        return result;
    }

    private static void dfs(ArrayList[] graph, int index, String currentList, List<String> result) {
        if (index <= 0) {
            result.add(currentList);
            return;
        }

        List<String> list = graph[index];
        for (String s : list) {
           // currentList = currentList + " " + s;
            dfs(graph, index - s.length(), currentList + " " + s, result);
        }
    }

    private static boolean wordSerach(String str, String[] wordDict) {
        Set<String> set = new HashSet<>(Arrays.asList(wordDict));
        boolean dp[] = new boolean[str.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(str.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[str.length()];
    }
}
