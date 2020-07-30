package Apr_5;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String str = "adddsvsfds";
        String patt = "fds";
        String result = getMinimum(str, patt);
        System.out.println(result);
        String arr[] = {"acd", "dfg", "wyz", "yab", "mop",
                "bdfh", "a", "x", "moqs"};
        System.out.println(groupStrings(arr));
    }

    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> groups = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String encoded = encode(s);
            if (!map.containsKey(encoded)) {
                map.put(encoded, new ArrayList<>());
            }
            map.get(encoded).add(s);
        }
        for (String key : map.keySet()) {
            groups.add(map.get(key));
        }
        return groups;
    }

    private static String encode(String s) {
        if (s.length() == 1) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = s.charAt(i - 1);
            sb.append((first + 26 - second) % 26);
        }
        return sb.toString();
    }

    private static String getMinimum(String str, String patt) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : patt.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int minLeft = 0;
        int length = str.length() - 1;
        int count = 0;
        for (int end = 0; end < str.length(); end++) {
            char right = str.charAt(end);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) >= 0)
                    count++;
            }

            while (count == patt.length()) {
                if (end - start + 1 < length) {
                    minLeft = start;
                    length = Math.min(length, end - start + 1);
                }
                char left = str.charAt(start);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) > 0)
                        count--;
                }
                start++;
            }
        }

        return str.substring(minLeft, minLeft + length);
    }
}
