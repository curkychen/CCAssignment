

public class Solution08 {

	public static void zeromatrix(int[][] matrix) {
		int M = matrix.length;
		int N = matrix[0].length;
		int[] row = new int[M];
		boolean[] column = new boolean[N];
		for (int i = 0; i < N; i++)
			column[i] = false;
		
		// mark column
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matrix[j][i] == 0) {
					column[i] = true;
					continue;
				}
			}
		}
		
		// null row
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 0) {
					for (int x = 0; x < N; x++) {
						matrix[i][x] = 0;
					}
					continue;
				}
			}
		}
		
		// null column
		for (int i = 0; i < N; i++) {
			if(column[i]) {
				for (int j = 0; j < M; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = new int[5][4];
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 4; j++)
				matrix[i][j] = 1;
		matrix[2][3] = 0;
		matrix[1][2] = 0;
		matrix[3][3] = 0;
		matrix[0][0] = 0;
		System.out.println("Before zero:");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("After zero process:");
		zeromatrix(matrix);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

}
