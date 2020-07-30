package Mar_21;

public class CustomSort {
    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";
        String result = customSortString(S, T);
        System.out.println(result);

    }

    public static String customSortString(String order, String target) {
        int[] arr = new int[26];
        //count T characters
        for (char ch : target.toCharArray()) {
            arr[ch - 'a']++;
        }
        // append S chars at the right order as many times as they appear in T
        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            while (arr[ch - 'a'] > 0) {
                sb.append(ch);
                arr[ch - 'a']--;
            }
        }
        //append the rest of the T characters
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                sb.append((char) (i + 'a'));
                arr[i]--;
            }
        }

        return sb.toString();
    }
}



