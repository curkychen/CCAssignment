/** 
 * 
 * Created by Yu Zheng on 10/1/2015 
 *
 * 
 */

public class Solution4 {


	static long highestStack(int[][] boxes) {
		quickSort(boxes, 0, boxes.length - 1);
		long maxheight = 0;
		long[] stack = new long[boxes.length];
		for (int i = 0; i < boxes.length; i++) {
			long heigh = createstack(boxes, i, stack);
			maxheight = Math.max(maxheight, heigh);
		}

		return maxheight;
	}

	static long createstack(int[][] boxes, int Index, long[] stack) {
		if (stack[Index] > 0)
			return stack[Index];

		long maxHeight = 0;
		for (int i = Index + 1; i < boxes.length; i++) {
            // check if the box can above another box
			if (boxes[i][0] > boxes[Index][0] && boxes[i][1] > boxes[Index][1]) {
				long heigh = createstack(boxes, i, stack);
				maxHeight = Math.max(heigh, maxHeight);
			}
		}
		maxHeight += boxes[Index][2];
		stack[Index] = maxHeight;
		return maxHeight;
	}


	// main
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine().trim());
		int[][] boxes = new int[N][3];
		for (int i = 0; i < N; i++) {
			String[] split = in.nextLine().split(" ");
			for (int j = 0; j < split.length; j++) {
				boxes[i][j] = Integer.parseInt(split[j]);
			}
		}
		System.out.println(highestStack(boxes));
		in.close();
	}

}
