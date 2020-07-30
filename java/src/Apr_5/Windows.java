package Apr_5;

import java.util.HashMap;

public class Windows {
    public static void main(String[] args) {

    }

    String minimumWindowsSubtring(String target, String pattern) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int count = 0;
        int result = 0;
        for (int i = 0; i < target.length(); i++) {
            char rightChar = target.charAt(i);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                count++;
            }

            while (count == pattern.length()) {
                result = Math.min(result, i - start + 1);
                char leftChar = target.charAt(start);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    count--;
                }
                start++;
            }
        }
        return null;
    }
}
