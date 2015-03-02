import java.util.List;

/**
 * Created by Risky on 2015/2/6.
 */
public class Test {
    public static void main(String[] args){

        Solution sl = new Solution();

        String s = "GAGAGAGAGAGA";

        List<String> re = sl.findRepeatedDnaSequences(s);

        for (String str:re)
            System.out.println(str);
    }
}
