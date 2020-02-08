package Round1;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/word-break/
public class WordBreak {
    public static void main(String[] args) {
        String word = "leetcode";
        String[] wordDict = {"leet", "code"};
        boolean result = getResult(word, wordDict);
        System.out.println(result);

    }

    private static boolean getResult(String word, String[] wordDict) {

        HashSet<String> wordSet = new HashSet<>(Arrays.asList(wordDict));
        boolean f[] = new boolean[word.length() + 1];
        f[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordSet.contains(word.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[word.length()];
    }
}
