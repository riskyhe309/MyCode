import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Risky on 2015/2/6.
 */
public class Test {

    public static void main(String[] args){

        Solution sl = new Solution();

        String s1 = "aa";
        String s2 = "ab";
        String s3 = "aaba";

        System.out.println(sl.isInterleave(s1,s2,s3));

    }

}
