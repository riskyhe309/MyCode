#include"treeNode.h"
class Solution {
public:
    int sumNumbers(TreeNode *root) {
        int result = treeNumber(root,0);
		return result;
    }

	int treeNumber(TreeNode *root,int sum)
	{
		//the node has one child ,it not the leaf node, so when it travels
		//to the NULL node (it has other child,while is not null), then return 0 
		//like	1   we get the NULL,return 0 terminate the path 
		//	   / \
		//	 NULL 0	
		if(root == NULL)
			return 0;
		
		sum = sum * 10 + root->val;

		if (root->left == NULL && root->right == NULL)
		{
			return sum;
		}
		
		
		int leftSum = treeNumber(root->left,sum);
		int rightSum = treeNumber(root->right,sum);

		return leftSum + rightSum;
	}
};