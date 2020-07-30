package Apr_5;

public class RoatedArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int result = findMinimum(arr);
        System.out.println(result);
    }

    private static int findMinimum(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[end])
                end = mid;
            else
                start = mid -1;
        }
        return arr[start];
    }
}
