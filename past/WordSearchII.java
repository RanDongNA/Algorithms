public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        
        Set<String> result = new HashSet<String>();

        if(board == null 
            || board.length == 0 
            || board[0] == null 
            || board[0].length == 0
            || words.size() == 0) {
            
            return new ArrayList<String>(result);
        }

        Trie trie = new Trie();        
        for(String word : words) {
            trie.insert(word);
        }

        boolean[][] visited
            = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, visited, "", trie, result);
            }
        }

        return new ArrayList<String>(result);
    }

    private void dfs(
        char[][] board, int x, int y,
        boolean[][] visited, 
        String prefix,
        Trie trie,
        Set<String> result) {

        if(visited[x][y]) {
            return;
        }

        String str = prefix + board[x][y];

        if(!trie.startsWith(str)) {
            return;
        }

        if(trie.search(str)) {
            result.add(str);
        }

        visited[x][y] = true;

        if(x + 1 < board.length) {
            dfs(board, x + 1, y, visited, str, trie, result);
        }
        if(x - 1 >= 0) {
            dfs(board, x - 1, y, visited, str, trie, result);
        }
        if(y + 1 < board[0].length) {
            dfs(board, x, y + 1, visited, str, trie, result);
        }
        if(y - 1 >= 0) {
            dfs(board, x, y - 1, visited, str, trie, result);
        }  

        visited[x][y] = false;

    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        Map<Character, TrieNode> children
            = root.children;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            TrieNode next;

            if(children.containsKey(c)) {
                next = children.get(c);
            } else {
                next = new TrieNode(c);
                children.put(c, next);
            }

            if(i == word.length() - 1) {
                next.isWord = true;
            }

            children = next.children;
        }        
    }

    public boolean search(String word) {
        TrieNode endNode = searchNode(word);
        
        if(endNode == null || !endNode.isWord) {
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children
            = root.children;

        TrieNode nodePtr = null;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(children.containsKey(c)) {
                nodePtr = children.get(c);
                children = nodePtr.children;
            } else {
                return null;
            }
        }

        return nodePtr;
    }
}

class TrieNode {
    char ch;
    HashMap<Character, TrieNode> children
        = new HashMap<Character, TrieNode>();
    boolean isWord;

    public TrieNode() {}
    public TrieNode(char c) {
        this.ch = c;
    }        
}


