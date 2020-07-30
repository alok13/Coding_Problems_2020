package Mar_7.Revision;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithRepeatingChar {
    public static void main(String[] args) {
        String s = "abcdadasbcde";

        int result = getResult(s);
        System.out.println(result);
    }

    private static int getResult(String s) {
        int count = 0;
        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();
        while (left <= right && right < s.length()) {
            count = Math.max(count, right - left + 1);
            if (set.contains(s.charAt(right))) {
                left++;
            } else {
                set.add(s.charAt(right));
            }
            right++;
        }
        return count;
    }
}
