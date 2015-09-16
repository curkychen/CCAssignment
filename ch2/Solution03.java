/**
 *  just make the value of node equal to value of next node, make this node point to 
 *  next node of next node.
 */

public class Solution03 {

	public static class linkedNode {
		public int val;
		public linkedNode next;
		linkedNode(int x) { this.val = x; }
	}
	
	// the question solution
	public static void deletemiddle (linkedNode middle) {
		if (middle == null || middle.next == null)
			return;
		middle.val = middle.next.val;
		middle.next = middle.next.next;
	}
	
	// test, and original list is 1-0-1-2-3, the middle list is 0, the second list node
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedNode a = new linkedNode(1);
		linkedNode current = a;
		for (int i = 0; i < 4; i++) {
			current.next = new linkedNode(i);
			current = current.next;
		}
		linkedNode c = a;
		while(c != null) {
			System.out.print(c.val + " ");
			c = c.next;
		}
		System.out.println();
		System.out.println("After process: ");
		c = a;
		c = c.next; // give the middle list, the value is 0
		deletemiddle(c);
		c = a;
		while(c != null) {
			System.out.print(c.val + " ");
			c = c.next;
		}
	}

}
