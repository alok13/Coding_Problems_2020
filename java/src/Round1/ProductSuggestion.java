package Round1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProductSuggestion {

    public static void main(String[] args) {
        String searchWord = "mouse";
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        List<List<String>> result = suggestedProducts(products, searchWord);
        System.out.println(result);
    }

    private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String p : products) {
            Trie t = root;
            for (char c : p.toCharArray()) {
                if (t.sub[c - 'a'] == null)
                    t.sub[c - 'a'] = new Trie();
                t = t.sub[c - 'a'];
                t.recommmendation.add(p);
                Collections.sort(t.recommmendation);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if (root != null) {
                root = root.sub[c - 'a'];
                result.add(root == null ? new ArrayList<>() : root.recommmendation);
            }
        }
        return result;
    }
}

class Trie {
    Trie[] sub = new Trie[26];
    LinkedList<String> recommmendation = new LinkedList<>();
}
