package Round1;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/submissions/
public class MinimumElementSortedArrayWithDuplicate {
    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int result = getMinimum(arr);
        System.out.println(result);
    }

    private static int getMinimum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[end]) {
                end = mid;
            } else if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }
        return arr[start];
    }
}



