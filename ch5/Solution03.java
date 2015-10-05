/** 
 * 
 * Question - Flip Bit to Win
 * Created by Yu Zheng on 10/1/2015 
 *
 * idea: In this problem, we can notic that the sequence has feature, just
 * if we find 0 from the sequence, and then merge their left side and right side;
 * so, first, we would collect all information from whole sequence, and find the zero sequence,
 * if the count of zero is 1, we can compute both size of right side and left side,
 * if the count of zero is more than more, compute either side.
 *
 */

public class Solution03 {

	public static int getMax(int[] s) {
		if(s[1] == 1)	// if there is sigle 0, merge right and left
			return s[0] + s[2] + 1;
		else if(s[1] == 0) // if there is no zero, take either side, this for begin situation
			return Math.max(s[0], s[2]);
		else // if there more than one zeros, take either side which is longer
			return Math.max(s[0], s[2]) + 1;
	}

	public static int longestSequnce(int n) {
		// if the sequnce is all 1s, the result is 32
		if (n == -1) {
			return 32;
		}

		int currentsearching = 0; // record which number you searching
		int[] sequence = {0, 0, 0}; // represent left count, zero count and right count
		int maxsquence = 1;

		for (int i = 0; i < 32; i++) {
			// if the next number is not equal to current searching number
			if((n & 1) != currentsearching) {
				// we hope each squence is end up of 1s 0s and 1s
				if (currentsearching == 1) {
					maxsquence = Math.max(maxsquence, getMax(sequence));
				}

				currentsearching = n & 1; // if the current searching is different, we change it
				// if the current searching is different, change sequence count recording
				sequence[2] = sequence[1];
				sequence[1] = sequence[0];
				sequence[0] = 0;
			}

			sequence[0]++;
			n = n >>> 1;
			
		}

		// if final sequence is 0 count, all need to compute the size of left side
		if(currentsearching == 0) {
			sequence[2] = sequence[1];
			sequence[1] = sequence[0];
			sequence[0] = 0;
		}
		return Math.max(maxsquence, getMax(sequence));
	}
	
	public static void main(String[] args) {
		int num = 1775;
		System.out.println(longestSequnce(num));
	}

}