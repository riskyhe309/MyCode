/**
 * Created by Risky on 2014/12/12.
 */
public class Test {
    public static void main(String[] args){

       // char[][] board = {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        char[][] board = {{'X','X','X',},{'X','O','X'},{'X','X','X'}};

        Solution sl = new Solution();

        sl.solve(board);

        for (char[] row:board){
            for (char col:row)
                System.out.print(col+" ");
            System.out.println();
        }

    }
}
