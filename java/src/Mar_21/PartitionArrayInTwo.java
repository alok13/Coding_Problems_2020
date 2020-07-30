package Mar_21;

import java.util.HashMap;

public class PartitionArrayInTwo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 4};
        boolean result = divideInTwo(arr);
        System.out.println(result);
        int arr1[] = {4, 3, 2, 3, 5, 2, 1};
        boolean newResult = divideInK(arr1, 4);
        System.out.println(newResult);
    }

    private static boolean divideInK(int[] arr, int K) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum % K != 0)
            return false;
        boolean visited[] = new boolean[arr.length];
        return isPosssible(arr, sum / K, 0, 0, K, visited);
    }

    private static boolean isPosssible(int[] arr, int target, int index, int sum, int bucketLeft, boolean visited[]) {
        if (bucketLeft == 1)
            return true;

        if (sum == target)
           return isPosssible(arr, target, 0, 0, bucketLeft - 1, visited);
        for (int i = index; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (isPosssible(arr, target, i + 1, sum + arr[i], bucketLeft, visited))
                    return true;
                else
                    visited[i] = false;
            }
        }
        return false;
    }

    private static boolean divideInTwo(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum % 2 != 0)
            return false;

        return (getHalf(arr, 0, sum / 2, 0, new HashMap<String, Boolean>()));

    }

    private static boolean getHalf(int[] arr, int index, int target, int currentSum, HashMap<String, Boolean> map) {
        String current = index + "" + currentSum;
        if (map.containsKey(current))
            return map.get(current);
        if (currentSum == target)
            return true;
        if (currentSum > target || index >= arr.length)
            return false;

        boolean result = (getHalf(arr, index + 1, target, currentSum + arr[index], map) ||
                getHalf(arr, index + 1, target, currentSum, map));
        map.put(current, result);
        return result;
    }
}



