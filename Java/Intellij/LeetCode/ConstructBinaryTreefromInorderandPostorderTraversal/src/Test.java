/**
 * Created by Risky on 2015/2/1.
 */
public class Test {

    public static void main(String[] args) {

        Solution sl = new Solution();

        int[] post = {2,1};
        int[] in = {2,1};

        TreeNode preRoot = sl.buildTree(post, in);
        TreeNode inRoot = preRoot;

        System.out.println("后序遍历");

        postVisitTree(preRoot);

        System.out.println();
        System.out.println("中序遍历");
        inVisitTree(inRoot);
    }

    private static void inVisitTree(TreeNode root) {

        if (root == null)
            return;

        inVisitTree(root.left);
        System.out.print(root.val + "->");
        inVisitTree(root.right);

    }


    private static void postVisitTree(TreeNode root) {

        if (root == null)
            return;


        postVisitTree(root.left);
        postVisitTree(root.right);
        System.out.print(root.val + "->");
    }
}
