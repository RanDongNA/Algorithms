public class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        Map<Character, TrieNode> children = root.children;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(!children.containsKey(ch)) {
                children.put(ch, new TrieNode(ch));
            }

            node = children.get(ch);
            children = node.children;
        }

        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(root, word);
    }

    private boolean searchHelper(TrieNode root, String word) {
        if(word == null || word.length() == 0) {
            return root.isWord;
        }

        Map<Character, TrieNode> children = root.children;
        
        TrieNode ptr = null;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if(ch == '.') {
                for(TrieNode node : children.values()) {
                    if(searchHelper(node, word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }else if(!children.containsKey(ch)) {
                return false;
            } else {
                ptr = children.get(ch);
                children = ptr.children;
            }
        }
        
        return ptr.isWord;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

class TrieNode {
    char value;
    HashMap<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        value = '-';
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }

    public TrieNode(char ch) {
        this.value = ch;
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }
}
