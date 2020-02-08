package Round2;



public class EqualSubSet {
    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};
        int sum = 0;
        for (int i : arr)
            sum = sum + i;
        boolean result = getResult(arr, 0, 0, sum / 2);
        System.out.println(result);
    }

    private static boolean getResult(int[] arr, int index, int total, int target) {
        if (total == target)
            return true;
        if (total > target || index >= arr.length)
            return false;
        return getResult(arr, index + 1, total, target) || getResult(arr, index, total + arr[index], target);
    }


}
