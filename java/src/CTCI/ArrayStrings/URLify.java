package CTCI.ArrayStrings;

//Write a method to replace all spaces in a string with '%20'. You may assume that the string
//has sufficient space at the end to hold the additional characters, and that you are given the "true"
//length of the string.(Note: If implementing in Java, please use a character array so that you can
//perform this operation in place.)
public class URLify {
    public static void main(String[] args) {
        String str = "Mr John Smith   ";
        String result = urliFy(str);
        System.out.println(result);
    }

    private static String urliFy(String str) {
        return str.trim().replace(" ", "%20");
    }
}
