/** 
 * 
 * Question - Debugger
 * Created by Yu Zheng on 10/1/2015 
 *
 * Explain what the following code does: ((n & (n-1)) == 0)
 */

public class Solution05 {
	/**
	 * if n = 100 then n - 1 = 011
	 * and the result = n & (n - 1) = 0
	 * if n = 111, then n - 1 = 110
	 * the reuslt is false where n & (n - 1) == 0
	 * so, which mean the n can only has one 1 in the binary form,
	 * which mean the function is that checking power of 2
	 *
	 *
	 */
}