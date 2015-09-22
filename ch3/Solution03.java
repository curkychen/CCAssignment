import java.util.ArrayList;
import java.util.Stack;

/** 
 * Question - Stack of Plates 
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: just use index to control which stack we use, a little similar to Q1
 *
 */
public class Solution03 {
	public static class SetOfStacks {
		ArrayList<Stack<Integer>> setstack = new ArrayList<Stack<Integer>>();
		int eachcapcity;

		public SetOfStacks(int eachcapcity) {
			this.eachcapcity = eachcapcity;
		}

		public void push(int v) {
			if(getLastStack() == null || getLastStack().size() == eachcapcity) {
				Stack<Integer> a = new Stack<Integer>();
				a.push(v);
				setstack.add(a);
			}
			else {
				getLastStack().push(v);
			}

		}

		public int pop() {
			if(getLastStack() == null)
				return 0;
			else {
				int value = getLastStack().pop();
				if(getLastStack().empty())
					setstack.remove(setstack.size() - 1);
				return value;
			}

		}

		public Stack<Integer> getLastStack() {
			if(!setstack.isEmpty())
				return setstack.get(setstack.size() - 1);
			else
				return null;
		} 
	}

	public static void main(String [] args) {
		SetOfStacks s = new SetOfStacks(2);
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
	}

}
