package Round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseCharLit {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('j');
        list.add('o');
        list.add('i');
        list.add('n');
        //list.add(' ');
        list.add('b');
        list.add('o');
        list.add('l');
        list.add('t');

        reverserList(list);
        System.out.println(list);
    }

    private static void reverserList(List<Character> list) {
        if (list == null || list.isEmpty())
            return;
        int index = 0;
        Character[] arr = new Character[list.size()];
        arr = list.toArray(arr);

        for (int i = 0; i < arr.length; i++) {
            if (list.get(i) == ' ') {
                reverse(index, i - 1, list);
                index = i + 1;
            } else if (index < arr.length && i == arr.length - 1) {
                reverse(index, i, list);
            }
        }


    }

    private static void reverse(int index, int space, List<Character> list) {
        while (index < space) {
            char first = list.get(index);
            char last = list.get(space);
            list.remove(index);
            list.remove(space);

            char temp = first;
            first = last;
            last = temp;

            list.add(index, last);
            list.add(space, first);
            index++;
            space--;
        }
    }
}
