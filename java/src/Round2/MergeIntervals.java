//package Round2;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//public class MergeIntervals {
//    public static void main(String[] args) {
//        List<Interval> list1 = new ArrayList<>();
//        //(2,4) (6,8) (1,3) V2 = (7,9) (2,5)
//        list1.add(new Interval(2, 4));
//        list1.add(new Interval(6, 8));
//        list1.add(new Interval(1, 3));
//        List<Interval> list2 = new ArrayList<>();
//        list2.add(new Interval(7, 9));
//        list2.add(new Interval(2, 5));
//
//        List<Interval> union = getUnion(list1, list2);
//    }
//
//    private static List<Interval> getUnion(List<Interval> list1, List<Interval> list2) {
//        list1.sort(new MyComparator());
//        list2.sort(new MyComparator());
//
//        List<Interval> result=new ArrayList<>();
//
//        int i=0;
//        int j=0;
//        while(i<list1.size() && j<list2.size()){
//            Interval one=list1.get(i);
//            Interval second=list2.get(j);
//
//
//        }
//
//
//        return null;
//    }
//
//}
//
//class MyComparator implements Comparator<Interval> {
//    @Override
//    public int compare(Interval i1, Interval i2) {
//        if (i1.start == i2.start) {
//            return 0;
//        } else {
//            return i1.start < i2.start ? -1 : 1;
//        }
//    }
//}
//
//
// class Interval {
//    int start, end;
//
//    Interval(int start, int end) {
//        this.start = start;
//        this.end = end;
//    }
//}