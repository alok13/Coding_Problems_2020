package Mar_21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NumberOfPalindrome {
    public static void main(String[] args) {
        String str = "abac";
        List<String> result = getPalindromes(str);
        System.out.println(result);

    }

    private static List<String> getPalindromes(String str) {
        List<String> result = new ArrayList<>();
        List<List<String>> end = new ArrayList<>();
        findAll(str, result, 0, "");
        return result;
    }

    private static void findAll(String str, List<String> result, int index, String s) {
        if (isPalindrome(s)) {
            result.add(s);
        }
        for (int i = index; i < str.length(); i++) {
            findAll(str, result, index + 1, s + str.charAt(i));
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            else {
                i++;
                j--;
            }

        }
        return true;
    }
}


