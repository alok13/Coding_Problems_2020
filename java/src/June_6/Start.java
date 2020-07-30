package June_6;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        String[] map = {"", "abc", "def"};
        String number = "12";
        List<String> result = getAnswer(map, number);
        System.out.println(result);
    }

    private static List<String> getAnswer(String[] map, String number) {
        List<String> list = new ArrayList<>();
        getCombination(map, number, list, 0, "");
        return list;
    }

    private static void getCombination(String[] map, String number, List<String> list, int index, String result) {
        if (index >= number.length()) {
            list.add(result);
            return;
        }
        int num = Character.getNumericValue(number.charAt(index));
        String curr = map[num];
        for (int i = 0; i < curr.length(); i++) {
            getCombination(map, number, list, index + 1, result + curr.charAt(i));
        }
    }
}
