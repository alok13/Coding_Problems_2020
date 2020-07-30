package Apr_5;

import java.util.ArrayList;
import java.util.List;

public class IpGeneration {
    public static void main(String[] args) {

    }


    public boolean regex(String str, String pattern) {
        boolean[][] arr = new boolean[str.length() + 1][pattern.length() + 1];

        arr[0][0] = true;
        for (int i = 0; i < arr[0].length; i++) {
            if (pattern.charAt(i - 1) == '*')
                arr[0][i] = arr[0][i - 2];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')
                    arr[i][j] = arr[i - 1][j - 1];

                if (str.charAt(i - 1) == '*') {
                    if (str.charAt(i - 1) != pattern.charAt(i - 2) && pattern.charAt(i - 2) != '.') {
                        arr[i][j] = arr[i][j - 2];
                    } else {
                        arr[i][j] = arr[i][j-2] || arr[i - 1][j] || arr[i][j - 1];
                    }
                }
            }
        }
        return arr[str.length()][pattern.length()];
    }

    public static List<String> generateIp(String str) {
        List<String> result = new ArrayList<>();
        generateIps(str, 0, 0, "", result);
        return result;

    }

    private static void generateIps(String str, int index, int num, String s, List<String> result) {
        if (num == 4) {
            if (index == str.length() + 1)
                result.add(s);
            return;
        }
        if (num > 4)
            return;

        for (int i = 0; i <= 2; i++) {
            if (index + i + 1 > str.length()) break;
            String sub = str.substring(index, index + i + 1);
            if (Integer.valueOf(sub) > 255) continue;
            generateIps(str, index + i, num, s + "." + sub, result);
        }
    }
}
