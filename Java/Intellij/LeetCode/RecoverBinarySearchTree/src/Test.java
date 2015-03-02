/**
 * Created by Risky on 2015/2/5.
 */
public class Test {

    public static void main(String[] args){

        Solution sl = new Solution();

        TreeNode root  = new TreeNode(0);
        TreeNode left = new TreeNode(1);

        root.left = left;

        sl.recoverTree(root);

        System.out.println(root.val);
        System.out.println(left.val);
    }
}
