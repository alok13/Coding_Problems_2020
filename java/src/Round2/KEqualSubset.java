package Round2;

public class KEqualSubset {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 6};
        int K = 3;
        boolean result = getKEqualSubset(arr, K);
        System.out.println(result);
    }

    private static boolean getKEqualSubset(int[] arr, int k) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum <= 0 || sum % k != 0)
            return false;
        boolean[] visited = new boolean[arr.length];
        return canBePartioned(arr, visited, 0, 0, 0, k, sum / k);
    }

    private static boolean canBePartioned(int[] arr, boolean[] visited, int start_index, int cur_sum, int cur_num, int bucket, int target) {
        if (bucket == 1)
            return true;
        if (cur_sum == target && cur_num>0)
            return canBePartioned(arr, visited, 0, 0, 0, bucket - 1, target);
        for (int i = start_index; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canBePartioned(arr, visited, i+1, cur_sum + arr[i], cur_num++, bucket, target))
                    return true;
                else
                    visited[i] = false;
            }
        }
        return false;
    }
}
