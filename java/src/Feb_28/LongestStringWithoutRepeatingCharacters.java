package Feb_28;

import java.util.HashSet;

public class LongestStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "bbbbbbb";
        int result = getString(str);
        System.out.println(result);
    }

    private static int getString(String str) {
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c)) {
                start++;
            } else {
                set.add(c);
            }
            length = Math.max(length, i - start + 1);
        }
        return length;
    }
}
