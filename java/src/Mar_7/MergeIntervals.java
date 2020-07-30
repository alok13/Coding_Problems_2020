package Mar_7;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Intervals> list = new ArrayList<>();
        //[[1,3],[2,6],[8,10],[15,18]]
        list.add(new Intervals(1, 3));
        list.add(new Intervals(2, 6));
        list.add(new Intervals(8, 10));
        list.add(new Intervals(15, 18));

        Collections.sort(list, (o1, o2) -> o1.start - o2.start);

        System.out.println(getResult(list));

    }

    private static List<Intervals> getResult(List<Intervals> list) {
        List<Intervals> arrayList = new ArrayList<>();
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i).end >= list.get(i + 1).start) {
//                list.get(i).end = list.get(i + 1).end;
//                list.remove(i + 1);
//                i++;
//            } else {
//                arrayList.add(list.get(i));
//            }
//        }


        ListIterator<Intervals> iterator=list.listIterator();
        Intervals curr=iterator.next();
        //Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        while(iterator.hasNext()){
            Intervals next = iterator.next();
            if(curr.end < next.start){
                curr = next;
            }else{
                curr.end = Math.max(curr.end, next.end);
                iterator.remove();
            }
        }
        return list;
    }
}



class Intervals {
    int start;
    int end;

    Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Intervals{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}