/*
 * Complete the function below.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static long[] countPaths(int[] A, int[] T) {
		long[] allresult = new long[T.length];
        long[] result = new long[100005];
		result[0] = 1;
		for (int i = 0; i < T.length; i++) {
			allresult[i] = contpaths(A, T[i], result);
		}
		return allresult;
	}

	static long contpaths(int[] A, int target, long[] result) {
		if (result[target] == 0) {
			for (int i = 0; i < A.length; i++) {
				if (target - A[i] >= 0) {
					result[target] += contpaths(A, target - A[i], result);
					result[target] %= (long) (1E9 + 7);
				}
			}
		}
		return result[target];
	}

	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
		String[] split = in.nextLine().split(" ");
		int[] A = new int[split.length];
		for(int i=0; i<split.length; i++)
			A[i] = Integer.parseInt(split[i]);
		int N = Integer.parseInt(in.nextLine().trim());
		int[] T = new int[N];
		for(int i=0; i<N; i++) {
			T[i] = Integer.parseInt(in.nextLine().trim());
		}
		long[] countPaths = countPaths(A, T);
		for(long c : countPaths)
			System.out.println(c);
		in.close();

    }
}


