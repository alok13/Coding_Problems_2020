package Apr_26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PraacticeMonday {
    public static void main(String[] args) {
        String s = "catsandog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        boolean we = wordBreak(s, wordDict);
    }

    private static boolean wordBreak(String s, String[] wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> set = new HashSet<>();
        for (String ss : wordDict)
            set.add(ss);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
