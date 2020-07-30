package Mar_26;

public class KthLargestElement {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = getKthLargest(arr, k);
        System.out.println(result);
    }

    private static int getKthLargest(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int index = arr.length - k;
        while (start < end) {
            int pivot = partition(arr, start, end);
            if (pivot < index)
                start = pivot + 1;
            else if (pivot > index)
                end = pivot - 1;
            else
                return arr[pivot];
        }
        return arr[start];
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = start;
        while (start <= end) {
            while (start <= end && arr[start] <= arr[pivot])
                start++;
            while (start <= end && arr[pivot] < arr[end])
                end--;
            if (start > end)
                break;
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        int temp = arr[pivot];
        arr[pivot] = arr[end];
        arr[end] = temp;
        return end;
    }
}
