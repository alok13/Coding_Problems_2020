package Mar_7.Revision;

import java.util.ArrayList;
import java.util.List;

public class PhoneCombo {
    public static void main(String[] args) {
        String[] arr = {"", "", "abc", "def", "ijk"};
        List<String> list = new ArrayList<>();
        String str = "234";
        getList(arr, list, str);
        System.out.println(list);
    }

    private static void getList(String[] arr, List<String> list, String str) {
        getAllList(arr, list, str, 0, "");
    }

    private static void getAllList(String[] arr, List<String> list, String str, int start, String s) {
        if (s.length() == str.length()) {
            list.add(s);
            return;
        }


        String curr = arr[Character.getNumericValue(str.charAt(start))];
        for (int j = 0; j < curr.length(); j++)
            getAllList(arr, list, str, start + 1, s + curr.charAt(j));

    }
}


