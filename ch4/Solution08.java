
/** 
 * 
 * Question - First Common Ancestor
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea:
 * 
 */

public class Solution08 {
	/**
	 * first solution, The node links to parents
	 */

	// we have two node, p and q.
	// we can trace p's parent, if it also is q's parent,
	// the node is the first common Ancestor
	boolean father(TreeNode p, TreeNode q) {
		if(p == null)
			return false;
		else if(p == q) {
			return true;
		}
		else
			return father(p.left, q) || father(p.right, q);
	}

	TreeNode first_common(TreeNode p, TreeNode q) {
		if(p == null || q == null)
			return null;
		while(p){
			if(father(p,q))
				return p;
			p = p.parent;
		}
		return null;
	}


	/**
	 * Second solution, The node without links to parents
	 * Check the node from root to subtree.
	 */

	/*
	void first_common(Treenode root, Treenode p, Treenode q, Treenode accestor) {
		if(root == null || p == null || q == null)
			return null;
		if(root && father(root, p) && father(root, q)) {
			accestor = root;
			first_common(root.left, p, q, accestor);
			first_common(root.right, p, q, accestor);
		}
	}

	boolean father(TreeNode p, TreeNode q) {
		if(p == null)
			return false;
		else if(p == q) {
			return true;
		}
		else
			return father(p.left, q) || father(p.right, q);
	}
	*/


}
