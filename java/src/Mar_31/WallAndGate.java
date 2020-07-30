package Mar_31;

import java.util.*;

public class WallAndGate {


    public void wallsAndGates(int[][] rooms) {
        // write your code here

        int m = rooms.length;
        if (m <= 0) {
            return;
        }

        int n = rooms[0].length;
        if (n <= 0) {
            return;
        }
        Queue<Point> qu = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    //do dfs
                    qu.offer(new Point(i, j));

                }
            }
        }

        int level = 0;
        while (!qu.isEmpty()) {

            int size = qu.size();
            while (size-- > 0) {
                Point head = qu.poll();

                if ((head.x < 0) || (head.y < 0) || (head.x >= m) || (head.y >= n) || (rooms[head.x][head.y] == -1) || rooms[head.x][head.y] < level) {
                    continue;
                }
                // System.out.println("Updating" + rooms[head.x][head.y] + " level "+level);
                rooms[head.x][head.y] = level;
                qu.offer(new Point(head.x - 1, head.y));
                qu.offer(new Point(head.x + 1, head.y));
                qu.offer(new Point(head.x, head.y - 1));
                qu.offer(new Point(head.x, head.y + 1));
            }
            //System.out.println("Updating level "+level);
            level++;
        }

        return;
    }
}

class Point {
    int x;
     int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}