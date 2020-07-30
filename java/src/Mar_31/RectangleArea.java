package Mar_31;

import java.util.Stack;

public class RectangleArea {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        Stack<Integer> stack = new Stack();

        int len = heights.length;
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int partialMaxArea = heights[stack.pop()] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1));
                maxArea = Math.max(maxArea, partialMaxArea);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int partialMaxArea = heights[stack.pop()] * (len - (stack.isEmpty() ? 0 : stack.peek() + 1));
            maxArea = Math.max(maxArea, partialMaxArea);
        }

        return maxArea;
    }

}
