package Feb_28;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/discuss/interview-question/515324/Facebook-or-Phone-or-Natural-Sort-Order
public class NaturalCompartor {
    public static void main(String[] args) {
        String[] arr = {"b", "a", "a1", "a10b3", "a2", "aa"};
        //Regular: ['a', 'a1', 'a10b3', 'a2', 'aa', 'b']
        //Natural: ['a', 'a1', 'a2', 'a10b3', 'aa', 'b']

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length1 = o1.length();
                int length2 = o2.length();

                int i = 0;
                int j = 0;
                while (i < length1 && j < length2) {
                    //Getting digits from string
                    if (Character.isDigit(o1.charAt(i)) && Character.isDigit(o2.charAt(i))) {
                        int num1 = getNumberNow(o1, i);
                        int num2 = getNumberNow(o2, j);
                        //If both equal
                        if (num1 == num2) {
                            i += String.valueOf(num1).length();
                            j += String.valueOf(num1).length();
                        } else {
                            return num1 - num2;
                        }
                        //Get character and compare
                    } else if (o1.charAt(i) != o2.charAt(j)) {
                        return o1.charAt(i) - o2.charAt(j);
                    } else {
                        i++;
                        j++;
                    }
                }

                return 0;
            }
        });

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    private static int getNumberNow(String str, int index) {
        String s = "";
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            s = s + str.charAt(index);
            index++;
        }
        return Integer.valueOf(s);
    }
}

