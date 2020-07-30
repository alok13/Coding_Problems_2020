package Mar_18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Celebrity {
    public static void main(String[] args) {
        int a=1;
        int b=4;
        int result=getDiffferentBits(a,b);
        System.out.println(result);
    }

    private static int getDiffferentBits(int a, int b) {
        int count=0;
        while(a>0 || b>0){
            int x=(a&1);
            int y=(b&1);
            count+=x^y;
            a=a>>1;
            b=b>>1;
        }
        return count;
    }
}
