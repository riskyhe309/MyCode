/**
 * Created by Risky on 2015/1/27.
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
    public int minDepth(TreeNode root) {
        int minDeep = Integer.MAX_VALUE;
        int deep = 0;

        if(root == null)
            return 0;

        return recurrenceVisite(root, deep + 1, minDeep);
    }

    int recurrenceVisite(TreeNode root, int deep, int minDeep){
      /*  if(root == null)
            return Integer.MAX_VALUE;*/

        if(root.left == null && root.right == null){
            if(deep < minDeep)
                minDeep = deep;
            return minDeep;
        }


        if(root.left == null){
            return recurrenceVisite(root.right, deep + 1, minDeep);
        }


        if(root.right == null){
            return recurrenceVisite(root.left, deep + 1, minDeep);
        }


        return Math.min(recurrenceVisite(root.left, deep + 1, minDeep),
                recurrenceVisite(root.right, deep + 1, minDeep));


    }

}