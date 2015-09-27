
/** 
 * 
 * Question - Search in Rotated Array
 * Created by Yu Zheng on 9/25/2015 
 *
 * idea: use binary seach, but we need to add some addition condition
 * 
 */

public class Solution03 {

	public static int rotateseach(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		while(low <= high) {
			int mid = low + (low + high) / 2;
			if(a[mid] == x)
				return mid;
			
			if(a[low] < a[mid]) {
				if(a[low] <= x && x < a[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}

			else{
				if(a[mid] < x && x <= a[high])
					low = mid + 1;
				else
					hig = mid - 1;
			}
		}
		return -999;
	}
	
	public static void main(String[] args) {
		int[] a = {15, 16, 19, 20, 25, 78, 89, 90, 5, 7, 10, 14};
        int result = rotateseach(a, 5);
        if(result == -999)
        	System.out.println("These is no this number");
        else
        	System.out.println(result);
	}


}
