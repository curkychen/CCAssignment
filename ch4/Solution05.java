
/** 
 * 
 * Question -  Validate BST
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: Acctually, for the BST, it has a feature that if we travel the tree
 * use in-order traversal, and put value into a array, if the array is sorted, 
 * which means it a BST. But, this approach cannot handle if the tree has duplicate
 * elements. 
 * 
 */

public class Solution05 {

	ArrayList<Inteter> inorder = new ArrayList<Integer>();

	// main function
	boolean checkBST(TreeNode root) {
		transfer(root);
		for(int i = 0; i < inorder.size() - 1; i++) {
			if(inorder.get(i+1) <= inorder.get(i))
				return false;
		}
		return true;
	}

	// assistant function
	void transfer(TreeNode root) {
		if(root == null)
			return;
		transfer(root.left);
		inorder.add(root.data);
		transfer(root.right);
	}

}
