
/** 
 * 
 * Question - Random Node
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: insert a new varible, but insert the 
 * 
 */

public class Solution11 {

	public int data;
	public TreeNode left;
	public TreeNode right;
	public int size;

	public TreeNode(int data) {
		this.data = data;
		size = 1;
	}


	public TreeNode getRandomNode() {
		int leftsize = 0;
		if(left != null)
			leftsize = left.size();

		Random random = new Random();
		int index = random.nextInt(size);
		if(index < leftsize)
			return left.getRandomNode();
		else if(index > leftsize)
			return left.getRandomNode();
		else
			return this;

	}

	// since we add extra varible, so the insert function should
	// be modified.

	public insertInorder(int d) {
		if(d <= data) {
			if(left == null)
				left = new TreeNode(d);
			else
				insertInorder(d);
		}
		else {
			if(right == null)
				right = new TreeNode(d);
			else
				right.insertInorder(d);
		}
		size++;
	}
}
