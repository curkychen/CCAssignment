

import java.util.HashMap;
import java.util.Map.Entry;

public class Solution04 {
	public static boolean checkpalinpermutation(String input) {
		input = input.toLowerCase();
		String a = input.replaceAll(" ", "");
		char[] check = a.toCharArray();
		HashMap<Character, Integer> has = new HashMap<Character, Integer>();
		for (int i = 0; i < check.length; i++)
		{
			if (!has.containsKey(check[i])) {
				has.put(check[i], 1);
			}
			else {
				int tem = has.get(check[i]);
				tem++;
				has.put(check[i], tem);
			}
		}
		int oddcount = 0;
		for (Entry<Character, Integer> entry : has.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				oddcount++;
			}
			if (oddcount > 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Tact Coa";
		if (checkpalinpermutation(input))
			System.out.println("It's palindorome permutation");
		else
			System.out.println("It's not a palindorome permutation");
	}

}
