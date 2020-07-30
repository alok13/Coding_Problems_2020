package Mar_26;

import java.util.Stack;

public class LongestValidParanthesis {
    public static void main(String[] args) {
        String str = "(())";
        int resulr = getLongest(str);
        System.out.println(resulr);
    }

    private static int getLongest(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {  // inside valid substring, update res
                stack.pop();
                int validLen = stack.isEmpty() ? i + 1 : i - stack.peek();
                ans = Math.max(ans, validLen);
            } else {   // valid substring breaks
                stack.push(i);
            }
        }
        return ans;
    }
}
