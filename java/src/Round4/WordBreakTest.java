package Round4;

import java.util.*;

public class WordBreakTest {
    public static void main(String[] args) {
        String str = "ilikeicecreamandmango";
        String arr[] = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};
        List<String> result = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        result = getStrings(str, arr);
        System.out.println(getStringsPresent(str, arr));
        System.out.println(list);
        System.out.println(result);
    }

    private static boolean getStringsPresent(String str, String[] arr) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(arr));
        boolean[] pos = new boolean[str.length() + 1];
        pos[0] = true;

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (pos[j] && wordSet.contains(str.substring(j, i))) {
                    pos[i] = true;
                    break;
                }
            }
        }
        return pos[str.length()];
    }

    private static ArrayList<String> getStrings(String str, String[] arr) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(arr));
        ArrayList<String>[] pos = new ArrayList[str.length() + 1];
        pos[0] = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (pos[i] != null) {
                for (int j = i + 1; j <= str.length(); j++) {
                    String sub = str.substring(i, j);
                    if (wordSet.contains(sub)) {
                        if (pos[j] != null) {
                            pos[j].add(sub);
                        } else {
                            ArrayList<String> list = new ArrayList<>();
                            list.add(sub);
                            pos[j] = list;
                        }
                    }
                }
            }
        }

        if (pos[str.length()] == null) {
            return new ArrayList<>();
        } else {
            ArrayList<String> result = new ArrayList<>();
            dfs(pos, result, "", str.length());
            return result;
        }

    }

    private static void dfs(ArrayList<String>[] pos, ArrayList<String> result, String s, int length) {
        if (length == 0) {
            result.add(s);
            return;
        }
        for (String str : pos[length]) {
            String combined = str + " " + s;
            dfs(pos, result, combined, length - str.length());
        }
    }
}
