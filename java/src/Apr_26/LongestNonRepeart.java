package Apr_26;

import java.util.HashSet;

public class LongestNonRepeart {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int llength = getLongest(str);
        System.out.println(llength);
    }

    private static int getLongest(String str) {
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            while (set.contains(c)) {
                set.remove(str.charAt(start));
                start++;
            }
            set.add(c);
            count = Math.max(count, set.size());
        }
        return count;
    }
}
