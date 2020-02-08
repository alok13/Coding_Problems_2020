package java8Code;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PriorityQueueTests {
    public static void main(String[] args) {
        Sorrt s1 = new Sorrt("a", 6);
        Sorrt s2 = new Sorrt("bc", 5);
        Sorrt s3 = new Sorrt("css", 4);
        Sorrt s4 = new Sorrt("dfff", 3);
        Sorrt s5 = new Sorrt("efsdsdasd", 2);
        Sorrt s6 = new Sorrt("fsddasdasdasd", 1);

        Comparator<Sorrt> comparator = Comparator.comparingInt(o -> o.name.length());
        PriorityQueue<Sorrt> queue = new PriorityQueue<>(comparator);
        PriorityQueue<Sorrt> queue1 = new PriorityQueue<>(Comparator.comparingInt(o -> o.num));
        queue.add(s1);
        queue.add(s2);
        queue.add(s3);
        queue.add(s4);
        queue.add(s5);
        queue.add(s6);
        queue1.add(s1);
        queue1.add(s2);
        queue1.add(s3);
        queue1.add(s4);
        queue1.add(s5);
        queue1.add(s6);

        queue.forEach(sorrt -> System.out.println(sorrt.name));
        queue1.forEach(sorrt -> System.out.println(sorrt.num));
    }

}




class Sorrt {
    String name;
    int num;

    public Sorrt(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
