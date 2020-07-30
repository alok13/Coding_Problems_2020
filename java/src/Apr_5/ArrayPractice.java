package Apr_5;

import java.util.*;

public class ArrayPractice {
    public static void main(String[] args) {
        String str = "abcdfdfafd";
        String str1 = "sdfsdfsdf";

        int length = getLongestSubSequence(str);
        //System.out.println(length);

//        String longest = getLongestSubstring(str);
//        int number = counntSubstring(str);
//        System.out.println(number);

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
        transposeMatrix(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    private List<String> getOrder(String[] arr) {
        ArrayList[] graph = new ArrayList[arr.length];
        int[] inDegree = new int[26];
        for (int i = 0; i < arr.length - 1; i++) {
            int length = Math.min(arr[i].length(), arr[i + 1].length());
            for (int j = 0; j < length; j++) {
                if (graph[j] == null)
                    graph[i] = new ArrayList();
                if (arr[i].charAt(j) != arr[i + 1].charAt(j)) {
                    graph[arr[i].charAt(j)].add(arr[i + 1].charAt(j));
                    inDegree[arr[i + 1].charAt(j) - 'a']++;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                char c = (char) (inDegree[i] + 'a');
                queue.add(c);
            }
        }
        List<Character> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (inDegree[c - 'a'] == 0) {
                list.add(c);
            }
            for (int i = 0; i < graph[c].size(); i++) {

            }
        }
        return null;
    }

    public static String longestPalindromicSubstring(String str) {

        boolean[][] arr = new boolean[str.length()][str.length()];
        int left = 0;
        int right = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                boolean isInner = i - j <= 2 || arr[j + 1][i - 1];
                if (str.charAt(i) == str.charAt(j) && isInner) {
                    arr[i][j] = true;
                    if (i - j > right - left) {
                        right = i;
                        left = j;
                    }
                }
            }
        }
        return str.substring(left, right + 1);
    }

    private static int decodeWays(String str) {
        int[] arr = new int[str.length() + 1];
        arr[0] = 1;
        arr[1] = str.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < arr.length; i++) {
            int first = Integer.valueOf(str.substring(i - 1, i));
            int second = Integer.valueOf(str.substring(i - 2, i));
            arr[i] = first + second;
        }
        return arr[arr.length];
    }

    private static int counntSubstring(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += test(str, i, i);
            count += test(str, i, i + 1);
        }
        return count;
    }

    private static int test(String str, int i, int j) {
        int count = 0;
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
            count++;
        }
        return count;
    }

    private static String getLongestSubstring(String str) {
        boolean[][] arr = new boolean[str.length()][str.length()];
        int left = 0;
        int right = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                boolean isPlain = i - j <= 2 || arr[j + 1][i - 1];
                if (str.charAt(i) == str.charAt(j) && isPlain) {
                    arr[j][i] = true;
                    if (i - j > right - left) {
                        right = i;
                        left = j;
                    }
                }
            }
        }
        return str.substring(left, right + 1);
    }


    private static int getLongestSubSequence(String str) {
        int[][] arr = new int[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i][i] = 1;
        }

        for (int d = 1; d < arr.length; d++) {
            for (int i = 0; i < arr.length - d; i++) {
                int j = d + i;
                if (str.charAt(i) == str.charAt(j)) {
                    arr[i][j] = arr[i + 1][j - 1] + 2;
                } else {
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);
                }
            }
        }

        return arr[0][arr.length - 1];

    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0)
            return false;

        int arr[] = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            int length = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < length; j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j))
                    if (arr[words[i].charAt(j) - 'a'] > arr[words[i + 1].charAt(j) - 'a'])
                        return false;
                    else
                        length = -1;

            }
            if (length != -1 && words[i].length() > words[i + 1].length())
                return false;
        }
        return true;
    }

    public int longestSubstring(String str) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            while (set.contains(str.charAt(i))) {
                set.remove(str.charAt(start));
                start++;
            }
            set.add(str.charAt(i));
            max = Math.max(max, set.size());
        }
        return 0;
    }
}
