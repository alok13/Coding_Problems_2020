package Mar_26;

import java.util.ArrayList;
import java.util.List;

public class Generateparanthesis {
    static  int count=0;
    public static void main(String[] args) {
        int n = 4;
        List<String> result = getAll(n);

        System.out.println(count);
        System.out.println(result);
    }

    private static List<String> getAll(int n) {
        List<String> result = new ArrayList<>();
        generate(result, n, 0, 0,"");
        return result;
    }

    private static void generate(List<String> result, int n, int start, int end, String str) {
        count++;
        if (start == n && end==n) {
            result.add(str);
            return;
        }

        if (start < n)
            generate(result, n, start + 1, end, str + "(");
        if (end < start)
            generate(result, n, start, end + 1, str + ")");

    }
}
