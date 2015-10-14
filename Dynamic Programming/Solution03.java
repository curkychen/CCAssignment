package yu;

import java.io.*;
import java.util.*;
import java.math.*;

import org.omg.CORBA.INTERNAL;

/**
 * 
 * @author zhengyu
 * 
 */

public class test {
	static long[] countPaths(int[] A, int[] T) {
		long[] allresult = new long[T.length];
		long[] result = new long[100006];
		result[0] = 1;
		contpaths(A, 100005, result);
		for (int i = 0; i < T.length; i++) {
			allresult[i] = result[T[i]];
		}
		return allresult;
	}

	static void contpaths(int[] A, int target, long[] result) {
		for (int i = 0; i < A.length; i++) {
			for (int j = A[i]; j < result.length; j++) {
				result[j] += ((result[j - A[i]]) % ((long) (1E9 + 7)));
			}
		}
		result[target] = result[target] % ((long) (1E9 + 7));
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String[] split = in.nextLine().split(" ");
		int[] A = new int[split.length];
		for (int i = 0; i < split.length; i++)
			A[i] = Integer.parseInt(split[i]);
		int N = Integer.parseInt(in.nextLine().trim());
		int[] T = new int[N];
		for (int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(in.nextLine().trim());
		}
		long[] countPaths = countPaths(A, T);
		for (long c : countPaths)
			System.out.println(c);
		in.close();

	}
}