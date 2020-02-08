package Round1;

import java.util.Arrays;

public class ReverseWordOfSentence {
    public static void main(String[] args) {
        String s = "I want to work at Amazon";
        String result = reverseSentence(s);
        System.out.println(result);
    }

    private static String reverseSentence(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            sb = sb.append(arr[i]);
            sb = sb.append(" ");
        }
        return sb.toString();
    }
}
