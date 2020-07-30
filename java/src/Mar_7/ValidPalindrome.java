package Mar_7;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "aaaaaa";
        boolean result = isValid(s);
        System.out.println(result);
    }

    private static boolean isValid(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
            } else {
                start++;
                end--;
            }
        }
        return true;


    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}


  