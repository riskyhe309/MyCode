/**
 * Created by Risky on 2014/12/12.
 */
public class Solution {


    int[] unitArray;
    boolean[] edge;

    public void solve(char[][] board) {


        if(board.length <= 2 || board[0].length <= 2)
            return;

        unitArray = new int[board.length * board[0].length];
        edge = new boolean[unitArray.length];

        //initial the array
        for (int i = 0; i < unitArray.length; i++)
            unitArray[i] = i;

        for (int i = 0; i < unitArray.length; i++) {
            int r = i / board[0].length;
            int c = i % board[0].length;
            edge[i] = (board[r][c] == 'O' &&
                    (r == 0 || r == board.length - 1 || c == 0 || c == board[0].length - 1));
        }

        // span the matrix
        for (int i = 0; i < unitArray.length; i++) {
            int r = i / board[0].length;
            int c = i % board[0].length;
            int up = r - 1;
            int pre = c - 1;
            //the unper field
            if (up >= 0 && board[r][c] == board[up][c])
                unit(i, i - board[0].length);
            //the pre field
            if (pre >=0 && board[r][c] == board[r][pre])
                unit(i, i - 1);
        }

        for (int i = 0; i < unitArray.length; i++) {
            int r = i / board[0].length;
            int c = i % board[0].length;
            if (board[r][c] =='O' && !edge[find(i)])
                board[r][c] = 'X';
        }

    }

    private void unit(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        boolean edgeU = this.edge[rootX] || this.edge[rootY];

        unitArray[rootX] = rootY;

        this.edge[rootY] = edgeU;
    }

    private int find(int x) {
        if (unitArray[x] == x) return x;
        unitArray[x] = find(unitArray[x]);
        return unitArray[x];
    }
}