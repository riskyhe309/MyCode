/**
 * Created by Risky on 2014/12/29.
 */
public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] column = s.toCharArray();

        int number = 0;
        int term = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int temNum = (int) column[i] - 64;
            number += temNum * term;
            term *= 26;
        }

        return number;

    }
}