package Mar_31;

import java.util.HashMap;
import java.util.Map;

public class LongestWithKRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abcadcacacaca";
        int k = 3;
        int result = getString(s, k);
        System.out.println(result);
    }

    private static int getString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() <= k) {
                length = Math.max(i - start, length);
                System.out.println(s.substring(start, i));
            } else {
                while (map.size() > k) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    if (map.get(s.charAt(start)) == 0)
                        map.remove(s.charAt(start));
                    start++;
                }

            }
        }
        return length;
    }
}

