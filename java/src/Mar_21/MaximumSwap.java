package Mar_21;

public class MaximumSwap {
    public static void main(String[] args) {
        int x = 983749;
        int result = getLargest(x);
        int results=nextPermutation(x);
        System.out.println(results);
    }

    //2,3,6,5,4,1
//Step1, from right to left, find the first number which not increase in a ascending order. In this case which is 3.
//Step2, here we can have two situations:
//
//We cannot find the number, all the numbers increasing in a ascending order.
// This means this permutation is the last permutation, we need to rotate back to the first permutation. So we reverse the whole array,
// for example, 6,5,4,3,2,1 we turn it to 1,2,3,4,5,6.
//
//We can find the number, then the next step, we will start from right most to leftward, try to find the first number which is larger than 3,
// in this case it is 4.
//Then we swap 3 and 4, the list turn to 2,4,6,5,3,1.
//Last, we reverse numbers on the right of 4, we finally get 2,4,1,3,5,6.
//
//Time complexity is: O(3*n)=O(n).
    private static int nextPermutation(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int index = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }
        int firstNumber = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[index] < arr[i]) {
                firstNumber = i;
                break;
            }
        }

        char temp = arr[index];
        arr[index] = arr[firstNumber];
        arr[firstNumber] = temp;

        swap(arr, index + 1, arr.length - 1);

        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return Integer.parseInt(s);

    }

    private static void swap(char[] arr, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private static int getLargest(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int index = 0;
        char c = '\0';

        for (int i = 1; i < arr.length; i++) {
            if (c <= arr[i] && arr[i] > arr[i - 1]) {
                c = arr[i];
                index = i;
            } else if (c == arr[i]) {
                index++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[index]) {
                char temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return Integer.parseInt(s);
    }
}
