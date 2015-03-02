/**
 * Created by Risky on 2014/12/11.
 */
public class RecurrenceSolution {


    public void solve(char[][] board) {


        if(board.length < 2 || board[0].length < 2)
            return;


        int row = board.length;
        int column = board[0].length;

        // span the external edge
        for(int i = 0; i < row; i++){
            dfs(board, i, 0, row, column);
            dfs(board, i, column - 1, row, column);
        }

        for(int j = 0; j < column; j++){

            dfs(board, 0, j, row, column);
            dfs(board, row - 1, j, row, column);
        }

        for(int i = 0; i < row; i++)
            for(int j = 0; j < column; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '*') board[i][j] = 'O';
            }
    }

    public void dfs(char[][] board, int r, int c, int row,  int column){

        if(r < 0 || r >= row || c < 0 || c >= column || !(board[r][c] == 'O')) return;

        board[r][c] = '*';
        dfs(board, r - 1, c, row, column);
        dfs(board, r + 1, c, row, column);
        dfs(board, r, c - 1, row, column);
        dfs(board, r, c + 1, row, column);
    }
}
