package Mar_26;

public class AllPalindrome {
    public static void main(String[] args) {
        String str1 = "abecbea";
        boolean result = isAlmostAPalindrome(str1);
        System.out.println(result);
        String result1 = shortestPalindrome(str1);
        System.out.println(result1);

    }

    private static String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }
        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    private static boolean isAlmostAPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return isPalindrome(str, start + 1, end) || isPalindrome(str, start, end - 1);
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}


