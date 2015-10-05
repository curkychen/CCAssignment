/** 
 * 
 * Question - Next Number
 * Created by Yu Zheng on 10/1/2015 
 *
 * idea: just check the next number one by one, if the number of 1 for this number
 * is equal to the original number, print it out.
 * 
 */

public class Solution04 {

	// compute the number of 1
	public static int count_one(int x){
		int cnt = 0;
		for(int i=0; i<32; ++i){
			if(x & 1) ++cnt;
			x >>= 1;
		}
		return cnt;
	}

	// get the next smallest
	public int getnext(int x) {
		int max_ini = ~(1 << 31);
		int num = count_one(x);
		if(num == 0 || x == -1)
			return -1;
		while(true) {
			x++;
			if(count_one(x) != num && x < max_ini)
				break;
		}
		if(count_one(x) == num)
			return x;
		return -1;
	}

	// get the previous largest
	public int getpre(int x) {
		int min_ini = 1 << 31;
		int num = count_one(x);
		if(num == 0 || x == -1)
			return -1;
		while(true) {
			x--;
			if (count_one(x) != num && x > min_ini)
				break;
		}
		if(count_one(x) == num)
			return x;
		return -1;
	}		


}