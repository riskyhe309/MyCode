/**
 * Created by Risky on 2015/1/6.
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] result = new int[row][col];

        for (int i = row - 1; i >= 0 ; i--){
            boolean rowFlag = (i == (row - 1));

            for (int j = col - 1; j >= 0; j--){
                boolean colFlag = (j == (col - 1));

                int latterMinHealth  = 0;

                if (rowFlag && colFlag)
                    latterMinHealth  = 0;
                else if (rowFlag)
                    latterMinHealth = result[row - 1][j + 1];
                else if (colFlag)
                    latterMinHealth = result[i + 1][col - 1];
                else
                    latterMinHealth = Math.min(result[i + 1][j] , result[i][j + 1]);

                int minHeath = latterMinHealth - dungeon[i][j];

                result[i][j] = minHeath < 0? 0: minHeath;
            }
        }

        return result[0][0] + 1;

    }

}