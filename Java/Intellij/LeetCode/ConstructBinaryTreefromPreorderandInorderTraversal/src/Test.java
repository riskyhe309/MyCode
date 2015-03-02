/**
 * Created by Risky on 2015/2/1.
 */
public class Test {

    public static void main(String[] args) {

        Solution sl = new Solution();

        int[] pre = {1, 2, 4, 3};
        int[] in = {1, 2, 3, 4};

        TreeNode preRoot = sl.buildTree(pre, in);
        TreeNode inRoot = preRoot;

        System.out.println("前序遍历");

        preVisitTree(preRoot);

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


    private static void preVisitTree(TreeNode root) {

        if (root == null)
            return;

        System.out.print(root.val + "->");

        preVisitTree(root.left);
        preVisitTree(root.right);
    }
}
