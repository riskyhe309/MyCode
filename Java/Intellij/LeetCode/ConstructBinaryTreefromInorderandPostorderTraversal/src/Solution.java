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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return curBulid(inorder,postorder,0,postorder.length - 1,inorder.length);
    }

    TreeNode curBulid(int[] inorder, int[] postorder, int inBegin, int postEnd, int length){

        if(length <= 0)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int temLength = 0;

        for(; temLength < length;  temLength++){
            if(inorder[inBegin +  temLength] == postorder[postEnd])
                break;
        }

        root.left = curBulid(inorder,postorder,inBegin,postEnd - length + temLength,temLength);
        root.right = curBulid(inorder,postorder,inBegin + temLength + 1,postEnd - 1,length - temLength - 1);
        return root;
    }
}