package Feb_28;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        printArrayHe(arr);
        System.out.println();
        //rotateArray(arr);
        //printArrayHe(arr);

        rotateArrayAntiClockWise(arr);
        printArrayHe(arr);
    }

    private static void rotateArrayAntiClockWise(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    private static void rotateArray(int[][] arr) {
        //transpose the arr

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[arr.length - 1 - j][arr.length - 1 - i];
                arr[arr.length - 1 - j][arr.length - 1 - i] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[arr.length - 1 - j][i];
                arr[arr.length - 1 - j][i] = temp;
            }
        }
    }

    private static void printArrayHe(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }
}
