package Round1;//https://leetcode.com/problems/decode-ways/

public class DecodeStrings {
    public static void main(String[] args) {
        String str = "226";
        int result = getResult(str);
        System.out.println(result);

    }

    private static int getResult(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int[] sum = new int[str.length() + 1];
        sum[0] = 1;
        sum[1] = str.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i < sum.length; i++) {
            int first = Integer.valueOf(str.substring((i - 1), i));
            int second = Integer.valueOf(str.substring((i - 2), i));
            if (first >= 1 && first <= 9) {
                sum[i] = sum[i] + sum[i - 1];
            }
            if (second >= 10 && second <= 26) {
                sum[i] = sum[i] + sum[i - 2];
            }
        }
        return sum[sum.length - 1];
    }
}
