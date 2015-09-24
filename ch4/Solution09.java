
/** 
 * 
 * Question - BST Sequences
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea:
 * 
 */


public class Solution09 {
	ArrayList<LinkedLIst<Integer>> allSequences(TreeNode node) {
		ArrayLIst<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

		if (node == null){
			result.add(new LinkedList<Integer>());
			return result;
		}

		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);

		// recurse on left subtree and right subtree
		ArrayList<LinkedLIst<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        // weave together each list
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}

	// ewave lists together in all possible ways.
	void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
		ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        // one list is empty. Add remainder to [a cloned] prefix and store result.
		if (first.size() == 0 || second.size() == 0){
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return ;
		}

        // Recurse with head of first added to the prefix. Removing the head will damage first, so we'll need to put it back where we found it afterwards.
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);

        // Do the same thing with second, damaging and then restoring the list
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}

}
