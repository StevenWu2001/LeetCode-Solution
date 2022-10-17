class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0, word, row, col, board)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, int curIdx, String word, int row, int col, char[][] board) {
        if (curIdx == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == '0' || board[i][j] != word.charAt(curIdx)) {
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = '0';
            
        if (dfs(i + 1, j, curIdx + 1, word, row, col, board) ||
            dfs(i - 1, j, curIdx + 1, word, row, col, board) ||
            dfs(i, j + 1, curIdx + 1, word, row, col, board) ||
            dfs(i, j - 1, curIdx + 1, word, row, col, board)) {
            return true;
        }
        board[i][j] = temp;
            
        return false;
    }
}
