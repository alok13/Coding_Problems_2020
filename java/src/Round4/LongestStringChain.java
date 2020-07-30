package Round4;

import java.util.*;

//https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain {
    public static void main(String[] args) {
        String input[] = {"a", "b", "ba", "bca", "bda", "bdca"};
        String input1[] = {"ddgpj", "oopwqq", "ooq", "oopq", "iwdkeoqqtd", "iwdkeoqqt", "oopwq", "t", "wdoqqt", "vcw", "ddgpjy", "ddpj", "njpci", "njci", "ft", "q", "wdkeoqqt", "dqq", "qq", "ni", "eihk", "ebiihzke", "eihzke", "eik", "eiihzke", "dqqt", "eihzk", "vw", "ddp", "oq", "wdeoqqt", "nci", "doqqt", "vft"};
        int result = getLongestChain(input1);
        int result1 = getLongestChainDP(input1);
        System.out.println(result1);
    }

    private static int getLongestChainDP(String[] input) {
        Arrays.sort(input, Comparator.comparingInt(String::length));
        int res = 0;
        Map<String, Integer> cache = new HashMap<>();
        for (String word : input) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, cache.getOrDefault(prev, 0) + 1);
            }
            cache.put(word, best);
            res = Math.max(best, res);
        }
        return res;
    }

    private static int getLongestChain(String[] input) {
        if (input == null || input.length == 0)
            return 0;
        Arrays.sort(input, Comparator.comparingInt(String::length));

        int count = 0;
        for (int i = 0; i < input.length; i++) {

            String largest = findLongest(input[i], input);
            if (largest.length() - input[i].length() > count) {
                count = largest.length() - input[i].length();
            }

        }
        return count + 1;
    }

    private static String findLongest(String str, String[] input) {
        Set<String> set = new HashSet<>(Arrays.asList(input));
        String newStr = "";
        for (int i = 0; i <= str.length() + 1; i++) {
            for (char c = 'a'; c <= 'z'; c++) {

                if (i == 0) {
                    newStr = c + str;
                } else if (i == str.length() + 1) {
                    newStr = str + c;
                } else {
                    newStr = str.substring(0, i) + c + str.substring(i);
                }
                if (set.contains(newStr)) {
                    return findLongest(newStr, input);
                }
            }
        }
        return str;
    }
}
