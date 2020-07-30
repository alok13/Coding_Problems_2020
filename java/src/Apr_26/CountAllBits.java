package Apr_26;

public class CountAllBits {
    public static void main(String[] args) {
        int num = 5;
        int[] arr = getBitCounts(num);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static int[] getBitCounts(int num) {
        int[] arr = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            arr[i] = bitInNumber(i);
        }
        return arr;
    }

    private static int bitInNumber(int i) {
        int count = 0;
        while (i != 0) {
            count += i & 1;
            i = i >>> 1;

        }
        return count;
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;

        for(int i = 1; i <= num; i++){
            if((i & 1) == 0){
                res[i] = res[i >> 1];
            }else{
                res[i] = res[i - 1] + 1;
            }
        }

        return res;
    }
}
