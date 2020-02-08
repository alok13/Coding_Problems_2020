package Round1;//https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        int result = orangesRotting(grid);
        System.out.println(result);
    }

    private static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int fresh = 0;
        int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                if (grid[i][j] == 1)
                    fresh++;
            }
        if (fresh == 0)
            return count;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (fresh == 0)
                return count;
            for (int k = 0; k < size; k++) {
                int[] coordinate = queue.poll();
                for (int i = 0; i < direction.length; i++) {
                    int new_x = coordinate[0] + direction[i][0];
                    int new_y = coordinate[1] + direction[i][1];

                    if (new_x < 0 || new_y < 0 || new_x >= grid.length || new_y >= grid[0].length || grid[new_x][new_y] == 2 || grid[new_x][new_y] == 0)
                        continue;
                    grid[new_x][new_y] = 2;
                    queue.add(new int[]{new_x, new_y});
                    fresh--;
                }
            }
            count++;

        }
        return fresh == 0 ? count - 1 : -1;
    }

}
