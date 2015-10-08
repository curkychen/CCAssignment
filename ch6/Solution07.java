/** 
 * 
 * Question - The Apocalypse
 * Created by Yu Zheng on 10/1/2015 
 *
 * idea: 
 * 
 */
import java.util.Random

public class Solution07 {
	// out logically
	/**
	 * if we want to compute the ratio of boy and girl
	 * we only need to care about the number of boy and girl
	 * but whatever the policy, the next of G or B is 50%.
	 * so if we consider the whole number of boy and girl, the gender ration
	 * would still be 0.5
	 *
	 */

	static double ratio(int n) {
		Random r = new Random();
		int [] boy_or_girl = {0, 0}; 
		for(int i = 0; i < n; i++) {
			int b = 0;
			int g = 0;
			while(g != 1) {
				if(r.nextBoolean())
					g++;
				else
					b++;
			}
			boy_or_girl[0] += g;
			boy_or_girl[1] += b;
		}

		return (double)(boy_or_girl[0] / boy_or_girl[1]);
	}
}