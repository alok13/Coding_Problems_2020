package Round2;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] arr = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int width = 20;
        List<String> result = getJustification(arr, width);
        for (String s : result)
            System.out.println(s);
    }

    private static List<String> getJustification(String[] arr, int width) {
        List<String> result = new ArrayList<>();
        int left = 0;
        while (left < arr.length) {
            int right = findRight(left, arr, width);
            result.add(justify(left, right, arr, width));
        }
        return result;
    }

    private static int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();

        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();

        return right - 1;
    }

    private static String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words[i])
                    .append(space)
                    .append(remainder-- > 0 ? " " : "");

        return padResult(result.toString().trim(), maxWidth);
    }

    private static int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }

    private static String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private static String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }

}
