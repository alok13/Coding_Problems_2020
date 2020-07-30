package Feb_28;

import java.util.ArrayList;

public class MergeKSortedList {
    public static void main(String[] args) {
        ArrayList[] list = new ArrayList[6];
        ArrayList<Integer> list1 = new ArrayList<>();list1.add(1);list1.add(2);list1.add(3);list1.add(4);
        ArrayList<Integer> list2 = new ArrayList<>();list2.add(5);list2.add(6);list2.add(7);list2.add(8);list2.add(8);list2.add(8);list2.add(8);
//        ArrayList<Integer> list3 = new ArrayList<>();list1.add(1);list1.add(2);list1.add(3);list1.add(4);
//        ArrayList<Integer> list4 = new ArrayList<>();list1.add(1);list1.add(2);list1.add(3);list1.add(4);
//        ArrayList<Integer> list5 = new ArrayList<>();list1.add(1);list1.add(2);list1.add(3);list1.add(4);
//        ArrayList<Integer> list6 = new ArrayList<>();list1.add(1);list1.add(2);list1.add(3);list1.add(4);

        System.out.println(mergeTwoList(list1,list2));

    }

    public static  ArrayList<Integer> mergeTwoList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else if (list1.get(i) > list2.get(j)) {
                result.add(list2.get(j));
                j++;
            } else {
                result.add(list2.get(j));
                result.add(list1.get(i));
                i++;
                j++;
            }
        }

        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }
        return result;
    }
}


