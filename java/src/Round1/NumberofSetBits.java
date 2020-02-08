package Round1;

//https://leetcode.com/problems/number-of-1-bits/
public class NumberofSetBits {
    public static void main(String[] args) {
        int num = 7;
        int result = getSetBit(num);
        System.out.println(result);
    }

    private static int getSetBit(int num) {
        int result = 0;
        while (num != 0) {
            int a = num & 1;
            if (a == 1) {
                result++;
            }
            num = num >>> 1;
        }
        return result;
    }

}
