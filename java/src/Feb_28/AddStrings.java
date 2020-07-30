package Feb_28;

//https://leetcode.com/problems/add-strings/
public class AddStrings {

    public static void main(String[] args) {
        String s1 = "12345640302.0023456";
        String s2 = "3453.34525678943";
        String str[] = s1.split(".");
        String str1[] = s2.split(".");
        int carry = 0;
        String decimalSum = getDecimalSum(str[1], str1[1], carry);
        String sum = getAddition(str[0], str1[0], carry);
        System.out.println(sum);
    }

    private static String getDecimalSum(String s, String s1, int carry) {
        int len1 = s.length();
        int len2 = s1.length();
        if (len1 > len2) {
            String temp = s;
            s = s1;
            s1 = temp;
        }
        return "";
    }

    private static String getAddition(String s1, String s2, int carry) {

        String answer = "";
        int length1 = s1.length() - 1;
        int length2 = s2.length() - 1;
        while (length1 >= 0 && length2 >= 0) {
            int num1 = Character.getNumericValue(s1.charAt(length1));
            int num2 = Character.getNumericValue(s2.charAt(length2));
            int sum = num1 + num2 + carry;
            int rem = sum % 10;
            carry = sum / 10;
            answer = rem + answer;

            length1--;
            length2--;
        }


        while (length1 >= 0) {
            int num1 = Character.getNumericValue(s1.charAt(length1));
            int sum = num1 + carry;
            int rem = sum % 10;
            carry = sum / 10;
            answer = rem + answer;
            length1--;
        }


        while (length2 >= 0) {
            int num1 = Character.getNumericValue(s2.charAt(length2));
            int sum = num1 + carry;
            int rem = sum % 10;
            carry = sum / 10;
            answer = rem + answer;
            length2--;
        }
        return answer;
    }
}
