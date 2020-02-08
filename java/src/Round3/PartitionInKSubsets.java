package Round3;

public class PartitionInKSubsets {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 6};
        int k = 3;
        int sum = 0;
        for (int a : arr)
            sum += a;
        boolean[] visited = new boolean[arr.length];
        boolean result = canKpartition(visited, 0, 0, sum / k, k, arr);
        System.out.println(result);
    }

    private static boolean canKpartition(boolean[] visited, int startIndex, int currentSum, int targetSum, int K, int[] arr) {
        if (K == 1)
            return true;

        if (currentSum == targetSum) {
            return canKpartition(visited, 0, 0, targetSum, --K, arr);
        }
        for (int i = startIndex; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canKpartition(visited, i + 1, currentSum + arr[i], targetSum, K, arr))
                    return true;
                else
                    visited[i] = false;
            }

        }
        return false;
    }


    

}
