
/** 
 * Created by Yu Zheng on 9/21/2015 
 *
 * Describe how you could use a single array to implement three stacks
 *
 * This time, we would use a single array to implement the 3 stack.
 * we would use a number to control which 
 * stack we using. and the capacity of 
 * stack is limited. 
 *
 */
public class Solution01 {
	public static class threestack {
		private int stacknum = 3;
		private int fullsize;
		private int size[];
		private int value[];

		// Construction
		public threestack (int size) {
			this.fullsize = size;
			this.size = new int[stacknum];
			this.value = new int[size * stacknum];
			for (int i = 0; i < stacknum; i++) {
				this.size[i] = 0;
			}
		}

		// return if the stack is empty
		public boolean isempty(int numofstack) {
			return size[numofstack] == 0;
		}
		// return if the stack is full
		public boolean isfull(int numofstack) {
			return size[numofstack] == fullsize;
		}

		// push number in the specific stack
		public void push(int numofstack, int v) {
			if(!isfull(numofstack)) {
				size[numofstack]++;
				int index = numofstack * fullsize + size[numofstack] - 1;
				value[index] = v;
			}
			else {
				System.out.println("This element is full");
			}
		}

		// pop a element from a specific stack
		public int pop(int numofstack) {
			if(!isempty(numofstack)) {
				int index = numofstack * fullsize + size[numofstack] - 1;
				size[numofstack]--;
				return value[index];
			}
			else {
				System.out.println("There is no element");
				return 0;
			}
		}

		// return the top element of a stack
		public int peek(int numofstack) {
			if (!isempty(numofstack)) {
				int index = numofstack * fullsize + size[numofstack] - 1;
				return value[index];
			}
			else {
				System.out.println("There is no element");
				return 0;
			}
		}
	}
	
	public static void main(String [] args) {
		threestack a = new threestack(3);
		a.push(0,2);
		a.push(0,1);
		System.out.println(a.pop(0));
		System.out.println(a.pop(0));
	}

}
