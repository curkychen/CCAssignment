/** 
 * 
 * Question - Insertion
 * Created by Yu Zheng on 10/1/2015 
 *
 * idea: first, we store 0th to ith number, called ret
 * clear N as 0 from 0th to jth. Finally, 
 * use N | (m << i) | ret, it the final result;
 * 
 */

public class Solution01 {

	public static int update_bits(int n, int m, int i, int j) {
		int ret = (1 << i) - 1;
		ret = ret & n; 					// store 0 to ith number
		n = (n >> (j + 1) ) << (j + 1); // clear 0 to jth as 0
		return n | (m << i) | ret;		
	}

	public static void main(String[] agrs) {
		int n = 1 << 10;	// 10000000000
		int m = 21; 		// 10101
		int i = 2, j = 6;
		int result = update_bits(n, m, i, j);
		System.out.print("Input: N = " + Integer.toBinaryString(n));
		System.out.println(", M = " + Integer.toBinaryString(m) + ", i = "
								+ i + ", j = " + j);
		System.out.println("Output: N = " + Integer.toBinaryString(result));
	}

}