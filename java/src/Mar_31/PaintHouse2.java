package Mar_31;

public class PaintHouse2 {
    public static void main(String[] args) {
        int arr[][] = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        int result = getResult(arr);
        System.out.println(result);
    }

    private static int getResult(int[][] arr) {
        int preMin = 0;
        int prevSecond = 0;
        int prevIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            int currMin = Integer.MAX_VALUE;
            int currSecond = Integer.MAX_VALUE;
            int currIndex = 0;

            for (int j = 0; j < arr[0].length; j++) {
                if (prevIndex == j) {
                    arr[i][j] += prevSecond;
                } else {
                    arr[i][j] += preMin;
                }
                if (currMin > arr[i][j]) {
                    currSecond = currMin;
                    currMin = arr[i][j];
                    currIndex = j;
                } else if (currSecond > arr[i][j]) {
                    currSecond = arr[i][j];
                }
            }
            preMin = currMin;
            prevSecond = currSecond;
            prevIndex = currIndex;

        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < arr[0].length; j++) {
            if (result > arr[arr.length - 1][j]) {
                result = arr[arr.length - 1][j];
            }
        }
        return result;
    }
}
