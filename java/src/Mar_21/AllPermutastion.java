package Mar_21;

import java.util.ArrayList;
import java.util.List;

import static Round3.PartitionPalindrome.isPal;

public class AllPermutastion {
    public static void main(String[] args) {
        String str = "abaccb";
        List<List<String>> result = getAll(str);
        System.out.println(result);
    }

    private static List<List<String>> getAll(String str) {
        List<List<String>> result = new ArrayList<>();
        dfs(str, 0, new ArrayList<>(), result);
        return result;
    }

    public static void dfs(String s, int pos, List<String> list, List<List<String>> res) {
        if (pos == s.length()) res.add(new ArrayList<String>(list));
        else {
            for (int i = pos; i < s.length(); i++) {
                if (isPal(s, pos, i)) {
                    list.add(s.substring(pos, i + 1));
                    dfs(s, i + 1, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

}


