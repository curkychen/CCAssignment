/**
 *  use the pointer, move forward according to the kth, and then return the pointer
 */

public class Solution02 {
	// linkedlist class
	public static class linkedNode {
		public int val;
		public linkedNode next;
		linkedNode(int x) { this.val = x; }
	}
	
	// The function of return the kth to last element
	public static linkedNode returnkthlast(linkedNode list, int k) {
		linkedNode current = list;
		int count = 0;
		
		// travel the list to the kth element.
		while(count++ < k - 1) {
			current = current.next;
		}
		
		return current;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// test case: the link is: 1,0,1,2,3,4
		linkedNode a = new linkedNode(1);
		linkedNode current = a;
		for (int i = 0; i < 5; i++) {
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
		// After use the return function
		linkedNode output = returnkthlast(a, 4);
		c = output;
		while(c != null) {
			System.out.print(c.val + " ");
			c = c.next;
		}
		
	}

}
