

/**
 * Created by Risky on 2015/1/25.
 */
public class Test {

    public static void main(String[] args){
        Solution sl = new Solution();

        TreeLinkNode tln = new TreeLinkNode(0);

        sl.connect(tln);
        System.out.println(tln.val);
    }
}
