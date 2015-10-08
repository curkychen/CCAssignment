/** 
 * 
 * Question - Draw Line
 * Created by Yu Zheng on 10/1/2015 
 *
 * idea: This question just let us draw a line from (x1, y) to (x2, y)
 * The sample way to do it just iterate from x1 to x2, draw each pixel 
 * on the path. 
 * The book give us a better way to do it. just use mask.
 * because if x1 and x2 are far away from each other, there are serval 
 * pixel we can just use screen[byte_pos] = Oxff to represent them.
 * 
 */

public class Solution08 {
	public static void drawLIne(byte[] screen, int width, int x1, int x2, int y) {
		int start_offset = x1 % 8;
		int first_full_byte = x1 / 8;
		if(start_offset != 0)
			first_full_byte++;

		int end_offset = x2 % 8;
		int last_full_byte = x2 / 8;
		if(end_offset != 7)
			last_full_byte--;

		// if x1 and x2 far from each other, we can set full byte in here
		for (int i = 0; i < first_full_byte; i++)
			screen[(width / 8) * y + i] = (byte)0xFF;

		byte start_mask = (byte) (0xFF >> start_mask);
		byte end_mask = (byte) ~(0xFF >> (end_offset + 1));

		// set start and end of line
		if((x1 / 8) == (x2) / 8) {
			byte mask = (byte) (start_mask & end_mask);
			screen[(width / 8) * y + (x1 / 8)] != mask;
		} else {
			if(start_offset != 0) {
				int byte_number = (width/8)*y+first_full_byte-1;
				screen[byte_number] |= start_mask;
			}

			if(end_offset != 7) {
				int byte_number = (width/8)*y+last_full_byte+1;
				screen[byte_number] |= end_mask;
			}
		}

	}
}