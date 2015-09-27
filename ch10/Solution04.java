
/** 
 * 
 * Question - Sorted Search, No Size
 * Created by Yu Zheng on 9/25/2015 
 *
 * idea: We would also use binary search.
 * for the length of array, we would use 1, 2, 4, 8 , 32... to test the size of array
 * once we found the boundary, return the index. time is O(longN)
 * 
 */

public class Solution04 {

	
	// main function
	public static int noSizeSearch(int[] a, int value) {
		int high = findlength(a);
		int low = high / 2;
		int result = binaryseach(a[], low, high, value);
	}


	// find the boundary of the array
	public static int findlength(int[] a, int v) {
		int index = 1;
		while(a.elementAt(index) < v && a.elementAt(index) != -1) {
			index = index * 2;
		}
		return index;
	}

	// binary search
	public static int binaryseach(int[] a, int low, int high, int x) {

		while(low <= high) {
			int mid = (low + high) / 2;
			if(a.elementAt(mid) == x)
				return mid;
			else if(x < a.elementAt(mid) || a.elementAt(mid) == -1) {
				high = mid-1;
			}
			else
				low = mid + 1;
		}
		return -1;
	}

}
