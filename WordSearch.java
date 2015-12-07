public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }

        if(board[0] == null || board[0].length == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean result = dfs(board, visited, i, j, word, 0);
                if(result) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(
        char[][] board, 
        boolean[][] visited, 
        int x, int y, String word, int iInWord) {

        if(iInWord >= word.length()) {
            return true;
        }

        if(visited[x][y] || word.charAt(iInWord) != board[x][y]) {
            return false;
        }

        visited[x][y] = true;
        if(x + 1 < board.length
            && dfs(board, visited, x + 1, y, word, iInWord + 1)) {
            return true;
        }
        if(x - 1 >= 0
            && dfs(board, visited, x - 1, y, word, iInWord + 1)) {
            return true;
        }
        if(y + 1 < board[0].length
            && dfs(board, visited, x, y + 1, word, iInWord + 1)) {
            return true;
        }
        if(y - 1 >= 0
            && dfs(board, visited, x, y - 1, word, iInWord + 1)) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }
}
