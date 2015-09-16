
public class Solution04 {
	public static class linkedNode {
		public int val;
		public linkedNode next;
		linkedNode(int x) { this.val = x; }
	}

	// crate two new list, store large than x and less than x respectively
	public static linkedNode partition(linkedNode head, int n) {
		linkedNode p = new linkedNode(0);
		linkedNode q = new linkedNode(0);
		linkedNode fq = q;
		linkedNode fp = p;
		linkedNode current = head;
		while(current != null) {
			if(current.val < n) {
				fp.next = new linkedNode(current.val);
				fp = fp.next;
			}
			else {
				fq.next = new linkedNode(current.val);
				fq = fq.next;
			}
			current = current.next;
		}
		fp.next = q.next;
		return p.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number[] = {3, 5, 8, 5, 10, 2, 1};
		linkedNode a = new linkedNode(3);
		linkedNode current = a;
		for (int i = 1; i < number.length; i++) {
			current.next = new linkedNode(number[i]);
			current = current.next;
		}
		linkedNode c = a;
		while(c != null) {
			System.out.print(c.val + " ");
			c = c.next;
		}
		System.out.println();
		System.out.println("After process: ");
		linkedNode result = partition(a, 5);
		c = result;
		while(c != null) {
			System.out.print(c.val + " ");
			c = c.next;
		}
	}

}
