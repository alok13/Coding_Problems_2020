package Mar_7.Revision;


import java.util.Arrays;

public class MeetingRoom {
    public static void main(String[] args) {

        Intervalss[] inerval = {new Intervalss(0, 30), new Intervalss(5, 10), new Intervalss(15, 20)};
        boolean result = isPossible(inerval);
        System.out.println(result);

    }

    private static boolean isPossible(Intervalss[] interval) {
        Arrays.sort(interval, (o1, o2) -> o1.start - o2.start);
        for (int i = 0; i < interval.length - 1; i++) {
            if (interval[i].end > interval[i + 1].start)
                return false;
        }
        return true;
    }
}


class Intervalss {
    int start;
    int end;

    Intervalss(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Intervals{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}