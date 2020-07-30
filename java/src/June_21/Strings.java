package June_21;

import java.util.HashMap;

public class Strings {
    public static void main(String[] args) {

    }

    private static String minimumWindowSubstring(String str, String target) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int length = str.length() + 1;
        int start = 0;
        int minLeft = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char right = str.charAt(i);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) >= 0)
                    count++;
            }
            while (count == target.length()) {
                if (i - start + 1 < length) {
                    length = i - start + 1;
                    minLeft = start;
                }
                char left = str.charAt(start);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) > 1)
                        count--;
                }
                start++;
            }
        }
        return length == str.length() ? "" : str.substring(minLeft, minLeft + length + 1);

    }
}
