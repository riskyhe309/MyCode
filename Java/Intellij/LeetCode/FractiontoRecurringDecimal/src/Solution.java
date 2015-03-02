import java.util.HashMap;
import java.util.Map;

/**
 * Created by Risky on 2014/12/28.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        long numL = numerator;
        long denoL = denominator;

        if (denoL == 0)
            return "the denominator can't be zero";

        StringBuffer sb = new StringBuffer();

        if (numL < 0 ^ denoL < 0)
            sb.append("-");

        numL = Math.abs(numL);


        denoL = Math.abs(denoL);

        long inte = numL / denoL;
        long rema = (numL % denoL) * 10;

        if (rema == 0)
            return sb.append(inte).toString();

        sb.append(inte + ".");

        Map<Long, Integer> map = new HashMap<Long,Integer>();

        while (rema != 0) {
            inte = rema / denoL;
            Integer value = map.get(rema);
            if (value != null) {
                sb.insert(value, "(");
                sb.append(")");
                break;
            }

            map.put(rema, sb.length());
            rema = (rema % denoL) * 10;
            sb.append(inte);

        }

        return sb.toString();
    }
}