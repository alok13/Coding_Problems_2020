package Mar_31;

public class AddTwoBinary {
    public static void main(String[] args) {
        String str1 = "110";
        String str2 = "1010";
        String result = add(str1, str2);
        System.out.println(result);

    }

    private static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0){
                sum += b.charAt(j) - '0';
            }
            if (i >= 0){
                sum += a.charAt(i) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
