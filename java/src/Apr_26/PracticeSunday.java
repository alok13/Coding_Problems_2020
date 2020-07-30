package Apr_26;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PracticeSunday {
    public static void main(String[] args) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'a');
        map.put(2, 'b');
        map.put(3, 'c');
        map.put(4, 'd');
        int result = decodeWays(map, "226");
        //System.out.println(result);

        String invalidParanthesis = reMoveInvalidParanthesis("()()(()");
//        System.out.println(invalidParanthesis);
//        String s = "abc";
//        System.out.println(s.substring(1));
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(getLongestSubstringWithKCharacter("ADOBECODEBANC", 2));
//        System.out.println(noRepeatSubString("ADOBECODEBANC"));
        System.out.println(getSubStringAtleastK("ababbc", 2));
        System.out.println(longestSubstring2("ababbc", 2));
    }

    public static int longestSubstring2(String s, int k) {
        int d = 0;

        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
            d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));

        return d;
    }

    private static int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] map = new int[26];
        int numUnique = 0; // counter 1
        int atleastK = 0; // counter 2
        int begin = 0, end = 0;
        int d = 0;

        while (end < s.length()) {
            int endIndex = s.charAt(end) - 'a';
            if (map[endIndex] == 0) {
                numUnique++; // increment map[c] after this statement
            }
            map[endIndex]++;
            if (map[endIndex] == k) {
                atleastK++; // inc end after this statement
            }
            end++;
            int beginIndex = s.charAt(begin) - 'a';
            while (numUnique > numUniqueTarget) {
                if (map[beginIndex] == k) {
                    atleastK--; // decrement map[c] after this statement
                }
                map[beginIndex]--;
                if (map[beginIndex] == 0) {
                    numUnique--; // inc begin after this statement
                }
                begin++;
            }


            // if we found a string where the number of unique chars equals our target
            // and all those chars are repeated at least K times then update max
            if (numUnique == numUniqueTarget && numUnique == atleastK)
                d = Math.max(end - begin, d);
        }

        return d;
    }


    private static int getSubStringAtleastK(String str, int K) {
        int result = 0;
        for (int i = 1; i <= 26; i++) {
            result = Math.max(result, getAtleastK(str, K, i));
        }
        return result;
    }

    private static int getAtleastK(String str, int k, int numUniqueTarget) {

        int[] map = new int[26];
        int end = 0;
        int begin = 0;
        int result = 0;
        int atLeastK = 0;
        int numUnique = 0;
        while (end < str.length()) {
            int endIndex = str.charAt(end) - 'a';
            if (map[endIndex] == 0) {
                numUnique++;
            }
            map[endIndex]++;
            if (map[endIndex] == k) {
                atLeastK++;
            }
            end++;
            int beginIndex = str.charAt(begin) - 'a';
            while (numUnique > numUniqueTarget) {
                if (map[beginIndex] == k) {
                    atLeastK--;
                }
                map[beginIndex]--;
                if (map[beginIndex] == 0)
                    numUnique--;
                begin++;
            }
            if (numUnique == numUniqueTarget && numUnique == atLeastK)
                result = Math.max(result, end - begin);
        }
        return result;
    }

//    private static int noRepeatSubString(String str) {
//
//    }

    private static int getLongestSubstringWithKCharacter(String str, int K) {
        HashMap<Character, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        K = 2;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            if (map.size() <= K) {
                result = Math.max(result, i - left + 1);
            } else
                while (map.size() > K) {
                    char start = str.charAt(left);
                    if (map.get(start) == 1)
                        map.remove(start);
                    else
                        map.put(start, map.get(start) - 1);
                    left++;
                }
        }
        return result;
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int minlength = s.length() + 1;
        int length = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char right = s.charAt(i);
            if (map.containsKey(right)) {
                if (map.get(right) > 0)
                    count++;
                map.put(right, map.get(right) - 1);
            }
            while (count == t.length()) {
                if (minlength > i - left + 1) {
                    minlength = i - left + 1;
                    length = left;
                }
                char start = s.charAt(left);
                if (map.containsKey(start)) {
                    map.put(start, map.get(start) + 1);
                    if (map.get(start) > 0)
                        count--;
                }
                left++;
            }
        }
        return s.substring(length, length + minlength);
    }


    private static String reMoveInvalidParanthesis(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.add(i);
            if (s.charAt(i) == ')')
                if (s.charAt(stack.peek()) == '(')
                    stack.pop();
                else
                    sb.setCharAt(i, '*');
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        return sb.toString().replaceAll("\\*", "");
    }

    private static int decodeWays(Map<Integer, Character> map, String str) {
        if (str == null || str.length() == 0)
            return 0;
        int[] sum = new int[str.length() + 1];
        sum[0] = 1;
        sum[1] = str.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i < sum.length; i++) {
            int first = Integer.valueOf(str.substring((i - 1), i));
            int second = Integer.valueOf(str.substring((i - 2), i));
            if (first >= 1 && first <= 9) {
                sum[i] = sum[i] + sum[i - 1];
            }
            if (second >= 10 && second <= 26) {
                sum[i] = sum[i] + sum[i - 2];
            }
        }
        return sum[sum.length - 1];

    }
}
