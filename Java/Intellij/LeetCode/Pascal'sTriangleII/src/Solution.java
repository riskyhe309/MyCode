import java.util.LinkedList;
import java.util.List;

/**
 * Created by Risky on 2015/1/24.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {

        int[] temp = new int[rowIndex + 2];

        temp[1] = 1;

        List<Integer> result = new LinkedList<Integer>();

        for(int i = 1 ; i <= rowIndex; i++){
            for(int j = i; j > 0; j--)
                temp[j] = temp[j] + temp[j - 1];

        }

        for(int p = 1; p <= rowIndex; p++){
            result.add(temp[p]);
        }

        return result;

    }
}