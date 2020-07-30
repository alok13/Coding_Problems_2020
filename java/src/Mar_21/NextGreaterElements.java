package Mar_21;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 6};
        int result[] = getGreater(arr);
        System.out.println();
        for (int value : result) {
            System.out.print(" " + value);
        }


        int[] arr1 = {1, 5, 3, 7, 6};
        int ans = getResult(arr1);


    }

    private static int getResult(int[] arr) {

        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 0; i < arr.length; i++) {
            left[i] = i + 1;
            right[i] = length - i;
        }
        Stack<Integer> stack = new Stack<>();
        // previous less element
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        //next less element
        stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                right[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }


        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans = (ans + arr[i] * left[i] * right[i]);
        }
        return ans;

    }


    private static int[] getGreater(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        int length = arr.length;
        for (int i = 0; i < 2 * length; i++) {
            int index = i % length;
            int num = arr[index];
            while (!stack.isEmpty() && arr[stack.peek()] < num) {
                System.out.println("Num is " + num);
                int k = stack.pop();
                result[k] = num;
                System.out.println("Popping out index : " + k);
            }
            if (i < arr.length)
                stack.add(i);
        }
        return result;
    }
}
