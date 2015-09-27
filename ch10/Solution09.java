
/** 
 * 
 * Question - Sorted Matrix Search
 * Created by Yu Zheng on 9/25/2015 
 *
 * idea: Since the matrix is sorted. So, we can just compare the target with four corner, so that
 * we only need O(m + n) to find the element.
 *
 */

public class Solution09 {

	// give a (m * n) matrix
	public static void find(int[][] a, int m, int n, int target) {
		int row = 0;
		int col = n - 1;
		while(row < m && col >= 0) {
			if(a[row][col] == target) {
				System.out.println("The element is in row:" + row + " col: " + col);
			}
			else if(a[row][col] < target)
				row++;
			else
				col--;
		}
		System.out.println("No this element");
	}

}
