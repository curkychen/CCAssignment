/** 
 * 
 * Question - Conversion
 * Created by Yu Zheng on 10/1/2015 
 *
 * idea: this quantion is sample, we would do x xor y, 
 * and then just compute the number of 1.
 * 
 */

public class Solution06 {
	public static int conversion(int a, int b) {
		int c = a ^ b;
		return Integer.bitCount(c);
	}
	
	public static void main (String[] agrs) {
		System.out.println(conversion(29, 15));
	}

}