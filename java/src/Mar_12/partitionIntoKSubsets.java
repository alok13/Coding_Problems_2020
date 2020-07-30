package Mar_12;

public class partitionIntoKSubsets {

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        boolean result = getResult(arr, k);
        System.out.println(result);
    }

    private static boolean getResult(int[] arr, int k) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum % k != 0)
            return false;
        boolean[] visited = new boolean[arr.length];

        return canBePartitioned(arr, 0, visited, 0, k, sum / 4);

    }

    private static boolean canBePartitioned(int[] arr, int sum, boolean[] visited, int index, int K, int target) {
        if (K == 1)
            return true;
        if (sum == target)
            return canBePartitioned(arr, 0, visited, 0, K - 1, target);

        for (int i = index; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canBePartitioned(arr, sum + arr[i], visited, i + 1, K, target))
                    return true;
                else
                    visited[i] = false;
            }
        }
        return false;
    }
}
