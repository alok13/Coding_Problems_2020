package Apr_20;


import java.util.*;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "123";
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "abc");
        map.put(2, "def");
        map.put(3, "hik");
        List<String> result = decodeWays(s, map);
        System.out.println(result);

    }

    public static void insertIntervals(int[][] intervals, int[][] newIntervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<Interval> list = new ArrayList<>();
        int index = 0;
        while (intervals[index][1] < newIntervals[0][0]) {
            list.add(new Interval(intervals[index][0], intervals[index][1]));
            index++;
        }
        int start = newIntervals[0][0];
        int end = newIntervals[0][1];
        while (start < intervals[index][1]) {
            end = intervals[index][1];
            index++;
        }
        list.add(new Interval(start, end));

        while (index < intervals.length) {
            list.add(new Interval(intervals[index][0], intervals[index][1]));
            index++;
        }

    }

    public static void mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        Interval curr = new Interval();
        curr.start = intervals[0][0];
        curr.end = intervals[0][1];
        List<Interval> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (curr.end < intervals[i][0]) {
                list.add(curr);
                curr.start = intervals[i][0];
                curr.end = intervals[i][1];
            } else {
                curr.end = intervals[i][1];
            }
        }

        list.add(curr);


    }


    public static Integer meetingRoom(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(arr[0][1]);

        for (int i = 1; i < arr.length; i++) {
            if (queue.peek() < arr[i][0]) {
                queue.poll();
            }
            queue.offer(arr[i][1]);
        }
        return queue.size();
    }

    public String minimumWindow(String str, String pattern) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int start = 0;
        int length = str.length() + 1;
        int minLeft = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char right = str.charAt(i);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) >= 0)
                    count++;
            }

            while (count == pattern.length()) {
                if (i - start + 1 < length) {
                    minLeft = start;
                    length = i - start + 1;
                }
                char left = str.charAt(start);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) > 0)
                        count--;
                }
            }
        }
        return str.substring(minLeft, minLeft + length + 1);
    }

    public List<Integer> findOrder(int n, int[][] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int inDegree[] = new int[n];
        for (int[] m : arr) {
            if (map.get(m[0]) == null)
                map.put(m[0], new ArrayList<>());
            List<Integer> list = map.get(m[0]);
            list.add(m[1]);
            map.put(m[0], list);
            inDegree[m[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int num : map.keySet()) {
            if (inDegree[num] == 0)
                queue.add(num);
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currClass = queue.poll();
            if (inDegree[currClass] == 0)
                result.add(currClass);
            List<Integer> classList = map.get(currClass);
            for (int i = 0; i < classList.size(); i++) {
                inDegree[classList.get(i)]--;
                queue.offer(classList.get(i));
            }
        }
        return result;
    }


    public static boolean regexMatching(String str, String pattern) {
        boolean[][] arr = new boolean[str.length() + 1][pattern.length() + 1];
        arr[0][0] = true;
        for (int i = 0; i < arr[0].length; i++) {
            arr[i] = arr[i - 2];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')
                    arr[i][j] = arr[i - 1][j - 1];
                if (pattern.charAt(j) == '*') {
                    if (pattern.charAt(j - 2) != str.charAt(i - 1) || pattern.charAt(j - 2) != '.')
                        arr[i][j] = arr[i][j - 2];
                    else {
                        arr[i][j] = arr[i - 1][j] || arr[i][j - 2] || arr[i][j - 1];
                    }
                }
            }
        }
        return arr[str.length()][pattern.length()];
    }

    public static int getWays(String str) {
        int[] arr = new int[str.length() + 1];
        arr[0] = 1;
        arr[1] = str.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < arr.length; i++) {
            int num1 = Integer.valueOf(str.substring(i - 1, i));
            int num2 = Integer.valueOf(str.substring(i - 2, i));
            if (num1 < 9 && num1 > 0)
                arr[i] = arr[i - 1] + 1;
            if (num2 < 99 && num2 > 10)
                arr[i] = arr[i - 2] + 1;
        }
        return arr[str.length()];
    }

    private static List<String> decodeWays(String s, HashMap<Integer, String> map) {
        List<String> result = new ArrayList<>();
        dfs(s, map, result, 0, "");
        return result;
    }

    private static void dfs(String s, HashMap<Integer, String> map, List<String> result, int index, String current) {
        if (index == s.length()) {
            result.add(current);
            return;
        }
        String num = map.get(Character.getNumericValue(s.charAt(index)));

        for (int i = 0; i < num.length(); i++) {
            dfs(s, map, result, index + 1, current + "" + num.charAt(i));
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval() {
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}