import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Risky on 2014/10/26.
 */
public class Test {
    public static void main(String[] args){

        String s = "catsanddog";

        Set<String> dict = new HashSet<String>();

        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        Solution sl = new Solution();

        List<String> li = sl.wordBreak(s,dict);

        for (String str : li)
            System.out.println(str);
    }
}
