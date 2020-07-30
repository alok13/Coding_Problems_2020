package Mar_7.Revision;

public class MoveZeros {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 3, 0};
        movezeros(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    private static void movezeros(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] == 0) {
                if (arr[end] != 0) {
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }

            } else
                start++;
            if (arr[end] == 0) {
                end--;
            }
        }
    }
}
