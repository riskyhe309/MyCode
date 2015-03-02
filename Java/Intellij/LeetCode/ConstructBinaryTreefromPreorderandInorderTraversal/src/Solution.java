/**
 * Created by Risky on 2015/2/1.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int length = preorder.length;
        if(length == 0)
            return null;

        TreeNode root = curBulid(preorder,inorder,0,0,length);

        return root;
    }


    TreeNode curBulid(int[] preorder, int[] inorder, int preBegin, int inBegin, int length){

        if(length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[preBegin]);

        int temLength = 0;

        for(int i = inBegin; i < inBegin + length; i++){
            if(inorder[i] == preorder[preBegin])
                break;
            temLength++;
        }

        root.left = curBulid(preorder,inorder,preBegin + 1,inBegin,temLength);
        root.right = curBulid(preorder,inorder,preBegin + temLength + 1 ,temLength + 1 + inBegin,length - temLength - 1);
        return root;
    }
}