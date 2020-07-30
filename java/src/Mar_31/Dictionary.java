package Mar_31;

import java.util.HashMap;

public class Dictionary {
    private class TrieNode {
        private boolean isWord;
        private HashMap<Character, TrieNode> childList;

        public TrieNode() {
            isWord = false;
            childList = new HashMap<Character, TrieNode>();
        }
    }

    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.childList.containsKey(word.charAt(i))) {
                curr.childList.put(word.charAt(i), new TrieNode());
            }
            curr = curr.childList.get(word.charAt(i));
        }
        curr.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }

    private boolean searchHelper(TrieNode node, int pos, String word) {
        //if the word has all been scanned, return
        if (pos == word.length()) {
            return node.isWord;
        }
        //reach the leaf before finishing scanning the word
        if (node.childList.size() == 0) {
            return false;
        }

        //if the character at current position is '.',
        //recursive check whether the remaing word is in the trie
        if (word.charAt(pos) == '.') {
            for (Character c : node.childList.keySet()) {
                if (searchHelper(node.childList.get(c), pos + 1, word)) {
                    return true;
                }
            }
        }

        //if character at position 'pos' is neither equal to the node nor '.', return false
        if (!node.childList.containsKey(word.charAt(pos))) {
            return false;
        }

        //if character at current position matches the node,
        //recursively search the remaining word
        return searchHelper(node.childList.get(word.charAt(pos)), pos + 1, word);
    }
}
