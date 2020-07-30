package Mar_18;

//https://leetcode.com/problems/single-number-ii/discuss/43294/Challenge-me-thx
public class SinglrNumber {
    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 2, 1, 2, 4};
        int result = getNumber(arr);
        System.out.println(result);
    }

    private static int getNumber(int[] arr) {
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < arr.length; i++) {
            ones = (ones ^ arr[i]) & ~twos;


            twos = (twos ^ arr[i]) & ~ones;
        }
        return ones;
    }
}
