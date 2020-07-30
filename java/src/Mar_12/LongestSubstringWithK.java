package Mar_12;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithK {
    public static void main(String[] args) {
        String str = "abcadcacacaca";
        int K = 3;

        String result = getString(str, K);
        System.out.println(result);
    }

    private static String getString(String str, int k) {
        int start = 0;
        int max = 0;
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() > k) {
                while(map.size()>k){
                    int count = map.get(str.charAt(start));
                    if (count == 1)
                        map.remove(str.charAt(start));
                    else {
                        map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
                    }
                    start++;
                }


            } else {
                if (i - start + 1 > max) {
                    max = Math.max(max, i - start);
                    result = str.substring(start, i);
                }
            }

        }
        return result;
    }
}
