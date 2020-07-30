package CTCI.ArrayStrings;

import java.util.HashSet;
import java.util.Set;

//
//Implement an algorithm to determine if a string has all unique characters. What if you
//       cannot use additional data structures?
public class AllUniqueCharacter {
    public static void main(String[] args) {
        String str = "abcad";
        boolean result = isAllUniue(str);
        boolean resul1 = isAllUniueWithoutDataStructure(str);
        System.out.println(result);
        System.out.println(resul1);
    }

    private static boolean isAllUniueWithoutDataStructure(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i)))
                return false;
        }
        return true;
    }

    private static boolean isAllUniue(String str) {
        Set<Character> hashSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!hashSet.add(str.charAt(i)))
                return false;
        }
        return true;
    }
}

