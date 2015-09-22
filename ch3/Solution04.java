import java.util.Stack;

/** 
 * implement queue by using two stacks
 * 
 * Question - Stack of Plates 
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: other methods similar to queue, only the pop method. when we pop a element,
 * we would tranfer all element from one stack to another stack. than, we pop the element
 * from the new stack, so that we can implement the FIFO function.
 */
public class Solution04 {
	public static class MyQueue<T> {
		Stack<T> oldstack, newstack;

		public MyQueue() {
			oldstack = new Stack<T>();
			newstack = new Stack<T>();
		}

		public void add(T v) {
			oldstack.push(v);
		}

		public T remove() {
			if(newstack.empty()) {
				while(!oldstack.empty()) {
					newstack.push(oldstack.pop());
				}
			}
			return newstack.pop();
		}

		public T peek() {
			if(newstack.empty()) {
				while(!oldstack.empty()) {
					newstack.push(oldstack.pop());
				}
			}
			return newstack.peek();
		}

		public int size() {
			return oldstack.size() + newstack.size();
		}
	}

	public static void main(String [] args) {
		MyQueue<Integer> a = new MyQueue<Integer>();
		a.add(1);
		a.add(2);
		System.out.println(a.remove()); 
		System.out.println(a.remove()); 
	}

}
