package Round1;//https://leetcode.com/problems/increasing-triplet-subsequence/

public class IncreasingTriplet {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        boolean result = getResult(arr);
        System.out.println(result);
    }

    private static boolean getResult(int[] arr) {
        if(arr==null || arr.length<3)
            return false;
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int n : arr) {
            if (n <= small) small = n;
            else if (n <= big) big = n;
            else return true;
        }
        return false;
    }
}
