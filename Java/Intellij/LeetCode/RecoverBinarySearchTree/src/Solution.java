/**
 * Created by Risky on 2015/2/5.
 */
public class Solution {

    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {


        if(root == null)
            return;

        findNode(root);

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

    }

    void findNode(TreeNode root){
        if(root == null)
            return;

        findNode(root.left);

        if(firstNode == null &&  root.val < pre.val)
            firstNode = pre;

        if(firstNode != null &&  root.val < pre.val)
            secondNode = root;

        pre = root;

        findNode(root.right);
    }
}