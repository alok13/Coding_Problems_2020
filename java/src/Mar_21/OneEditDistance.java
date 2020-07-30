package Mar_21;

public class OneEditDistance {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abc";
        boolean isOneDistanceApart = isOneDistance(s1, s2);
        System.out.println(isOneDistanceApart);
    }

    private static boolean isOneDistance(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
            return false;
        if (Math.abs(s1.length() - s2.length()) > 1)
            return false;
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (s1.length() > s2.length())
                    i++;
                else if (s2.length() > s1.length())
                    j++;
                else {
                    i++;
                    j++;
                }
                count++;
                if (count > 1)
                    return false;
            }
        }

        if (i < s1.length() || j < s2.length()) {
            count++;
        }
        return count == 1;
    }
}
