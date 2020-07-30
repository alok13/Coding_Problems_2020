package Mar_21;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 6, 3, 56, 8, 9, 23};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }

    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i < mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j < end) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (i = start; i < end; i += 1) {
            arr[i] = temp[i - start];
        }
    }
}
