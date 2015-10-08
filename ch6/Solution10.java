/** 
 * 
 * Question - Poison
 * Created by Yu Zheng on 10/1/2015 
 * 
 */

public class Solution10 {

	/**
	 * The main idea just use binary representation.
	 * Since we have 1000 bottles, and 10 strips. 
	 * So, we put the number on the bottle 0~999 to represent each bottle.
	 * transfer them into binary number, just 0000000000 ~ 1111101000.
	 * so, for 10 strips, we would drop the soda into spersific strips according
	 * to the number of bottle, for example:
	 * bottle 1 is 0000000001, it would be droped to strip 1;
	 * bottle 3 is 0000000011, it would be droped to strip 1 and 2, and so on.
	 * finally, after we finish all process, we observe the situation of strip,
	 * 1 represent posioned, 0 is not. So, since we have 10 strips, we can got such as
	 * 0000000010, which mean the bottle 2 is posioned. 
	 * So, after 7 days, we can know the result.
	 *
	 */

	// Followed up coding.
	int getresult(ArrayList<Bottle> b, ArrayList<Strip> s) {
		dropstrips(b ,s);
		ArrayList<Integer> result = test(s, 7);
		return setBit(result);
	}

	void dropstrips(ArrayList<Bottle> b, ArrayList<Strip> s) {
		for (Bottle bottle : b) {
			int bottleid = getID();
			int bitIndex = 0;
			while (bottleid > 0) {
				if((bottleid & 1) == 1) {
					t.get(bitIndex).drop(bottle);
				}
				bitIndex++;
				bottleid >>= 1;
			}
		}
	}

	ArrayList<Integer> test(ArrayList<Strip> s, int day) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		for(Strip test : s) {
			int id = test.getID();
			if(test.ispositive(day))
				result.add(id);
		}
		return result;
	} 

	int setBit (ArrayList<Integer> result) {
		int id = 0;
		for(Integer i : result) {
			id |= 1 << i;
		}
		return id;
	}

}