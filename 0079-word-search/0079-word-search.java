class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == word.charAt(0))
                    if (checkNextChar(board, word, 0, i, j)) return true;

        return false;
    }

    public boolean checkNextChar(char[][] board, String word, int idx, int i, int j){
        if(idx == word.length()) return true;
        if(i < 0 || i == board.length || j < 0 || j == board[0].length) return false;

        char temp = board[i][j];
        if(board[i][j] == word.charAt(idx)) {
            board[i][j] = ' ';
            idx++;
        }
        else return false;

        // down
        if(checkNextChar(board, word, idx, i+1, j)) return true;
        // up
        if(checkNextChar(board, word, idx, i-1, j)) return true;
        // right
        if(checkNextChar(board, word, idx, i, j+1)) return true;
        //left
        if(checkNextChar(board, word, idx, i, j-1)) return true;

        board[i][j] = temp;

        return false;
    }
}