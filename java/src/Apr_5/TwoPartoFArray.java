package Apr_5;

import java.util.*;

public class TwoPartoFArray {
    public static void main(String[] args) {
        int[] arr = {12, 3, 4};
        //boolean result = getSum(arr);
        //System.out.println(keyboard("012"));

        int tst[][] = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {21, 22, 23, 24, 25},
                {31, 32, 33, 34, 35}};

        int arr1[] = {1, 2, 3};
        // System.out.println(getAllSubSets(arr1));
        System.out.println(getAllPermutation(arr1));

        int arr2[] = {1, 2, 2};
        //System.out.println(getAllSubSetWithoutDup(arr2));
    }

    private static List<List<Integer>> getAllPermutation(int[] arr1) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutate(arr1, result, 0, new ArrayList<>());
        return result;
    }

    private static void getPermutate(int[] arr1, List<List<Integer>> result, int index, ArrayList<Integer> list) {
        if (list.size() == arr1.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if(list.contains(arr1[i])) continue; // e
                list.add(arr1[i]);
                getPermutate(arr1, result, i + 1, list);
                list.remove(list.size() - 1);
            }
        }

    }

    private static List<List<Integer>> getAllSubSetWithoutDup(int[] arr2) {
        Arrays.sort(arr2);
        List<List<Integer>> result = new ArrayList<>();
        getAllPos(arr2, 0, new ArrayList<>(), result);
        return result;
    }

    private static void getAllPos(int[] arr2, int index, ArrayList<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));

        for (int i = index; i < arr2.length; i++) {
            if (i > index && arr2[i] == arr2[i - 1])
                continue;
            list.add(arr2[i]);
            getAllPos(arr2, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }


    private static List<List<Integer>> getAllSubSets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        getAllSet(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void getAllSet(int[] arr, int index, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            getAllSet(arr, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    private static boolean getSum(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        int target = sum / 2;

        return getResult(arr, target, 0, sum, new HashMap<String, Boolean>());
    }

    private static boolean getResult(int[] arr, int target, int index, int sum, HashMap<String, Boolean> map) {
        if (sum == target)
            return true;
        if (map.containsKey(index + "" + sum))
            return map.get(index + "" + sum);


        if (index > arr.length)
            return false;

        for (int i = index; i < arr.length; i++) {
            boolean result = getResult(arr, target, index + 1, sum, map) || getResult(arr, target, index + 1, sum + arr[i], map);
            map.put(index + "" + sum, result);
            return result;
        }
        return false;
    }


    boolean canPartitionInK(int[] arr, int K) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % K != 0)
            return false;
        int target = sum / K;
        boolean visited[] = new boolean[arr.length];
        return checkPartition(arr, K, target, 0, 0, visited);
    }

    private boolean checkPartition(int[] arr, int K, int target, int index, int currSum, boolean[] visited) {
        if (K == 1)
            return true;
        if (currSum == target) {
            return checkPartition(arr, K - 1, target, 0, 0, visited);
        }
        if (currSum > target)
            return false;
        for (int i = index; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                boolean result = checkPartition(arr, K, target, index + 1, currSum + arr[i], visited);
                if (!result)
                    visited[i] = false;
            }
        }
        return false;

    }

    public boolean longestPalindorme(String s) {
        if (s.length() < 2)
            return true;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                boolean isInnerWordPalindrome = (i - j <= 2 || dp[j + 1][i - 1]);
                if (s.charAt(i) == s.charAt(j) && isInnerWordPalindrome)
                    dp[i][j] = true;
            }
        }
        return true;
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            if (graph[prerequisites[i][1]] == null)
                graph[prerequisites[i][1]] = new ArrayList();
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currClass = queue.poll();

            if (inDegree[currClass] == 0)
                result.add(currClass);

            List<Integer> classList = graph[currClass];

            for (int i = 0; i < classList.size(); i++) {
                queue.add(classList.get(i));
                inDegree[i]--;
            }
        }
        return result.size() == numCourses;
    }

    static List<String> keyboard(String str) {
        String[] map = {"abc", "def", "ijk"};
        List<String> result = new ArrayList<>();
        getCombo(str, 0, result, map, "");
        return result;
    }

    private static void getCombo(String str, int index, List<String> result, String[] map, String current) {
        if (index == str.length()) {
            result.add(current);
            return;
        }
        int num = Character.getNumericValue(str.charAt(index));
        for (int i = 0; i < map[num].length(); i++) {
            getCombo(str, index + 1, result, map, current + map[num].charAt(i));
        }

    }

    // Function to check if characters in the input string
    // follows the same order as determined by characters
    // present in the given pattern
    static boolean checkPattern(String str, String pattern) {
        // len stores length of the given pattern
        int len = pattern.length();
        // if length of pattern is more than length of
        // input string, return false;
        if (str.length() < len) {
            return false;
        }
        for (int i = 0; i < len - 1; i++) {
            // x, y are two adjacent characters in pattern
            char x = pattern.charAt(i);
            char y = pattern.charAt(i + 1);
            // find index of last occurrence of character x
            // in the input string
            int last = str.lastIndexOf(x);
            // find index of first occurrence of character y
            // in the input string
            int first = str.indexOf(y);
            // return false if x or y are not present in the
            // input string OR last occurrence of x is after
            // the first occurrence of y in the input string
            if (last == -1 || first
                    == -1 || last > first) {
                return false;
            }
        }
        // return true if string matches the pattern
        return true;
    }

    int findMededianOFTwoArray(int[] arr1, int arr2[]) {
        if (arr1.length > arr2.length)
            return findMededianOFTwoArray(arr2, arr1);
        int start = 0;
        int end = arr1.length;
        int median = 0;
        while (start <= end) {
            int midX = start + (end - start) / 2;
            int midY = (arr1.length + arr2.length + 1) / 2 - midX;

            int leftX = arr1[midX - 1];
            int rightX = arr1[midX];
            int leftY = arr2[midY - 1];
            int rightY = arr2[midY];

            if (leftX <= rightY && leftY <= rightX) {
                if ((arr1.length + arr2.length) % 2 == 0) {
                    median = (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2;
                } else
                    median = Math.max(leftX, leftY);
            } else if (leftX > rightY) {
                end = midX - 1;
            } else {
                start = midX + 1;
            }
        }
        return median;
    }

    int largestSumOFNonAdjacentArray(int[] arr) {

        int[] sum = new int[arr.length];

        sum[0] = arr[0];
        sum[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            sum[i] = Math.max(arr[i - 1], arr[i - 2] + arr[i]);
        }
        return arr[arr.length - 1];
    }

    int numberOfIsland(int arr[][]) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    dfs(arr, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0)
            return;
        arr[i][j] = 0;
        dfs(arr, i + 1, j);
        dfs(arr, i - 1, j);
        dfs(arr, i, j + 1);
        dfs(arr, i, j - 1);
    }

    int getTrappedWater(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        while (start <= end) {
            leftMax = Math.max(leftMax, arr[start]);
            rightMax = Math.max(rightMax, arr[end]);
            if (leftMax < rightMax) {
                sum += leftMax - arr[start];
                start++;
            } else {
                sum += rightMax - arr[end];
                end--;
            }

        }
        return sum;
    }

    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());
        queue.addAll(map.entrySet());
        int count = 0;
        while (!queue.isEmpty()) {
            int interval = n + 1;
            List<Map.Entry<Character, Integer>> lsit = new ArrayList<>();
            while (interval > 0 && queue.isEmpty()) {
                Map.Entry<Character, Integer> curr = queue.poll();
                interval--;
                curr.setValue(curr.getValue() - 1);
                lsit.add(curr);
                count++;
            }

            for (Map.Entry<Character, Integer> curr : lsit) {
                if (curr.getValue() > 0)
                    queue.add(curr);
            }

            count += interval;


        }
        return count;
    }

    int maximumSwap(int n) {
        String num = String.valueOf(n);
        char c = '\0';
        int index = 0;
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) < num.charAt(i + 1)) {
                if (num.charAt(i + 1) >= c) {
                    c = num.charAt(i + 1);
                    index = i + 1;
                }
            }
        }
        int chaneIndex = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) < c) {
                chaneIndex = i;
                break;
            }
        }

        char[] array = num.toCharArray();
        char temp = array[chaneIndex];
        array[chaneIndex] = array[index];
        array[index] = temp;

        return Integer.parseInt(new String(array));
    }

    int nextPermutation(int n) {
        int index = 0;
        String str = String.valueOf(n);
        for (int i = str.length() - 2; i >= 0; i++) {
            if (str.charAt(i) < str.charAt(i + 1)) {
                index = i;
                break;
            }
        }

        char c = str.charAt(index);
        int changeIndex = 0;
        for (int i = str.length() - 1; i >= 0; i++) {
            if (str.charAt(i) > c) {
                changeIndex = i;
            }
        }

        char[] arr = str.toCharArray();
        char temp = arr[changeIndex];
        arr[changeIndex] = arr[index];
        arr[index] = temp;

        int end = arr.length - 1;

        while (index + 1 < end) {
            char cc = arr[index + 1];
            arr[index + 1] = arr[end];
            arr[end] = cc;
            index++;
            end--;
        }
        return Integer.parseInt(new String(arr));
    }


}



