package CTCI.ArrayStrings;
//There are three types of edits that can be performed on strings: insert a character,
//remove a character, or replace a character. Given two strings, write a function to check if they are
//one edit (or zero edits) away.
//EXAMPLE
//pale, ple -> true
//pales, pale -> true
//pale, bale -> true
//pale, bake -> false

public class OneAway {
    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "bake";
        boolean result = isOneEditAway(str1, str2);
        System.out.println(result);
    }

    private static boolean isOneEditAway(String str1, String str2) {
        if (str1.equals(str2))
            return true;
        if (Math.abs(str1.length() - str2.length()) > 1)
            return false;

        int length = str1.length() > str2.length() ? str2.length() : str1.length();

        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                String newStr1 = str1.replace(str1.charAt(i), str2.charAt(i));
                if (newStr1.equals(str2))
                    return true;
                String newStr2 = str2.replace(str2.charAt(i), str1.charAt(i));
                if (newStr2.equals(str1))
                    return true;
                if (str1.length() > str2.length()) {
                    StringBuilder sb = new StringBuilder(str1);
                    sb.deleteCharAt(i);
                    str1 = sb.toString();
                    return str1.equals(str2);
                } else {
                    StringBuilder sb = new StringBuilder(str2);
                    sb.deleteCharAt(i);
                    str2 = sb.toString();
                    return str1.equals(str2);
                }
            }

        }
        return true;


    }
}
