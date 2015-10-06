/** 
 * 
 * Question - Basketball
 * Created by Yu Zheng on 10/1/2015 
 *
 */

public class Solution02 {
	/**
	 * 1. We know that the probability of winning Game 1 is p.
	 * So the p(wingame1) = p
	 * 2. If we want to win the Game 2. The probability is:
	 *		(p * p) + (1 - p) * p * p + p * (1 - p) * p
	 *	 	p(wingame2) = 3p^2 - 2*p^3
	 * 3. if p(wingam1) > p(wingam2), we play game 1, else, we
	 * play game 2.
	 * 4. After we compute the above we got the below result
	 * if p = 0 or 0.5 or 1, we can play either of them
	 * if 0 < p < 0.5, we play game 1, if 0.5 < p < 1, we play game 2.
	 *
	 *
	 *
	 */

}