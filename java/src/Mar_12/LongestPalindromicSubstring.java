package Mar_12;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        String result = getResult(s);
        System.out.println(result);
        String str = "agbdba";
        int getlength = getLongest(str);
        System.out.println(getlength);
    }

    private static int getLongest(String str) {
        int[][] dp = new int[str.length()][str.length()];


        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }
        //For each length from 1 to n.
        for (int d = 1; d < str.length(); d++) {
            //start with 0 till length-d
            for (int i = 0; i < str.length() - d; i++) {
                //j will be end of current string
                int j = i + d;
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }

        return dp[0][str.length() - 1];
    }

    private static String getResult(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                boolean isInnerPalindrome = dp[j + 1][i - 1] || i - j <= 2;
                if (s.charAt(i) == s.charAt(j) && isInnerPalindrome) {
                    dp[i][j] = true;
                    if (i - j > right - left) {
                        right = i;
                        left = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
