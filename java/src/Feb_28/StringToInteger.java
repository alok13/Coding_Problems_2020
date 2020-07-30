package Feb_28;

//https://leetcode.com/problems/string-to-integer-atoi/
public class StringToInteger {
    public static void main(String[] args) {
        //String s = "      -42 with wrds";
        System.out.println(Integer.MIN_VALUE);
        String s = "-91283472332";
        s = s.trim();
        String arr[] = s.split(" ");
        int v = 0;
        if (isFirstNumber(arr[0])) {
            long v1 = (Long.valueOf(arr[0]));
            if (v1 < 0)
                v = (int) Math.max(v1, Integer.MIN_VALUE);
            else
                v = (int) Math.min(v1, Integer.MAX_VALUE);
            //v=Integer.valueOf(arr[0]);
        }
        System.out.println(v);
    }

    private static boolean isFirstNumber(String s) {
        char c = s.charAt(0);
        if (Character.isDigit(c))
            return true;
        if (c == '-' && s.length() > 1 && Character.isDigit(s.charAt(1)))
            return true;
        return false;
    }
}
