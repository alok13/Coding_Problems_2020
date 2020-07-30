package Mar_31;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Expression {
    public static void main(String[] args) {
        String num = "232";
        int target = 8;
       // System.out.println(getResult(num, target));
        // Output: ["2*3+2", "2+3*2"]
        generateNumber();
    }

    private static void generateNumber() {
        boolean[] visited = new boolean[10];
        List<String> result = new ArrayList<>();
        dfsForNum(result, visited, 0, "");
        System.out.println(result);
    }

    private static void dfsForNum(List<String> result, boolean[] visited, int index, String s) {
        if (s.length() == 5 && isValid(s)) {
            result.add(s);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfsForNum(result, visited, index, s + i);
                visited[i]=false;
            }

        }
    }

    private static boolean isValid(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c))
                return false;
            set.add(c);
        }
        int firstNum = Integer.valueOf(s.substring(0, 2));
        int multiplied = Character.getNumericValue(s.charAt(2));
        int result = firstNum * multiplied;
        int toAdd = Integer.valueOf(s.substring(3));
        int finalSum = toAdd + result;
        String newResult = "" + firstNum + "" + multiplied + "" + result + "" + toAdd + "" + finalSum;

        Set<Character> newSet = new HashSet<>();

        for (char c : newResult.toCharArray()) {
            if (newSet.contains(c))
                return false;
            newSet.add(c);
        }
        return true;
    }

    public static List<String> getResult(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        dfs(result, num, target, "", 0, 0, 0);
        return result;
    }

    public static void dfs(List<String> result, String num, int target, String expr, long calcVal, long preNum, int pos) {
        if (pos == num.length()) {
            if (calcVal == target) {
                result.add(expr);
            }
            return;
        }
        // start from first index of current position in num string, try all possible length of nums
        for (int i = pos; i < num.length(); i++) {
            // corner case: if current position is 0, we can only use it as a single digit number, should be 0
            // if it is not a single digit number with leading 0, it should be considered as an invalid number
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            //We are doing this because we also need to consider 2digit and 3 digit numbers
            long curNum = Long.parseLong(num.substring(pos, i + 1));
            // position 0 should be considered individually, since it does not have any operand character before curNum
            if (pos == 0) {
                dfs(result, num, target, expr + curNum, curNum, curNum, i + 1);
            } else {
                dfs(result, num, target, expr + "+" + curNum, calcVal + curNum, curNum, i + 1);
                dfs(result, num, target, expr + "-" + curNum, calcVal - curNum, -curNum, i + 1);
                // trick part: to calculate multiplication, we should subtract previous number, and then add current
                // multiplication result to the subtraction result
                dfs(result, num, target, expr + "*" + curNum, calcVal - preNum + preNum * curNum, preNum * curNum, i + 1);
            }
        }
    }
}

