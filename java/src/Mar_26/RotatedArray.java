package Mar_26;

public class RotatedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 1};
        int minimum = getMinimum(arr);
        System.out.println(minimum);
        int search = searchNumber(arr, 5);
        System.out.println(search);
        int search2 = searchNumber2(arr, 5);
        System.out.println(search2);
        int arr2[] = {2, 2, 2, 2, 2, 2, 5, 2};
        boolean search3 = searchNumber3(arr2, 5);
        System.out.println(search3);
    }

    private static boolean searchNumber3(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return true;
            if (arr[mid] > arr[start]) {
                //Left part is sorted
                if (arr[mid] > target && arr[start] < target) {
                    //Target in not rotate part
                    end = mid - 1;
                } else
                    //Target in rotated part.
                    start = mid + 1;
            } else if (arr[mid] < arr[start]) {
                //Right part is sorted
                if (arr[mid] < target && arr[end] > target)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                start++;
            }
        }
        return false;
    }

    private static int searchNumber2(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (arr[end] >= arr[mid]) {
                if (arr[mid] < target && arr[end] >= arr[target]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }
        }
        return -1;
    }

    private static int searchNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[end])
                end = mid;
            else
                start = mid + 1;
        }
        int minIndex = start;
        start = 0;
        end = arr.length - 1;
        if (arr[minIndex] <= target && arr[end] >= target)
            start = minIndex;
        else
            end = minIndex;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int getMinimum(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[end])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
