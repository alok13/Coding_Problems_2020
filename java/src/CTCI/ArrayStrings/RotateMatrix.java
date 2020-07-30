package CTCI.ArrayStrings;
//Given an image represented by an NxN matrix, where each pixel in the image is 4
//bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        rotateMatrix(arr);
        printMatrix(arr);

    }

    private static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void rotateMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length - i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[arr.length - 1 - j][arr.length - 1 - i];
                arr[arr.length - 1 - j][arr.length - 1 - i] = temp;
            }

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[arr.length - 1 - i][j];
                arr[arr.length - 1 - i][j] = temp;
            }
        }
    }
}


