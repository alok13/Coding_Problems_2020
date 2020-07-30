package Feb_28;

import java.util.HashMap;
import java.util.Map;

public class MinimumWIndowSubstring {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String result = window(S, T);
        System.out.println(result);
    }


    private static String window(String str, String target) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            if (map.containsKey(target.charAt(i))) {
                map.put(target.charAt(i), map.get(target.charAt(i)) + 1);
            } else {
                map.put(target.charAt(i), 1);
            }
        }

        int start = 0;
        int count = 0;
        int minLength = str.length() + 1;
        int minLeft = 0;
        for (int end = 0; end < str.length(); end++) {
            char right = str.charAt(end);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right)>=0)
                    count++;
            }

            while (count == target.length()) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minLeft = start;
                }
                char left = str.charAt(start);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) > 0)
                        count--;
                }
                start++;
            }
        }
        return minLength == str.length() ? "" : str.substring(minLeft, minLeft + minLength);
    }
}
