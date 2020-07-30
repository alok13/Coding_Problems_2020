package CTCI.ArrayStrings;

//Implement a method to perform basic string compression using the counts
//of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
//"compressed" string would not become smaller than the original string, your method should return
//the original string. You can assume the string has only uppercase and lowercase letters (a - z)
public class StringCompression {
    public static void main(String[] args) {
        String str = "aabcccccaaad";
        String result = compressString(str);
        System.out.println(result);
    }

    private static String compressString(String str) {
        int count = 1;
        char currentChar = str.charAt(0);
        String test = "";
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1))
                count++;
            else {
                test = test + currentChar + count;
                currentChar = str.charAt(i);
                count = 1;
            }
        }
        test = test + currentChar + count;
        return test;
    }
}
