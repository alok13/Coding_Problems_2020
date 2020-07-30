package Apr_5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PrisonAfterNDsys {

    public static void main(String[] args) {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int N = 7;
        int result[] = prisonAfterNDays(cells, N);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static int[] findNextDay(int[] cells) {
        int arr[] = new int[cells.length];
        for (int j = 1; j < cells.length - 1; j++) {
            if (cells[j - 1] == cells[j + 1])
                arr[j] = 1;
            else
                arr[j] = 0;
        }
        return arr;


    }

    public static int[] prisonAfterNDays(int[] cells, int N) {

        HashSet<String> set = new HashSet<>();
        boolean found = false;
        int size = 0;
        for (int i = 0; i < N; i++) {
            int[] nextDay = findNextDay(cells);
            String str = Arrays.toString(nextDay);
            if (set.contains(str)) {
                found = true;
                break;
            } else {
                set.add(str);
                size++;
            }
            cells=nextDay;
        }

        if(found){
            N=N%size;
            for(int i=1;i<=N;i++)
                cells=findNextDay(cells);
        }
        return cells;
    }
}
