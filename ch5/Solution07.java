/** 
 * 
 * Question - Pairwise Swap
 * Created by Yu Zheng on 10/1/2015 
 *
 * idea: this problem is simple, just extract even bit and odd bit, and then to the or operation
 * 
 */

public class Solution07 {
	// 0x55555555 is 01010101....
	public static int swap_bits(int x){
		return ((x & 0x55555555) << 1) | ((x >> 1) & 0x55555555);
	}

	public static void main(String[] agrs) {
		int x = 1234;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(swap_bits(x)));
	}
}