import java.util.Stack;
/** 
 * 
 * Question - sort stack
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: just use a temp to store the unsort stack top element, and transfer element
 * from sort stack to unsort stack, if the sort stack top element less than the temp, 
 * just insert the element into the sort stack
 * 
 */
public class Solution05 {
	public static Stack<Integer> sortstack(Stack<Integer> unsort) {
		Stack<Integer> sort = new Stack<Integer>();
		while(!unsort.empty()) {
			int temp = unsort.pop();
			while(!sort.empty() && sort.peek() < temp) {
				unsort.push(sort.pop());
			}
			sort.push(temp);
		}
		return sort;
	}

	public static void main(String [] args) {
		Stack<Integer> a = new Stack<Integer>();
		a.push(3);
		a.push(1);
		a.push(2);
		a.push(4);
		a = sortstack(a);
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
	}


}
