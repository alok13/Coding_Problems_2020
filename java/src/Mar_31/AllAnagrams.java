package Mar_31;

import java.util.ArrayList;
import java.util.List;

public class AllAnagrams {
    public static void main(String[] args) {
        String s = "cbaabcbacd";
        String p = "abc";
        List<Integer> result = getIndex(s, p);
        System.out.println(result);
    }

    private static List<Integer> getIndex(String s, String p) {
        int hash[] = new int[26];

        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i) - 'a']++;
        }
        List<Integer> lsit = new ArrayList<>();
        int start = 0;
        int end = 0;
        int length = s.length();
        int count = p.length();
        while (end < length) {
            if (hash[s.charAt(end)-'a'] >= 1) {
                count--;
            }
            hash[s.charAt(end) - 'a']--;
            end++;
            if (count == 0)
                lsit.add(start);
            if (end - start == p.length()) {
                if (hash[s.charAt(start)-'a'] >= 0)
                    count++;
                hash[s.charAt(start)-'a']++;
                start++;
            }
        }
        return lsit;
    }
}

