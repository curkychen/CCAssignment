import java.util.Stack;
/** 
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: just use a additional stack to store and keep track the min from stack
 *
 */
public class Solution02 {
	public static class MinStack extends Stack<Integer> {
		Stack<Integer> min;
		public MinStack() {
			min = new Stack<Integer>();
		}
		public void push(int v) {
			if (v <= getminnum()) {
				min.push(v);
			}
			super.push(v);
		}

		public Integer pop() {
			int v = super.pop();
			if (v == getminnum())
				min.pop();
			return v;
		}


		public Integer getminnum() {
			if(!min.empty())
				return min.peek();
			else
				return Integer.MAX_VALUE;
		}

	}
	public static void main(String [] args) {
		MinStack s = new MinStack();
		s.push(2);
		s.push(3);
		s.push(1);
		s.push(5);
		System.out.println(s.getminnum());
	}

}
