package Mar_12;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindownSubstring {
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String target = "ABC";

        String result = getString(str, target);
    }

    private static String getString(String str, String target) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int left = 0;
        int minlength = str.length() + 1;
        int minLeft = 0;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char r = str.charAt(i);
            if (map.containsKey(r)) {
                if (map.get(r) > 0)
                    count++;
                map.put(r, map.get(r) - 1);
            }

            while (count == target.length()) {
                if (i - left + 1 < minlength) {
                    minLeft = left;
                    minlength = i - left + 1;
                }
                char l = str.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                    if (map.get(l) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return "";
    }
}
