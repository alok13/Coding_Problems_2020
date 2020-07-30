package Feb_28;

public class NumberofSetBits {
    public static void main(String[] args) {
        int num = 7;
        int reuslt = getSetBit(num);
        System.out.println(reuslt);
    }

    private static int getSetBit(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num = num >>> 1;
        }
        return count;
    }

    private static int getSetBitNew(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
