package CTCI.ArrayStrings;
//Given a string, write a function to check if it is a permutation of a palindrome.
//A palindrome is a word or phrase that is the same forwards and backwards. A permutation
//is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
//EXAMPLE
//Input: Tact Coa
//Output: True (permutations: "taco cat", "atco eta", etc.)

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public static void main(String[] args) {
        String test = "tact coad";
        boolean result = isPlaindromePermutatiion(test);
        boolean result2 = isPlaindromePermutatiionWithMap(test);
        System.out.println(result);
        System.out.println(result2);
    }

    private static boolean isPlaindromePermutatiionWithMap(String test) {
        test = test.replace(" ", "").toLowerCase();
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < test.length(); i++) {
            charMap.put(test.charAt(i), charMap.getOrDefault(test.charAt(i), 0) + 1);
        }
        int odd_count = 0;
        for (int i : charMap.values()) {
            if (odd_count > 1)
                return false;
            if (i % 2 != 0)
                odd_count++;
        }
        return odd_count < 2;

    }

    private static boolean isPlaindromePermutatiion(String test) {
        test = test.replace(" ", "").toLowerCase();
        int[] arr = new int[26];
        for (int i = 0; i < test.length(); i++) {
            arr[test.charAt(i) - 'a']++;
        }
        int odd_count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                odd_count++;
        }
        return odd_count < 2;
    }
}
