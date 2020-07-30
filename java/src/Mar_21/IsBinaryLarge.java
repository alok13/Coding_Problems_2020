package Mar_21;

public class IsBinaryLarge {
    public static void main(String[] args) {
        //System.out.println(isLargerThanLONGMAXVALUE("9223372036854775807"));      // false
        //System.out.println(isLargerThanLONGMAXVALUE("9223372036854775806"));      // false
        System.out.println(isLargerThanLONGMAXVALUE("9223372036854775808"));      // true
        System.out.println(isLargerThanLONGMAXVALUE("645459223372036854775807")); // true
        System.out.println(isLargerThanLONGMAXVALUE("922"));                      // false

        System.out.println(isLargeer("9223372036854775808"));
    }

    private static boolean isLargeer(String s) {
        String num = String.valueOf(Long.MAX_VALUE);
        if (s.length() > num.length())
            return true;
        if (s.length() < num.length())
            return false;

        for (int i = 1; i < s.length(); i++) {
            long a = Long.valueOf(s.substring(0, i));
            long b = Long.valueOf(num.substring(0, i));
            if (a > b)
                return true;
            else if (a < b)
                return false;
        }
        System.out.println(Integer.parseInt(s.substring(s.length() - 1)) );
        System.out.println(Integer.parseInt(num.substring(num.length() - 1)) );
        return Integer.parseInt(s.substring(s.length() - 1)) > Integer.parseInt(num.substring(num.length() - 1));

    }

    public static boolean isLargerThanLONGMAXVALUE(String number) {
        String longMax = String.valueOf(Long.MAX_VALUE);
        if (number.length() > longMax.length()) return true;
        if (number.length() < longMax.length()) return false;
        long a, b = 0;
        for (int i = 1; i < number.length(); i++) {
            a = Long.parseLong(number.substring(0, i));
            b = Long.parseLong(longMax.substring(0, i));
            if (a > b) return true;
        }
        if (Integer.parseInt(number.substring(number.length() - 1)) >
                Integer.parseInt(longMax.substring(number.length() - 1, number.length()))) return true;
        return false;
    }
}

