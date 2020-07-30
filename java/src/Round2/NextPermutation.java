package Round2;

public class NextPermutation {
    public static void main(String[] args) {
        //int arr[] = {2, 3, 6, 5, 4, 1};
        //int arr[] = {1,2,3};
        int arr[] = {9,8,3,7,4,9};

        int result[] = getNextPermutation(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] getNextPermutation(int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;

        // Find the number such that arr[i]<arr[i+1]
        int index = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            swap(arr, 0, arr.length - 1);
            return arr;
        }
        int big = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[index] < arr[i]) {
                big = i;
                break;
            }
        }

        int t1 = arr[index];
        arr[index] = arr[big];
        arr[big] = t1;


        swap(arr, index + 1, arr.length - 1);
        return arr;
    }

    private static void swap(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
