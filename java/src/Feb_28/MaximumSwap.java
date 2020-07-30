package Feb_28;

public class MaximumSwap {
    public static void main(String[] args) {
        //int num = 115;
        int num = 9990199;
        int result = maximumSwap(num);
        System.out.println(result);
    }

    public static int maximumSwap(int num) {
        if (num == 0)
            return 0;
        String number = String.valueOf(num);
        char[] arr = number.toCharArray();
        int highestIndex = 0;
        char c = '\0'; // Initialize char like like
        for (int i = 1; i < arr.length; i++) {
            if (c <= arr[i] && arr[i - 1] < arr[i]) {
                highestIndex = i;
                c = arr[i];
            } else if (c == arr[i])// if same digit keepIncreasing the index of max
                highestIndex++;
        }

        for (int i = 0; i <= highestIndex; i++) {
            if (arr[i] < arr[highestIndex]) {
                char temp = arr[i];
                arr[i] = arr[highestIndex];
                arr[highestIndex] = temp;
                break;
            }
        }
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return Integer.valueOf(result);
    }
}


