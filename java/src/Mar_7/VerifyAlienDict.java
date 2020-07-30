package Mar_7;

public class VerifyAlienDict {
    public static void main(String[] args) {
        String[] string = {"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        boolean result = getValid(string, order);
        System.out.println(result);
    }

    private static boolean getValid(String[] string, String order) {
        int[] seq = new int[26];
        for (int i = 0; i < order.length(); i++) {
            seq[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < string.length - 1; i++) {
            int length = Math.min(string[i].length(), string[i + 1].length());
            for (int j = 0; j < length; j++) {
                char a = string[i].charAt(j);
                char b = string[i + 1].charAt(j);
                if (a != b) {
                    if (seq[a - 'a'] > seq[b - 'a'])
                        return false;
                }
            }
            if (string[i + 1].length() < string[i].length())
                return false;
        }
        return true;
    }
}
