
/** 
 * 
 * Question - Successor
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: we know, the inorder travel the tree, we have to visit the left, 
 * current and right child node. first, if the node has right subtree, 
 * go find the most left of the right node. else, just search up, until we find 
 * a node which is large than current node.
 * 
 */

public class Solution06 {


	Treenode successor(TreeNode no) {
		if(no == null)
			return null;
		if(no.right) 							// if it has right node
			return mostLeftNode(no.right);

		// if the node is right node, just search up,
		// until found the most parent
		Treenode parent = no.parent;
		while(parent && parent.right == no) {
			no = parent;
			parent = parent.parent;
		}
		return parent;

	}

	// find the most left node;
	TreeNode mostLeftNode(Node* no) {
		if(no == null)
			return null;
		while(no.left != null)
			no = no.left;
		return no;
	}

}
