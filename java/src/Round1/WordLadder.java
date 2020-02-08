package Round1;//https://leetcode.com/problems/word-ladder/

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

        int result = getWordLadder(start, end, wordList);
        System.out.println(result);
    }

    private static int getWordLadder(String start, String end, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(start, 1));

        while (!queue.isEmpty()) {
            WordNode topWord = queue.remove();
            if (topWord.value.equals(end))
                return topWord.step;
            char[] wordArray = topWord.value.toCharArray();
            for (int i = 0; i < wordArray.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = wordArray[i];
                    if (temp == c)
                        continue;
                    ;
                    wordArray[i] = c;
                    String newString = new String(wordArray);
                    if (wordSet.contains(newString)) {
                        queue.add(new WordNode(newString, topWord.step + 1));
                        wordSet.remove(newString);
                    }
                    wordArray[i] = temp;
                }
            }
        }

        return 0;
    }
}

class WordNode {
    int step;
    String value;

    public WordNode(String value, int step) {
        this.step = step;
        this.value = value;
    }
}
