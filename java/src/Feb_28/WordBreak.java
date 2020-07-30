package Feb_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String ss = "reere ? adsa we20 / ddsd";
        String actual = ss.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(actual);
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};

        //[
        //  "cats and dog",
        //  "cat sand dog"
        //]
        getWords(s, wordDict);
    }

    private static void getWords(String s, String[] wordDict) {
        List<String> list = Arrays.asList(wordDict);
        ArrayList<String>[] pos = new ArrayList[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (list.contains(s.substring(i, j))) {
                    if (pos[j] == null) {
                        pos[j] = new ArrayList<>();
                    }
                    pos[j].add(s.substring(i, j));
                }
            }
        }

        int start = 0;
        for (int i = pos.length - 1; i >= 0; i--) {
            if (pos[i] != null) {
                start = i;
                break;
            }
        }
        dfs(pos, s.length(), "");

        return;
    }

    private static void dfs(ArrayList<String>[] pos, int i, String result) {
        if (i == 0) {
            System.out.println(result);
            return;
        }
        List<String> res = pos[i];
        for (String s : res) {
            String result1 = s + ":" + result;
            dfs(pos, i - s.length(), result1);
        }
    }


}
