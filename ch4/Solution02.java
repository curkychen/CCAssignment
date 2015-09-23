
/** 
 * 
 * Question - Animal Shelter
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: if we want to implement a BST with a minimal height, we can set the middle element of the array
 * to be the root. And then, insert the left subtree in the left, insert the right subtree on the right node.
 * 
 */

public class Solution02 {

	public TreeNode createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}

	public TreeNode createMinimalBST(int array[], int start, int end) {
		if(end < start)
			return null;

		int mid = (start + end) / 2;

		TreeNode node = new TreeNode(array[mid]);
		node.left = createMinimalBST(array, start, mid - 1);
		node.right = createMinimalBST(array, mid + 1, end);
		return node;

	}

}
