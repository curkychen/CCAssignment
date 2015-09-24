
/** 
 * 
 * Question - List of Depth
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: we don't need to search the tree level by level, we can just use BFS to 
 * travel the whole tree, and then, record each level node
 * 
 */

public class Solution03 {

	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null)
			current.add(root);

		while(current.size() > 0) {
			result.add(current);

			LinkedList<TreeNode> previous = current; // record the last level node
			current = new LinkedList<TreeNode>();

			for(TreeNode t : previous) {
				if(t.left != null)
					current.add(t.left);
				if(t.right != null)
					current.add(t.right)
			}
		}

		return result;

	}

}
