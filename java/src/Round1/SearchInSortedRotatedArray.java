package Round1;//https://leetcode.com/problems/search-in-rotated-sorted-array/

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
//        int arr[] = {4, 5, 6, 7, 0, 1, 2};
//        int target = 3;
        int arr[] = {1, 3};
        int target = 0;
        int result = getResult(arr, target);
        System.out.println("For " + target + "--> " + result);

//        for (int t : arr) {
//            int result = getResult(arr, t);
//            System.out.println("For " + t + "--> " + result);
//        }

    }


    private static int getResult(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int lowest = start;// will have lowest value
        start = 0;
        end = arr.length - 1;

        if (target >= arr[lowest] && target <= arr[end]) {
            start = lowest;
        } else {
            end = lowest;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
