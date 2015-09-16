
public class Solution01 {
	// the structure of list node
	public static class linkedNode {
		public int val;
		public linkedNode next;
		linkedNode(int x) { this.val = x; }
	}

	// use double pointer, the time is (n^2)
	public static void removeDup(linkedNode list) {
		linkedNode pre = list;
		linkedNode current = list;
		while (pre != null) {
			while (current.next != null) {
				if (current.next.val == pre.val) {
					current.next = current.next.next;
				} else
					current = current.next;
			}
			pre = pre.next;
			current = pre;
		}
	}

	// test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedNode a = new linkedNode(1);
		linkedNode current = a;
		for (int i = 0; i < 5; i++) {
			current.next = new linkedNode(i);
			current = current.next;
		}
		current.next = new linkedNode(4);
		current = current.next;
		linkedNode c = a;
		while(c != null) {
			System.out.print(c.val + " ");
			c = c.next;
		}
		System.out.println();
		System.out.println("After");
		removeDup(a);
		c = a;
		while(c != null) {
			System.out.print(c.val + " ");
			c = c.next;
		}
		
	}

}
