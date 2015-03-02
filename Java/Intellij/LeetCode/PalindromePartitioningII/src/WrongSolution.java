import java.util.ArrayList;
import java.util.List;

/**
 * Created by Risky on 2014/10/27.
 */
public class WrongSolution {
    public int minCut(String s) {

        int cut = s.length() - 1;
        int length = s.length();

        boolean[][] cooccurrence = new boolean[length][length];

        for (int i = 0; i < length - 1; i++){
            cooccurrence[i][i] = cooccurrence[i][i] = true;
            for (int j = i + 1; j < length; j++){
                if (s.charAt(i) == s.charAt(j))
                    cooccurrence[i][j] = cooccurrence[j][i] = true;
                else
                    cooccurrence[i][j] = cooccurrence[j][i] = false;
            }
        }

        for (int i = 0; i < length; i++)
            for (int j = length - 1; j > i; j--){
                if (cooccurrence[i][j] && findPal(i,j,cooccurrence)){
                    cut -= j - i;
                    i += j - i;
                    break;
                }
            }




        return cut;
    }

    private boolean findPal(int i, int j, boolean[][] cooccurrence) {
        int m = j;
        int n = i;
        for (; m > n; m --,n++){
            if (!cooccurrence[n][m])
                return false;
        }

        return true;
    }


}