package Apr_5;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 1, 6, 3};
//        Stack<Integer> stack = new Stack<>();
//        int minElement = 0;
//        for (int i : arr) {
//            minElement = getMinmum(stack, i, minElement);
//
//            System.out.println("For i " + i + "min is " + minElement);
//        }
//        System.out.println("================================");
//        for (int i : arr) {
//            minElement = getMinmumPop(stack, i, minElement);
//
//            System.out.println("For i " + i + "min is " + minElement);
//        }

        String str = "aaabbb";
        int K = 3;
        int result = maxiMumSubstringWithAtleastKCharacher(str, K);
        int result1 = longestSubstring(str, K);
        System.out.println(result);
        // System.out.println(result1);
    }

    private static int getMinmumPop(Stack<Integer> stack, int i, int minElement) {
        if (stack.isEmpty())
            return 0;
        int x = stack.pop();
        if (x > minElement)
            return minElement;
        else {
            minElement = 2 * minElement - x;
        }
        return minElement;
    }

    private static int getMinmum(Stack<Integer> stack, int number, int minElement) {
        if (stack.isEmpty()) {
            stack.push(number);
            minElement = number;
        } else {
            if (number > minElement) {
                stack.push(number);
            } else {
                int y = 2 * number - minElement;
                stack.push(y);
                minElement = number;
            }
        }
        return minElement;
    }


    static int maxiMumSubstringWithAtleastKCharacher(String str, int K) {
        int result = 0;

        for (int i = 1; i <= 26; i++) {
            result = Math.max(result, maximumSubtringForK(str, K, i));
        }
        return result;
    }

    private static int maximumSubtringForK(String str, int K, int uniQueNumberTarget) {
        int[] map = new int[26];
        int numUnique = 0;
        int atLeastK = 0;

        int begin = 0;
        int end = 0;
        int result = 0;

        while (end < str.length()) {
            int endIndex = str.charAt(end) - 'a';
            if (map[endIndex] == 0) {
                numUnique++;
            }
            map[endIndex]++;
            if (map[endIndex] == K) {
                atLeastK++;
            }
            end++;
            int beginIndex = str.charAt(begin) - 'a';
            while (numUnique > uniQueNumberTarget) {
                if (map[beginIndex] == K)
                    atLeastK--;
                map[beginIndex]--;
                if (map[beginIndex] == 0)
                    numUnique--;
                begin++;
            }

            if (numUnique == uniQueNumberTarget && numUnique == atLeastK)
                result = Math.max(result, end - begin);
        }


        return result;
    }


    public static int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;

        for (h = 1; h <= 26; h++) {
            i = 0;
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                } else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }

        return max;
    }
}
