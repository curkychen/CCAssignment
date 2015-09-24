
/** 
 * 
 * Question - Check Balanced
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: checking the height of each subtree as we recurse down from the root. 
 * in each node, we would check the heights of right subtree and left subtree,
 * once the heights are different, we would return -1. and break the recurse, 
 * which means they are not blance.
 * 
 */

public class Solution04 {

	boolean isBalanced(TreeNode root) {
		if (checkHeight(root) == -1)
			return false;
		else
			return true;
	}

	int checkHeight(TreeNode root) {

		if (root == null)
			return 0;

		int left = checkHeight(root.left);
		if(left == -1)
			return -1;

		int right = checkHeight(root.right);
		if(right == -1)
			return -1;

		if(Math.abs(left - right) > 1)
			return -1;
		else
			return Math.max(left, right) + 1;

	}

}