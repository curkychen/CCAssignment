/**
 * do the addition like what we add two sum at black board.
 * compute it from the lowest bit, just care the carry bit
 */
public class Solution05 {
	public static class linkedNode {
		public int val;
		public linkedNode next;
		public linkedNode(int x) { this.val = x; }
	}
	
	
	// do the addition like what we add two sum at black board.
	// compute it from the lowest bit, just care the carry bit
	public static linkedNode addtwosum (linkedNode l1, linkedNode l2) {
		linkedNode result = new linkedNode(0);
		linkedNode c = result;
		linkedNode p1 = l1;
		linkedNode p2 = l2;
		int add = 0;
		while(true) {
			if (p1 == null && p2 == null && add == 0)
				break;
			int data = add;
			if (p1 != null) {
				data = data + p1.val;
			}
			if (p2 != null) {
				data = data + p2.val;
			}
			add = (data >= 10 ? 1 : 0);
			if (p1.next != null)
				p1 = p1.next;
			else
				p1 = null;
			if (p2.next != null)
				p2 = p2.next;
			else
				p2 = null;
			c.next = new linkedNode(data % 10);
			c = c.next;
		}
		return result.next;
	}

	// FOLLOW UP question, if the linknode is reverse
	// first, I would reverse the linked, and then just put it on the addtwosum function
	public static linkedNode addtreverse(linkedNode l1, linkedNode l2) {
		linkedNode rl1 = reverserlink(l1);
		linkedNode rl2 = reverserlink(l2);
		return addtwosum(rl1, rl2);

	}
	public static linkedNode reverserlink(linkedNode l) {
		linkedNode current = l.next;
		linkedNode head = l;
		linkedNode pre = l;
		linkedNode next;
		while(current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		head.next = null;
		head = pre;
		return head;
	}

	
	// test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {7,1,6};
		int b[] = {5,9,2};
		linkedNode s1 = new linkedNode(a[0]);
		linkedNode s2 = new linkedNode(b[0]);
		linkedNode ps1 = s1;
		linkedNode ps2 = s2;
		ps1.next = new linkedNode(a[1]);
		ps1 = ps1.next;
		ps1.next = new linkedNode(a[2]);
		ps2.next = new linkedNode(b[1]);
		ps2 = ps2.next;
		ps2.next = new linkedNode(b[2]);
		ps1 = s1;
		ps2 = s2;
		while(ps1.next != null){
			System.out.print(ps1.val + "->");
			ps1 = ps1.next;
		}
		System.out.println(ps1.val);
		while(ps2.next != null){
			System.out.print(ps2.val + "->");
			ps2 = ps2.next;
		}
		System.out.println(ps2.val);
		System.out.println("After add them togegher:");
		linkedNode result = addtwosum(s1, s2);
		ps2 = result;
		while(ps2.next != null){
			System.out.print(ps2.val + "->");
			ps2 = ps2.next;
		}
		System.out.println(ps2.val);
		
	}
}
