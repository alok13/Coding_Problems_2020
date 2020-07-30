package Mar_26;

public class FrequencyofKInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 4, 4, 5, 6};
        int K = 4;
        int result = getFrequncy(arr, K);
        System.out.println(result);
    }

    private static int getFrequncy(int[] arr, int k) {
        return firstOccurence(arr, k, false) - firstOccurence(arr, k, true) + 1;
    }

    private static int firstOccurence(int[] arr, int k, boolean leftMost) {
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < k) {
                start = mid + 1;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                index = mid;
                if (leftMost) {
                    end = mid - 1;
                } else
                    start = mid + 1;
            }
        }
        return index;
    }
}
