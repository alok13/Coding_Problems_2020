package Apr_5;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAdd {
    public static void main(String[] args) {
        String s = "105";
        int target = 5;
        System.out.println(getNumber(s, target));
    }

    private static List<String> getNumber(String s, int target) {
        List<String> result = new ArrayList<>();
        dfs(s, target, 0, 0, "", result, 0);
        return result;
    }

    private static void dfs(String str, int target, int currentSum, int prevNumber, String currentString, List<String> result, int index) {
        if (index == str.length()) {
            if (target == currentSum) {
                result.add(currentString);
            }
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (i != index && str.charAt(index) == 0)
                break;

            int num = Integer.valueOf(str.substring(index, i + 1));

            if (index == 0) {
                dfs(str, target, num, num, currentString + "" + num, result, i + 1);
            } else {
                dfs(str, target, currentSum + num, num, currentString + "+" + num, result, i + 1);
                dfs(str, target, currentSum - num, -num, currentString + "-" + num, result, i + 1);
                dfs(str, target, currentSum - prevNumber + prevNumber * num, prevNumber * num, currentString + "*" + num, result, i + 1);

            }

        }

    }
}
