package CTCI.ArrayStrings;

//Assumeyou have a method isSubstring which checks if one word is a substring
//of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
//call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
public class StringRotation {
    public static void main(String[] args) {
        String original = "waterbottle";
        String rotated = "erbottlewat";
        boolean result = isRotated(original, rotated);
        System.out.println(result);
    }

    private static boolean isRotated(String original, String rotated) {
        original = original + original;
        return original.contains(rotated);
    }
}
