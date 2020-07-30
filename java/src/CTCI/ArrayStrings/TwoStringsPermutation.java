package CTCI.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;

//Given two strings, write a method to decide if one is a permutation of the
//other
public class TwoStringsPermutation {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "bcds";
        boolean result = areStringsPermutated(str1, str2);
        System.out.println(result);
    }

    private static boolean areStringsPermutated(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        char[] c = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        Arrays.sort(c);
        Arrays.sort(c2);

        for (int i = 0; i < c.length; i++) {
            if (c[i] != c2[i])
                return false;
        }
        return true;
    }
}
