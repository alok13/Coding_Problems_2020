package Round3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNonRepeat {
    public static void main(String[] args) {
        String str = "ababsd";
        //int result = getStr(str);
        int result = getStr2(str);
        System.out.println(result);
    }

    private static int getStr2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    private static int getStr(String str) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < str.length() && j < str.length()) {
            char c = str.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
            } else {
                i = i + 1;
                set.remove(str.charAt(j));
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}
