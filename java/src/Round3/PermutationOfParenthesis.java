package Round3;

public class PermutationOfParenthesis {
    public static void main(String[] args) {
        int n = 3;
        gerPermutation(n, n, "");
    }

    private static void gerPermutation(int left, int right, String s) {
        if (left == right && left == 0) {
            System.out.println(s);
            return;
        }
        if (right > left)
            gerPermutation(left, right - 1, s + ")");
        if(left>0)
            gerPermutation(left - 1, right, s+"(");

    }
}


