package Mar_12;

import java.util.Stack;

public class ParnethesisCorrection {

    public static void main(String[] args) {
        String res = "ab(sv(";
        String result = fixPal(res);
        System.out.println(result);
    }

    private static String fixPal(String res) {
        StringBuilder sb = new StringBuilder(res);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '(')
                stack.push(i);
            else if (res.charAt(i) == ')') {
                if (stack.isEmpty())
                    sb.setCharAt(i, '*');
                else
                    stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            int i = stack.pop();
            sb.setCharAt(i, '*');
        }
        
        System.out.println(sb);
        return sb.toString().replaceAll("\\*", "");
    }
}
