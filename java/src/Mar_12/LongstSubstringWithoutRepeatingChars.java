package Mar_12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongstSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String str = "pwwkew";
        int length = getLongest(str);
        int length1 = getLongest2(str);
        System.out.println(length);
    }

    private static int getLongest(String str) {
        int start = 0;
        int max = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();

        while (end < str.length()) {
            if (!set.contains(str.charAt(end))) {
                set.add(str.charAt(end));
                end++;
                max = Math.max(max, set.size());
            } else {
                set.remove(str.charAt(start));
                start++;
            }
        }

        return max;

    }

    private static int getLongest2(String str) {
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                start = Math.max(start, map.get(str.charAt(i)));
            }
            max = Math.max(max, i - start + 1);
            map.put(str.charAt(i), i + 1);
        }
        return max;
    }
}
