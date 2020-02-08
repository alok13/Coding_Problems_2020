package Round2;

public class ParanthesisGenerate {
    public static void main(String[] args) {
        int n = 4;
        printParanthesis("", n, n, n);
    }

    private static void printParanthesis(String str, int n, int left, int right) {
        if (left == 0 && right == 0) {
            System.out.println(str);
            return;
        }
        if (left > 0) {
            printParanthesis(str + "{", n, left - 1, right);
        }
        if (left < right) {
            printParanthesis(str + "}", n, left, right - 1);
        }

    }
}
