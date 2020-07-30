package Feb_28;
//https://leetcode.com/discuss/interview-question/522950/Facebook-or-Phone-or-Construct-smallest-number-from-given-digits

import java.util.Arrays;

public class ConstructNumber {
    public static void main(String[] args) {
        int arr[] = {8, 5, 2};
        int lowerBound = 800;
        int result = constructNum(arr, lowerBound);
        //System.out.println(result);

        int n = 218765;
        //int res = getNextNumber(n);
    }

    private static int getNextNumber(int n) {
        String numStr = String.valueOf(n);
        int index = -1;

        for (int i = numStr.length() - 1; i > 0; i--) {
            if (numStr.charAt(i - 1) < numStr.charAt(i)) {
                index = i;
                break;
            }
        }

        if (index == -1)
            return 0;
        char[] arr = numStr.toCharArray();
        int start = index;
        int end = numStr.length() - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        char temp = arr[index];
        arr[index] = arr[index - 1];
        arr[index - 1] = temp;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        return 0;
    }

    private static int constructNum(int[] arr, int lowerBound) {
        Arrays.sort(arr);
        String s = "";
        for (int i = 0; i < arr.length; i++)
            s += arr[i];
        int[] result = new int[1];
        getNumber(s, "", lowerBound, result);
        System.out.println(result[0]);
        // System.out.println(number);
        return 0;
    }

    private static void getNumber(String s, String curr, int lb, int[] result) {
        if (s.length() == 0) {
            if (lb < Integer.valueOf(curr) && result[0] == 0) {
                result[0] = Integer.valueOf(curr);
            }
            return;

        }
        for (int i = 0; i < s.length(); i++) {
            getNumber(s.substring(0, i) + s.substring(i + 1), curr + s.charAt(i), lb, result);
        }

    }


}
