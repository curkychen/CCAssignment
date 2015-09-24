
/** 
 * 
 * Question -  Paths with Sum
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: Brute Force
 * 
 */

public class Solution12 {

	int count = 0;

	void find_sum(TreeNode root, int sum, Vector<Integer> list, int level) {
		if(root == null)
			return;
		list.add(root.value);
		int tmp = 0;
		for(int i = level; i > -1; --i) {
			tmp += v.get(i);
			if(tmp == sum)
				count++;
		}
		Vector<Integer> v1 = new Vector<Integer>(v);
		Vector<Integer> v2 = new Vector<Integer>(v);

		find_sum(root.left, sum, v1, level + 1);
		find_sum(root.right, sum, v2, level + 1);

	}

}
