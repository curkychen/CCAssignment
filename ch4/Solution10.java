
/** 
 * 
 * Question - Check Subtree
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea:  Brute Force
 * search the n2's root in in n1 tree, once we found that, conpare their subtree,
 * if match, return true, else, keep going until we search all node in n2
 * 
 */

public class Solution10 {

	boolean contain(Treenode n1, TreeNode n2) {
		if(n2 == null)
			return false;
		else
			return subtree(n1, n2);
	}

	boolean subtree(TreeNode n1, TreeNode n2) {
		if(n1 == null)
			return false;
		else if(n1.data == n2.data) {
			if(match(n1, n2))
				return true;
		}
		else return subtree(n1.left, n2) || subtree(r1.right, n2);

	}

	boolean match(Treenode n1, Treenode n2) {
		if(n1 == null && n2 == null)
			return true;
		else if(n1 == null || n2 == null)
			return false;
		else if(n1.data != n2.data)
			return false
		else return match(n1.left, n2.left) && match(n1.left, n2.left);
	}
}
