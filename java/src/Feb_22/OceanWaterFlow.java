package Feb_22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OceanWaterFlow {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        List<String> result = getFlow(arr);
        System.out.println(result);
    }

    private static List<String> getFlow(int[][] arr) {

        boolean[][] pacificVisit = new boolean[arr.length][arr[0].length];
        boolean[][] atlanticValue = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            pacificVisit[i][0] = true;
            atlanticValue[i][arr[0].length - 1] = true;
        }
        for (int j = 0; j < arr[0].length; j++) {
            pacificVisit[0][j] = true;
            atlanticValue[arr.length - 1][j] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            explore(pacificVisit, i, 0, arr);
            explore(atlanticValue, i, arr[0].length-1, arr);
        }

        for (int j = 0; j < arr[0].length; j++) {

            explore(pacificVisit, 0, j, arr);
            explore(atlanticValue, arr.length - 1, j, arr);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (pacificVisit[i][j] && atlanticValue[i][j])
                    result.add("["+i + "" + j+"]");
            }

        }
        return result;
    }

    private static void explore(boolean[][] pacificVisit, int i, int j, int[][] arr) {
        pacificVisit[i][j] = true;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int k = 0; k < direction.length; k++) {
            int newX = i + direction[k][0];
            int newY = j + direction[k][1];
            if (newX >= 0 && newY >= 0 && newX < arr.length && newY < arr[0].length && arr[i][j] <= arr[newX][newY] && !pacificVisit[newX][newY]) {
                explore(pacificVisit, newX, newY, arr);
            }

        }

    }

}


//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
