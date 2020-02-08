package Round1;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/347457
public class MinimumPathToTreasure {
    public static void main(String[] args) {

        int[][] grid = {{'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'D'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        int result = getPathToTreasure(grid);
        System.out.println(result);

    }

    private static int getPathToTreasure(int[][] grid) {
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(new Coordinate(0, 0));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Coordinate coordinate = queue.poll();
                if (grid[coordinate.x][coordinate.y] == 'X')
                    return steps;

                for (int j = 0; j < direction.length; j++) {
                    int new_Xcoordinate = direction[j][0] + coordinate.x;
                    int new_Ycoordinate = direction[j][1] + coordinate.y;
                    if (new_Xcoordinate < 0 || new_Ycoordinate < 0 ||
                            new_Xcoordinate >= grid.length || new_Ycoordinate >= grid[0].length ||
                            grid[new_Xcoordinate][new_Ycoordinate] == 'D' ||  visited[new_Xcoordinate][new_Ycoordinate])
                        continue;
                    queue.add(new Coordinate(new_Xcoordinate, new_Ycoordinate));
                    visited[new_Xcoordinate][new_Ycoordinate] = true;
                }
            }
            steps++;

        }
        return 0;
    }

}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
