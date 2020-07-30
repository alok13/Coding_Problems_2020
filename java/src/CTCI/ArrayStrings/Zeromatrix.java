package CTCI.ArrayStrings;

import java.util.HashSet;
import java.util.Set;

//Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//column are set to 0.
public class Zeromatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0, 2},
                {1, 2, 3, 4},
                {3, 4, 5, 3}};
        zeroTheMatrix(arr);
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

    private static void zeroTheMatrix(int[][] arr) {
        Set<Integer> iSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    iSet.add(i);
                    jSet.add(j);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (iSet.contains(i) || jSet.contains(j)) {
                    arr[i][j] = 0;
                }
            }
        }
    }
}
