/** 
 * 
 * Question - The Egg Drop Problem
 * Created by Yu Zheng on 10/1/2015 
 *
 */

public class Solution08 {

	/**
	 *
	 * For this question, since we want to find the N, we can assume some situation
	 * The time of egg drop is x, in order to find the N, we total make x times experiences.
	 * So, assuming that first time, we drop the egg from yth floor, if the egg is broken, 
	 * we only left one egg, so, we can only drop the egg from first floor until it broken.
	 * so, the time of experience is 1 + (y - 1) = x. 
	 * what if it does not broken. 
	 * we can continue former process, if the egg is broken in second time, the second egg should
	 * take (x - 2) times experiences. 
	 * According to above assume, we can ratiocinate that
	 * x + (x - 1) + (x - 2) + ... + 1 >= 100
	 * => (x + 1) * x / 2 >= 100
	 * we can got 14.
	 * so the answer is 14
	 *
	 *
	 */

}