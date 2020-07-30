package Mar_12;

import java.util.HashMap;

public class PartitionArrayEqualSubset {
    public static void main(String[] args) {
        //int arr[] = {1, 5, 11, 5};
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        boolean result = getResult(arr);
        System.out.println(result);
    }

    private static boolean getResult(int[] arr) {

        int sum = 0;
        for (int i : arr)
            sum += i;

        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        return getResult(arr,0,0,target/2,new HashMap<String,Boolean>());

    }

    private static boolean getResult(int[] arr, int index, int total, int target, HashMap<String,Boolean> state) {
        String current=index+""+total;
        if(state.containsKey(current))
            return state.get(current);
        if (total == target)
            return true;
        if (total > target || index >= arr.length)
            return false;
        boolean result =getResult(arr, index + 1, total, target,state) ||
                getResult(arr, index+1, total + arr[index], target,state);
        state.put(current,result);
        return result;
    }
}
