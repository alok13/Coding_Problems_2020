package Mar_12;

import java.util.ArrayList;
import java.util.List;

public class PhonoCombo {
    public static void main(String[] args) {
        String[] arr = {"abc", "def", "ijk"};
        String num = "123";
        List<String> result = getCombo(arr, num);
        System.out.println(result);
    }

    private static List<String> getCombo(String[] arr, String num) {
        List<String> result = new ArrayList<>();
        dfs(arr, 0, "", result, num);
        return result;
    }

    private static void dfs(String[] arr, int index, String s, List<String> result, String num) {
        if (s.length() == String.valueOf(num).length()) {
            result.add(s);
            return;
        }
        if (index > num.length())
            return;
        int in = Character.getNumericValue(num.charAt(index))-1;
        for (int i = 0; i < arr[in].length(); i++) {
            dfs(arr, index + 1, s + arr[in].charAt(i), result, num);
        }
    }
}
