package Apr_5;

import java.util.*;

public class InvalidParanthesis {
    public static void main(String[] args) {
        String s = "()())()";
       // System.out.println(getValidParanthesis(s));
        System.out.println(getMinimum(s));
    }

    private static List<String> getValidParanthesis(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.add(s);
        set.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            String currString = queue.poll();

            if (isValid(currString)) {
                result.add(s);
                found = true;
            }
            if (found) continue;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!set.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    set.add(t);
                }

            }
        }

        return result;

    }

    private static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }


    static List<String> getMinimum(String s) {
        List<String> result = new ArrayList<>();
        getDFS(s, result, 0, 0, '(', ')');
        return result;
    }


    static private void getDFS(String s, List<String> result, int iStart, int jStart, char openParan, char closeParan) {
        int open = 0;
        int close = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParan) open++;
            if (s.charAt(i) == closeParan) close++;
            if (close > open) {
                for (int j = jStart; j <= i; j++) {
                    if (s.charAt(j) == closeParan && (j == jStart || closeParan != s.charAt(j - 1))) {
                        getDFS(s.substring(0, j) + s.substring(j + 1,s.length()), result, i, j, openParan, closeParan);
                    }
                }
                return;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();

        if (openParan == '(') {
            getDFS(reversed, result, 0, 0, ')', '(');
        } else {
            result.add(reversed);
        }
    }
}
