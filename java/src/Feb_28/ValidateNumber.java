package Feb_28;

public class ValidateNumber {
    public static void main(String[] args) {
        String test = "2e33";
        boolean result = isValid(test);
        System.out.println(result);
    }

    private static boolean isValid(String test) {

        boolean seenNumber = false;
        boolean seenE = false;
        boolean seenDecimal = false;

        String curr = test.trim();

        for (int i = 0; i < curr.length(); i++) {
            char c = curr.charAt(i);
            switch (c) {
                case '.':
                    if (seenE || seenDecimal)
                        return false;
                    seenDecimal = true;
                    break;
                case 'e':
                    if (seenDecimal || !seenNumber)
                        return false;
                    seenE = true;
                    seenNumber = false;
                    break;
                case '+':
                case '-':
                    if (i != 0 && curr.charAt(i - 1) != 'e')
                        return false;
                    seenNumber = false;
                    break;

                default:
                    if (!Character.isDigit(c)) return false;
                    seenNumber = true;


            }
        }
        return seenNumber;
    }
}
