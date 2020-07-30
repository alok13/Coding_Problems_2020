package Feb_28;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

import java.util.Stack;

public class RemoveMinimumToMakeParenthesis {
    public static void main(String[] args) {
        //String s = "lee(t(c)o)de)";
        String s = ")lee(t(c)o)de)(";
        String result = getValid(s);
        System.out.println(result);
    }

    private static String getValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    sb.setCharAt(i, '*');
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }
}
