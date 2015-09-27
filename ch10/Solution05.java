
/** 
 * 
 * Question - Sparse Search
 * Created by Yu Zheng on 9/25/2015 
 *
 * idea: this question still can be used binary search, just modify some place 
 * if we meet the empty string, just search the closest not empty string.
 *
 */

public class Solution05 {

	public static int search(String[] a, int low, int high, String key) {
		while(low <= high) {
			int mid = (low + high) / 2;
			if(a[mid].isEmpty()) {
				while(true) {
					int left = mid - 1;
					int right = mid + 1;
					if(left < low && right > high)
						return -1;
					else if(low <= left && !a[left].isEmpty()) {
						mid = left;
						break;
					}
					else if(right <= high && !a[right].isEmpty()) {
						mid = right;
						break;
					}
					right++;
					left--;
				}
			}
			if(a[mid].equals(key))
				return mid;
			else if(a[mid].compareTo(key) < 0)
				low = mid + 1;
			else
				high = mid - 1;

		}
		return -1;
	}

	public static void main(String[] args) {
		String[] a = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(search(a, 0, a.length - 1, "ball"));
	}

}
