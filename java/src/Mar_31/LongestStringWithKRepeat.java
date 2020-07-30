package Mar_31;

import java.util.Arrays;

//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestStringWithKRepeat {
    public static void main(String[] args) {
        String test = "cababab";
        int result = longestSubstring(test, 2);
        int result1 = longestSubstring2(test, 2);
        System.out.println(result1);
        System.out.println(result);
    }

    public static int longestSubstring2(String s, int k) {
        int d = 0;

        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
            d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));

        return d;
    }

    private static int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] map = new int[26];
        int numUnique = 0; // counter 1
        int atleastK = 0; // counter 2
        int begin = 0, end = 0;
        int d = 0;

        while (end < s.length()) {
            int endIndex = s.charAt(end) - 'a';
            if (map[endIndex] == 0) {
                numUnique++; // increment map[c] after this statement
            }
            map[endIndex]++;
            if (map[endIndex] == k) {
                atleastK++; // inc end after this statement
            }
            end++;
            int beginIndex = s.charAt(begin) - 'a';
            while (numUnique > numUniqueTarget) {
                if (map[beginIndex] == k) {
                    atleastK--; // decrement map[c] after this statement
                }
                map[beginIndex]--;
                if (map[beginIndex] == 0) {
                    numUnique--; // inc begin after this statement
                }
                begin++;
            }

            // if we found a string where the number of unique chars equals our target
            // and all those chars are repeated at least K times then update max
            if (numUnique == numUniqueTarget && numUnique == atleastK)
                d = Math.max(end - begin, d);
        }

        return d;
    }

    private static int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] chars = new int[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i++)
            chars[s.charAt(i) - 'a']++;
        boolean flag = true;
        //check if whole string is valid
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag)
            return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}
