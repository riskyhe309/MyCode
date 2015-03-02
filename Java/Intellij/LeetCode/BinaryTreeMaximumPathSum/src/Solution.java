/**
 * Created by Risky on 2015/1/22.
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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        if(root == null)
            max = 0;

        findMax(root);

        return max;
    }


    int findMax(TreeNode root){

        int num = root.val;

        int left = 0,right = 0;

        if(root.left != null){
            left = findMax(root.left);
            if(left < 0)
                left = 0;
        }

        if(root.right != null){
            right = findMax(root.right);
            if(right < 0)
                right = 0;;
        }


        //如果以此顶点路径的和大于max
        if((num + left + right) > max)
            max = num + left + right;

        //返回左右子分支中 和最大的分支
        return left > right? num + left: num + right;
    }
}