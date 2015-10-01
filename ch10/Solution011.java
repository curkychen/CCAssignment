
/** 
 * 
 * Question - Peaks and Valleys
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: We can sort the whole array and then just swap some postion
 * 1 2 3 4 5
 */
import java.util.Arrays;

public class Solution011 {

	// just only sort the array and swap position
	public static void sortValleyPeak(int[] a) {
		Arrays.sort(a);
		for(int i = 1; i < a.length; i += 2) {
			int temp = a[i - 1];
			a[i - 1] = a[i];
			a[i] = temp;
		}
	}

	public static void main(String[] args) {
		int[] a = {5, 3, 1, 2, 3};
		System.out.print("Input: ");
		System.out.print("{");
		for(int i = 0; i < a.length - 1; i++)
			System.out.print(a[i] + ", ");
		System.out.println(a[a.length - 1] + "}");
		sortValleyPeak(a);
		System.out.print("Output: ");
		System.out.print("{");
		for(int i = 0; i < a.length - 1; i++)
			System.out.print(a[i] + ", ");
		System.out.println(a[a.length - 1] + "}");
	}

}
