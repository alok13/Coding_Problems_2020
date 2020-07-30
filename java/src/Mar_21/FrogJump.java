package Mar_21;

import java.util.HashSet;
import java.util.Stack;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, 6, 8, 12, 17};
        boolean result = canJump(arr);
        System.out.println(result);
    }

    private static boolean canJump(int[] stones) {
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > stones[i - 1] * 2)
                return false;
        }

        HashSet<Integer> stonePosition = new HashSet<>();
        for (int s : stones) {
            stonePosition.add(s);
        }
        int lastStone = stones[stones.length - 1];
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        positions.add(0);
        jumps.add(0);
        while (!positions.isEmpty()) {
            int position = positions.pop();
            int jumpDistance = jumps.pop();

            for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {
                //So that we dont go backward or jump at same position
                if (i <= 0)
                    continue;
                int nextPosition = position + i;
                if (nextPosition == lastStone)
                    return true;
                    //check if this is in our set and add it.
                    //we only add one stone at a time .
                else if (stonePosition.contains(nextPosition)) {
                    positions.add(nextPosition);
                    jumps.add(i);
                }
            }
        }
        return false;
    }
}



