package Round1;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/discuss/interview-question/344677
public class CostOfAddingRopes {
    public static void main(String[] args) {
        Integer arr[] = {1, 2, 5, 10, 35, 89};
        int result = getCost(arr);
        System.out.println(result);

    }

    private static int getCost(Integer[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> list = Arrays.asList(arr);
        queue.addAll(list);
        int result = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            result = result + a + b;
            queue.add(a + b);
        }
        return result;
    }
}
