/**
 * Created by Risky on 2014/12/23.
 */
public class Solution {
    public String convertToTitle(int n) {

        int res = n;
        //int term = 1;
        String result = "";
        while (res > 0 ) {

            int rem  = res % 26;
            //term = term * 26;
            res = res / 26;

            if (rem == 0){
                rem = 26;
                res--;
            }

            char currentTerm = (char) (rem + 64);
            result = currentTerm + result;
        }

        return result;
    }
}