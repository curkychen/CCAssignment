
/** 
 * 
 * Question - Find Duplicates
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: use the bitset class to help us solve this problem
 * 
 */
import java.util.BitSet;  

public class Solution08 {
	public static void findDuplicates(int[] a) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < a.length; i++) {
			int current = a[i];
			if(bs.get(current - 1))
				System.out.println(current);
			else
				bs.set(current - 1);
		}
	}
	
	public static void main(String[] agus) {
		int[] a = {1,2,2,3,4,5,6,6,5,4,4,5,5,6,6,3};
		findDuplicates(a);
	}
}
