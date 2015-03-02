

/**
 * Created by Risky on 2015/1/29.
 */
public class Test {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        ListNode tail = new ListNode(3);

        head.next = tail;

        Solution sl = new Solution();

        TreeNode root = sl.sortedListToBST(head);

        visitTree(root);
    }

    private static void visitTree(TreeNode root) {

        if(root == null)
            return ;

        System.out.print(root.val+"->");

        visitTree(root.left);
        visitTree(root.right);
    }
}
