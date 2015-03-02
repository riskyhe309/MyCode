import java.util.HashSet;
import java.util.Set;

/**
 * Created by Risky on 2015/1/11.
 */
public class Test {
    public static void main(String[] args){
        Solution sl = new Solution();

        String star = "hot";
        String end = "dog";
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dog");

        System.out.println(sl.ladderLength(star,end,dict));
    }
}
