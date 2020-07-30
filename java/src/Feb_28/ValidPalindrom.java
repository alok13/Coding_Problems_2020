package Feb_28;

public class ValidPalindrom {
    public static void main(String[] args) {
        String s = "ebcbbececabbacecbbcbe";
        boolean result = validPalindrome(s);
        System.out.println(result);

        String test = " alok is ffucking aweful? test. ";
        String myChar = test.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(myChar);

    }

    public static boolean validPalindrome(String s) {
        if (s == null || s.isEmpty())
            return false;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else
                return false;
        }
        return true;
    }

}
