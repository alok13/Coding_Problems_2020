package Apr_5;

import java.util.*;

public class DecodeWays {
    public static void main(String[] args) {
        String str = "226";
        int result = getWays(str);
        System.out.println(result);

        int[] arr = {2, 1, 3};
        List<String> results = getSubSet(arr);
        System.out.println(results);

        int nums[] = {1, 1, 1, 2, 2, 3, 3};
        int resultss = removeDuplicates(nums);
        System.out.println(resultss);

        String a = "a/b/c/../.";
        String r = simplifyPath(a);
        System.out.println(r);

        int num = 12;
        int sqr = getRoot(num);
        System.out.println(sqr);

        String s1 = "111";
        String s2 = "1";
        String addedResult = addTwoNumber(s1, s2);
        System.out.println(addedResult);

        Integer[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        Integer[] newInterval = {4, 8};

        List<Intervals> mergeedIntervals = mergeInterval(intervals, newInterval);
        System.out.println(mergeedIntervals);

        Integer[][] intervalsToMerge = {{1, 2}, {3, 5}, {6, 9}, {8, 10}, {12, 16}};
        List<Intervals> ans = mergeAgain(intervalsToMerge);
        System.out.println(ans);

        System.out.println(myPow(2, -3));

        String str1 = "25";
        String str2 = "12";
        System.out.println(multiply(str1, str2));

    }

    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    public boolean KMP(char []text, char []pattern){

        int lps[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            return (n % 2 == 0) ? myPow(x * x, -(n / 2)) : x * myPow(x * x, -(n / 2));
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    private static List<Intervals> mergeAgain(Integer[][] intervalsToMerge) {
        int start = intervalsToMerge[0][0];
        int end = intervalsToMerge[0][1];
        List<Intervals> result = new ArrayList<>();
        for (int i = 0; i < intervalsToMerge.length; i++) {
            if (intervalsToMerge[i][0] < end)
                end = intervalsToMerge[i][1];
            else {
                result.add(new Intervals(start, end));
                start = intervalsToMerge[i][0];
                end = intervalsToMerge[i][1];
            }
        }
        result.add(new Intervals(start, end));
        return result;
    }

    public List<Intervals> insert(List<Intervals> intervals, Intervals newInterval) {
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) i++;
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Intervals(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i, newInterval);
        return intervals;
    }

    private static List<Intervals> mergeInterval(Integer[][] intervals, Integer[] newInterval) {
        List<Intervals> list = new ArrayList<>();
        for (Integer[] inter : intervals) {
            list.add(new Intervals(inter[0], inter[1]));
        }

        Intervals newInt = new Intervals(newInterval[0], newInterval[1]);
        int i = 0;
        List<Intervals> result = new ArrayList<>();
        while (i < list.size() && list.get(i).end < newInt.start) {
            result.add(list.get(i));
            i++;
        }
        while (i < list.size() && list.get(i).start <= newInt.end) {
            newInt = new Intervals(Math.min(list.get(i).start, newInt.start), Math.max(list.get(i).end, newInt.end));
            i++;
        }
        result.add(newInt);

        while (i < list.size()) {
            result.add(list.get(i));
            i++;
        }
        return result;

    }

    private static String addTwoNumber(String s1, String s2) {
        int n1 = s1.length() - 1;
        int n2 = s2.length() - 1;
        int carry = 0;
        String result = "";
        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            int num1 = n1 < 0 ? 0 : s1.charAt(n1) - '0';
            int num2 = n2 < 0 ? 0 : s2.charAt(n2) - '0';
            int sum = num1 + num2 + carry;
            result = result + sum % 2;
            carry = sum / 2;
            n1--;
            n2--;
        }
        return new StringBuilder(result).reverse().toString();
    }

    private static int getRoot(int num) {
        int start = 0;
        int right = num / 2;
        int ans = 0;
        while (start <= right) {
            int mid = start + (right - start) / 2;
            if (mid <= num / mid) {
                start = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }


    public static int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1])
                nums[index++] = nums[i + 1];
        }
        return index;

    }

    private static List<String> getSubSet(int[] arr) {
        List<String> result = new ArrayList<>();
        Arrays.sort(arr);
        getAllSubSet(arr, result, 0, "");
        return result;
    }

    private static void getAllSubSet(int[] arr, List<String> result, int index, String currString) {
        result.add(currString);

        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i - 1] == arr[i]) continue;
            getAllSubSet(arr, result, i + 1, currString + "" + arr[i]);
        }
    }

    private static int getWays(String str) {
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = str.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i < dp.length; i++) {
            int num1 = Integer.valueOf(str.substring(i - 1, i));
            int num2 = Integer.valueOf(str.substring(i - 2, i));
            if (num1 >= 1 && num1 <= 9)
                dp[i] = dp[i] + dp[i - 1];
            if (num2 >= 10 && num2 <= 26)
                dp[i] = dp[i] + dp[i - 2];

        }
        return dp[str.length()];
    }
}

class Intervals {
    int start;
    int end;

    Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Intervals{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}