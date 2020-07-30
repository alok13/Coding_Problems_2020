package Round4;

import java.util.ArrayList;
import java.util.List;

public class GenerateIPAddress {
    public static void main(String[] args) {

                longestPalindrome("abcd");
                for(int i=0;i<4;i++){
            for(int j=0;j<=i;j++){
                System.out.print(j+ ""+i+"   ");
            }
            System.out.println();
        }
    }


    public static String longestPalindrome(String s) {
        if(s==null || s.length()<2)
            return s;

        int length=s.length();
        boolean [][] isPalindrome=new boolean[length][length];

        int right=0;
        int left=0;

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                boolean isInnerWordPalindrome= i-j<=2 || isPalindrome[j+1][i-1]  ;
                if(s.charAt(i)==s.charAt(j) && isInnerWordPalindrome){
                    isPalindrome[j][i]=true;

                    if(i-j>right-left){
                        right=i;
                        left=j;
                    }
                }
            }
        }
        return s.substring(left,right+1);

    }

    private static void generateIps3(String input, int index, String result, int count) {
        if (count > 4)
            return;
        if (count == 4 && index == input.length()) {
            System.out.println(result);
        }

        for (int i = 0; i <= 2; i++) {
            if (index + i + 1 > input.length()) break;
            String str = input.substring(index, index + i + 1);
            if ((str.startsWith("0") && str.length() > 1) || (i == 2 && Integer.parseInt(str) > 255)) continue;
            generateIps3(input, index + i + 1, result + "." + str, count + 1);
        }
    }

    private static void generateIps2(String ip, int idx, String restored, int count, List<String> solution) {
        if (count > 4)
            return;
        if (count == 4 && idx == ip.length()) {
            System.out.println(restored);
            System.out.println("here");
            solution.add(restored);
            // return;
        }


        for (int i = 0; i <= 2; i++) {
            if (idx + i > ip.length()) break;
            String s = ip.substring(idx, idx + i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) continue;
            generateIps2(ip, idx + i, restored + "." + s, count + 1, solution);
        }
    }

    private static void generateIps(String input, int start, String result, int part) {
        if (start >= input.length() - 1 && result.length() == input.length() + 3) {
            System.out.println(result);
            return;
        }
        if (part == 4 && input.length() - start >= 4)
            return;
        if (part >= 5)
            return;

        for (int i = 0; i <= 2; i++) {
            String subString = input.substring(start, Math.min(start + i + 1, input.length()));
            int num = Integer.valueOf(subString);
            if (num > 255)
                continue;
            String res = result;
            result = result.length() == 0 ? subString : result + "." + subString;
            generateIps(input, start + i + 1, result, part + 1);
            result = res;
        }
    }


}
