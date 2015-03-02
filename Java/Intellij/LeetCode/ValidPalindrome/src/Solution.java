import java.util.Stack;

/**
 * Created by Risky on 2014/12/30.
 */
public class Solution {
    public boolean isPalindrome(String s) {

        s = s.toUpperCase();
        s = s.replaceAll(" ","");
        char[] sChar = s.toCharArray();

        Stack<Character> invers = new Stack<Character>();

        StringBuffer sbOrig = new StringBuffer();

        for(char temp: sChar){
            if(((int)temp < 58 && (int)temp > 47) || ((int)temp < 91 && (int)temp > 64)){
                invers.push(temp);
                sbOrig.append(temp);
            }

        }


        StringBuffer sbInvers = new StringBuffer();

        while(!invers.empty()){
            sbInvers.append(invers.pop());
        }

        return sbOrig.toString().equals(sbInvers.toString());

    }
}