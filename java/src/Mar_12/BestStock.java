package Mar_12;

public class BestStock {
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        int result = getResult(arr);
        System.out.println(result);
    }

    private static int getResult(int[] arr) {
        int min = arr[0];
        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i] - min);
        }
        return max;
    }
}


