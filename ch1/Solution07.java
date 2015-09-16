
public class Solution07 {

	public static int[][] rotatematrix(int[][] matrix) {
		int n = matrix.length;
		int[][] result = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[j][n-1-i] = matrix[i][j];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] martrix = new int[5][5];
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				martrix[i][j] = i+j;

		System.out.println("Before rotation:");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(martrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("After rotation: ");
		int[][] afterrotate = rotatematrix(martrix);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(afterrotate[i][j]);
			}
			System.out.println();
		}
	}

}
