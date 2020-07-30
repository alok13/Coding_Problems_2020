package Round3;

import java.util.ArrayList;
import java.util.List;

public class PartitionPalindrome {
    public static void main(String[] args) {
        String arr = "ababbbabbababa";
        getStrings(arr);

    }

    private static void getStrings(String arr) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(0, arr, result, list);
        System.out.println(result);

    }

    private static void dfs(int start, String str, List<List<String>> result, List<String> list) {
        if (start == str.length())
            result.add(new ArrayList<>(list));
        for (int i = start; i < str.length(); i++) {
            if (isPal(str, start, i)) {
                list.add(str.substring(start, i + 1));
                dfs(i + 1, str, result, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPal(String s, int low, int high) {
        while (low < high) if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}
