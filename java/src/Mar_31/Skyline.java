package Mar_31;

import java.util.*;

public class Skyline {
    public static void main(String[] args) {
        int[][] arr = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkyLine(arr));
    }

    private static List<List<Integer>> getSkyLine(int[][] arr) {
        List<List<Integer>> result = new ArrayList<>();
        BuildingPoints[] buidling = new BuildingPoints[arr.length * 2];
        int index = 0;

        for (int[] row : arr) {
            BuildingPoints p1 = new BuildingPoints();
            p1.x = row[0];
            p1.y = row[2];
            p1.isStart = true;
            buidling[index] = p1;

            BuildingPoints p2 = new BuildingPoints();
            p2.x = row[1];
            p2.y = row[2];
            p2.isStart = false;
            buidling[index + 1] = p2;
            index += 2;
        }
        Arrays.sort(buidling);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int prevHighest = 0;
        for (int i = 0; i < buidling.length; i++) {
            if (buidling[i].isStart) {
                map.put(buidling[i].y, map.getOrDefault(buidling[i].y, 0) + 1);
            } else {
                map.put(buidling[i].y, map.get(buidling[i].y) - 1);
                if (map.get(buidling[i].y) == 0)
                    map.remove(buidling[i].y);
            }
            int newHieght = map.lastKey();
            if (prevHighest != newHieght) {
                List<Integer> list = new ArrayList<>();
                list.add(buidling[i].x);
                list.add(newHieght);
                prevHighest = newHieght;
                result.add(list);
            }
        }
        return result;
    }
}



class BuildingPoints implements Comparable<BuildingPoints> {
    int x;
    int y;
    boolean isStart;

    @Override
    public int compareTo(BuildingPoints o2) {
        if (this.x != o2.x) {
            return this.x - o2.x;
        } else {
            return (this.isStart ? -this.y : this.y) - (o2.isStart ? -o2.y : o2.y);
        }
    }
}
