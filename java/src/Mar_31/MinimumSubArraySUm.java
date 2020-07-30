package Mar_31;

import java.util.HashMap;

public class MinimumSubArraySUm {
    public static void main(String[] args) {
        // int[] arr = {2, 3, 1, 2, 4, 3};
        int[] arr = {1, 2, 3, 4, 5};
        int s = 11;
        //System.out.println(minSubArrayLen(s, arr));
        System.out.println(minSubArrayLen2(s, arr));

    }

    private static int minSubArrayLen2(int s, int[] arr) {
        if(arr==null || arr.length==0)
            return 0;
        int start = 0;
        int end = 0;
        int count = Integer.MAX_VALUE;
        int sum = 0;
        while (end < arr.length) {
            sum += arr[end];
            while (sum >= s) {
                count = Math.min(count, end - start + 1);
                sum -= arr[start];
                start++;
            }
            end++;
        }
        return count==Integer.MAX_VALUE ? 0:count;
    }

    public static int minSubArrayLen(int s, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = Integer.MAX_VALUE;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - s)) {
                count = Math.min(count, i - map.get(sum - s));
            }
            map.put(sum, i);
        }
        return count;
    }

    public int search(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}


