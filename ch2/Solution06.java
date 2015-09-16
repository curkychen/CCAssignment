
import java.util.Stack;

public class Solution06 {
	public static class linkedNode {
		public int val;
		public linkedNode next;
		public linkedNode(int x) { this.val = x; }
	}
	
	public static boolean ifpalindrome (linkedNode head) {
		linkedNode current = head;
		linkedNode runner = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (runner != null && runner.next != null) {
			stack.push(current.val);
			current = current.next;
			runner = runner.next.next;
		}
		
		// if the number of list is odd, we have to skip this node
		if (runner != null)
			current = current.next;
		
		while(current != null) {
			if (current.val != stack.pop())
				return false;
			else
				current = current.next;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int number[] = {0,1,2,1,0};
		int number[] = {0,1,2,1,0,1};
		linkedNode a = new linkedNode(number[0]);
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
		if (ifpalindrome(a))
			System.out.println("It's palindrome");
		else
			System.out.println("It is not palindrome");
	}

}
