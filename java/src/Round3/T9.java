package Round3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T9 {
    public static void main(String[] args) {
        String str = "abc";
        String str1 = "def";
        String str2 = "ghi";
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, str);
        hashMap.put(2, str1);
        hashMap.put(3, str2);

        List<String> result = getOutPut(hashMap, "123");
    }

    private static List<String> getOutPut(HashMap<Integer, String> hashMap, String num) {
        List<String> result = new ArrayList<>();
        getCombination(0, "", hashMap, num, result);
        System.out.println(result);
        return null;
    }

    private static void getCombination(int start, String prefix, HashMap<Integer, String> hashMap, String num, List<String> result) {
        if (start >= num.length()) {
            result.add(prefix);
            return;

        }
        String s = hashMap.get(Character.getNumericValue(num.charAt(start)));
        for (int i = 0; i < s.length(); i++) {
            getCombination(start + 1,  prefix+s.charAt(i), hashMap, num, result);
        }
    }

}
