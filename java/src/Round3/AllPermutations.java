package Round3;

public class AllPermutations {
    static int count = 0;

    public static void main(String[] args) {
        String str = "abc";

        findStrings("", str);
        System.out.println(count);

    }

    private static void findStrings(String s, String str) {
        if (str.length() == 0) {
            count++;
            System.out.println(s);
        }

        for (int i = 0; i < str.length(); i++) {

            findStrings(s + (str.charAt(i)), str.substring(0, i) + str.substring(i + 1));
        }
    }

}
