package Mar_31;

public class DivideNumber {
    public static void main(String[] args) {
        int dividend = -10;
        int divisor = 3;
        int result = divide(dividend, divisor);
        System.out.println(result);
    }

    public static int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while (absDividend >= absDivisor) {
            long tmp = absDivisor, count = 1;
            while (tmp <= absDividend) {
                tmp <<= 1;
                //How many times we performed this
                count <<= 1;
            }
            long tempResult=count >> 1;
            result += tempResult;
            long newTemp=tmp>>1;
            absDividend -= newTemp;
        }
        return isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}

