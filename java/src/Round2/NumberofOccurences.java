package Round2;

//Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. (O(Log(N)))
public class NumberofOccurences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 3, 3};
        int target = 2;
        int result = getOccurences(arr, target, 0, arr.length - 1);
        System.out.println(result);
    }

    private static int getOccurences(int[] arr, int target, int start, int end) {
        int result = 0;

        int first = getFirstOccurence(arr, target, start, end);
        int last = getLastOccurence(arr, target, start, end);
        return last - first + 1;
    }
    private static int getLastOccurence(int[] arr, int target, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if ((mid == arr.length - 1 || arr[mid + 1] > target) && arr[mid] == target)
                return mid;
            else if (arr[mid] > target) {
                return getLastOccurence(arr, target, start, mid - 1);
            } else
                return getLastOccurence(arr, target, mid + 1, end);
        }
        return -1;
    }
    private static int getFirstOccurence(int[] arr, int target, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if ((mid == 0 || arr[mid - 1] < target) && arr[mid] == target)
                return mid;
            else if (arr[mid] < target) {
                return getFirstOccurence(arr, target, mid + 1, end);
            } else
                return getFirstOccurence(arr, target, start, mid - 1);
        }
        return -1;
    }
}
