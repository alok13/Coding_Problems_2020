package June_21;

import java.util.*;

public class Intervals {
    public static void main(String[] args) {
        int[][] arr = {{0, 10}, {10, 15}, {5, 15}};
        int result = getClassRooms(arr);
        // System.out.println(result);

        int n = 7;
        int result1 = getSetBit(n);
        //System.out.println(result1);

        int arr1[] = {3, 2, 4, 4};
        int k = 3;
        int Klargest = findKLargest(arr1, k);
        ///System.out.println(Klargest);
        //List<List<Integer>> res = getSubsets(arr1);
        List<List<Integer>> res = getPermutation(arr1);
        System.out.println(res);
        String str = "25525511135";
        System.out.println(generateIps(str));
    }

    private static List<List<Integer>> getPermutation(int[] arr1) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr1);
        boolean visited[] = new boolean[arr1.length];
        generatePermutate(result, arr1, new ArrayList<>(), visited);
        return result;
    }

    private static void generatePermutate(List<List<Integer>> result, int[] arr1, ArrayList<Integer> integers, boolean visited[]) {
        if (integers.size() == arr1.length) {
            result.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (visited[i] || i > 0 && arr1[i - 1] == arr1[i] && !visited[i - 1]) continue;
            visited[i] = true;
            integers.add(arr1[i]);
            generatePermutate(result, arr1, integers, visited);
            integers.remove(integers.size() - 1);
            visited[i] = false;
        }
    }

    private static List<List<Integer>> getSubsetsDuplicate(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(result, new ArrayList<>(), arr, 0);
        return result;
    }

//    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
//        list.add(new ArrayList<>(tempList));
//        for (int i = start; i < nums.length; i++) {
//            if (i > start && nums[i] == nums[i - 1]) continue;
//            tempList.add(nums[i]);
//            backtrack(list, tempList, nums, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }
//    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    private static List<List<Integer>> getSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubSet(result, arr, 0, new ArrayList<Integer>());
        //backtrack(result, new ArrayList<Integer>(),arr, 0 );
        return result;
    }

//    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
//        list.add(new ArrayList<>(tempList));
//        for (int i = start; i < nums.length; i++) {
//            tempList.add(nums[i]);
//            backtrack(list, tempList, nums, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }
//    }

    private static void generateSubSet(List<List<Integer>> result, int[] nums, int start, ArrayList<Integer> tempList) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            generateSubSet(result, nums, i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    private static int findKLargest(int[] arr, int k) {
        int target = arr.length - k;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int pivot = getPivot(arr, start, end);
            if (pivot < target)
                start++;
            else if (pivot > target)
                end--;
            else
                return arr[pivot];
        }
        return arr[start];
    }

    private static int getPivot(int[] arr, int start, int end) {
        int pivot = start;
        while (start <= end) {
            while (start <= end && arr[pivot] >= arr[start]) {
                start++;
            }
            while (start <= end && arr[pivot] < arr[end]) {
                end--;
            }
            if (start > end)
                break;
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        int temp = arr[pivot];
        arr[pivot] = arr[end];
        arr[end] = temp;
        return end;
    }

    private static int getSetBit(int n) {
        int count = 0;
        while (n != 0) {
            n = n >>> 1;
            count++;
        }
        return count;
    }

    public static List<String> generateIps(String input) {
        List<String> result = new ArrayList<>();
        generateIpsAll(result, input, "", 0, 0);
        return result;
    }

    private static void generateIpsAll(List<String> result, String str, String res, int index, int count) {
        if (index > str.length() || count > 4)
            return;
        if (index == str.length() && count == 4) {
            result.add(res);
            System.out.println(res);
            return;
        }

        for (int i = 0; i <= 2; i++) {
            if (index + i + 1 > str.length()) break;
            String currentNumber = str.substring(index, index + i + 1);
            int number = Integer.parseInt(currentNumber);
            if (i == 2 && number > 255) continue;
            generateIpsAll(result, str, res + "." + currentNumber, index + i + 1, count + 1);
        }
    }

    private static List<Innterval> mergeInterval(Integer[][] toMerge) {
        int start = toMerge[0][0];
        int end = toMerge[0][1];
        List<Innterval> list = new ArrayList<>();

        for (int i = 0; i < toMerge.length; i++) {
            if (end > toMerge[i][0]) {
                end = toMerge[i][1];
            } else {
                list.add(new Innterval(start, end));
                start = toMerge[i][0];
                end = toMerge[i][1];
            }
        }
        list.add(new Innterval(start, end));
        return list;
    }

    private static List<Innterval> mergeInterval(Integer[][] intervals, Integer[] newInterval) {
        List<Innterval> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(new Innterval(intervals[i][0], intervals[i][1]));
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            result.add(new Innterval(Math.min(newInterval[0], intervals[i][0]), Math.max(intervals[i][1], newInterval[1])));
            i++;
        }
        while (i < intervals.length) {
            result.add(new Innterval(intervals[i][0], intervals[i][1]));
        }
        return result;
    }

    private static int getClassRooms(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);

        for (int i = 1; i < arr.length; i++) {
            if (pq.peek() <= arr[i][0]) {
                pq.remove();
            }
            pq.add(arr[i][1]);
        }
        return pq.size();
    }
}


class Innterval {
    int start;
    int end;

    public Innterval(int start, int end) {
    }
}
