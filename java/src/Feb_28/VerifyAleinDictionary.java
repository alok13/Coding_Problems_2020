package Feb_28;

public class VerifyAleinDictionary {
    public static void main(String[] args) {
        String[] words = {"word", "world", "row"};
//         String[] words = {"hello", "leetcode"};
//         String order = "hlabcdefgijkmnopqrstuvwxyz";
        String order = "worldabcefghijkmnpqstuvxyz";
        boolean result = isValid(words, order);
        System.out.println(result);
    }

    private static boolean isValid(String[] words, String order) {
        int arr[] = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            int length = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < length; j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j))
                    return (arr[words[i].charAt(j) - 'a'] < arr[words[i + 1].charAt(j) - 'a']);
                       // return false;


            }
            if (words[i].length() > words[i + 1].length())
                return false;
        }
        return true;
    }
}
