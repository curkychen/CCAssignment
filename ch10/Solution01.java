
/** 
 * 
 * Question -  Sorted Merge
 * Created by Yu Zheng on 9/25/2015 
 *
 * idea: we can travel the array a and b from end to begin
 * and then, compare each digits, if a[index] > b[index],
 * put the a[index] to current position, else, put the b[index]
 * in this position.
 * 
 */

public class Solution01 {

	// the argument lengtha and lengthb means that 
	// total number of array a and b
	public static void merge(int[] a, int[] b,
		 int lengtha, int lengthb) {

		int indexb = lengtha - 1;
		int indexa = lengthb - 1;
		int wholeindex = lengtha + lengthb - 1;
		while(indexb >= 0) {
			if(indexa >= 0 && a[indexa] > b[indexb]) {
				a[wholeindex] = a[indexa];
				indexa--;
			}
			else {
				a[wholeindex] = b[indexb];
				indexb--;
			}
			wholeindex--;
		}
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 7, 8, 0, 0, 0, 0, 0};
		int[] b = {2, 4 , 6 , 9, 12};
		merge(a, b, 5, 5);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");

	}


}
