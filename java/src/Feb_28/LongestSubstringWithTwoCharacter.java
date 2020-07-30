package Feb_28;

import java.util.HashMap;

public class LongestSubstringWithTwoCharacter {
    public static void main(String[] args) {
        String s = "abcbbbbcccbdddadacb";
        int result = getlongestfor2Char(s);
        System.out.println(result);

    }

    private static int getlongestfor2Char(String s) {
        System.out.println("bcbbbbcccb".length());
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (!map.containsKey(r))
                map.put(r, 1);
            else
                map.put(r, map.get(r) + 1);

            if (map.size() <= 2) {
                result = Math.max(result, right - left + 1);
            } else {
                while (map.size() > 2) {
                    char cc=s.charAt(left);
                    if (map.get(cc) == 1)
                        map.remove(cc);
                    else
                        map.put(cc, map.get(cc) - 1);


                    left++;
                }
            }
        }
        return result;
    }
}
