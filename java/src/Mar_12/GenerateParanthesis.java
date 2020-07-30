package Mar_12;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void main(String[] args) {
        int n = 4;
        List<String> result = result(n);
        System.out.println(result);
    }

    private static List<String> result(int n) {
        List<String> list = new ArrayList<>();
        prepare(n, list, 0, 0, "");
        return list;
    }

    private static void prepare(int n, List<String> list, int open, int end, String s) {
        if (open == end && n == open) {
            list.add(s);
            return;
        }

        if (open < n) {
            prepare(n, list, open + 1, end, s + "(");

        }
        if (open > end) {
            prepare(n, list, open, end + 1, s + ")");
        }
    }
}
