package Mar_18;

public class Anagram {
    public static void main(String[] args) {
        int[] arr = {0, 0, 11, 10, 0};
        getResult(arr);
        for (int i : arr)
            System.out.println(i);
    }

    private static void getResult(int arr[]) {
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[start] = arr[i];
                start++;
            }
        }
        for (int i = start; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
