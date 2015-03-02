import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Risky on 2015/1/19.
 */
public class Test {
    public static void main(String[] args){
        Solution_others1 so = new Solution_others1();

        Set<String> dict = new HashSet<String>();

        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cot");

        String star = "hit";
        String end = "cog";



        for (List<String> l:so.findLadders(star,end,dict)){

            for (String str:l)
                System.out.print(str+" ");

            System.out.println();
        }

    }
}
