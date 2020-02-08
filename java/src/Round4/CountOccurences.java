package Round4;

public class CountOccurences {
    public static void main(String[] args) {
        //int arr[] = {1, 2, 2, 2, 2, 3};
        int arr[] = {1, 2, 2, 2, 3, 3, 3};
        int result = getOccurence(arr, 0, arr.length - 1, 3);
        System.out.println(result);
    }

    private static int getOccurence(int[] arr, int start, int end, int x) {
        if (arr[start] == arr[end] && x == arr[start])
            return end - start + 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > x) {
                return getOccurence(arr, start, mid, x);
            } else if (arr[mid] < x) {
                return getOccurence(arr, mid + 1, end, x);
            } else {
                if (arr[end] != arr[mid])
                    end--;
                if (arr[start] != arr[mid])
                    start++;
                return getOccurence(arr, start, end, x);
            }

        }
        return 0;

    }
}
