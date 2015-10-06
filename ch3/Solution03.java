import java.util.ArrayList;
import java.util.Stack;

/** 
 * Question - Stack of Plates 
 * Created by Yu Zheng on 9/21/2015 
 *
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a
 * specific sub-stack.
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

		// FOLLOW UP question
		public popAt(int index) {
			/**
			 * for this method. we have to consider the situation,
			 * first, if we have to satisfy the plate have substack since the former stack is full.
			 * In order to satisfy above requirement, once we pop a sub stack element, we have to do the rollover
			 * step, which mean we have to get the bottom element of the next stack, put it on the top 
			 * of previous stack, and repeat the action until the final stack. It would make the time cost large.
			 * If we don't need to satisfy above requirement, that's OK, but we have to carefully handle the
			 * situation that if the former stack is empty, but the current is not empty.
			 */

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
