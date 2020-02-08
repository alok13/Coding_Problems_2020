package Round4;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
        int[][] result=getResult(intervals);
    }

    private static int[][] getResult(int[][] intervals) {
        int[][] result=new int[intervals.length][2];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i-1][1]>=intervals[i][0]){

            }
        }

        return null;
    }
}
