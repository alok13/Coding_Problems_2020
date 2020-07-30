package Mar_7;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String input = "ADOBECODEBANC";
        String target = "ABC";
        String result = getResult(input, target);
        System.out.println(result);
    }

    private static String getResult(String input, String target) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            if (map.containsKey(target.charAt(i))) {
                map.put(target.charAt(i), map.get(target.charAt(i)) + 1);
            } else {
                map.put(target.charAt(i), 1);
            }
        }
        int count = 0;
        int minLeft = 0;
        int minLength = input.length()+1;
        int left=0;
        for (int i = 0; i < input.length(); i++) {
            char r = input.charAt(i);
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);
                if (map.get(r) >= 0) {
                    count++;
                }
            }

            while (count == target.length()) {

                if ( i - left+1 < minLength) {
                    minLength = i - left+1;
                    minLeft=left;
                }
                char l = input.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                    if (map.get(l) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return input.substring(minLeft, minLeft + minLength);
    }
}


