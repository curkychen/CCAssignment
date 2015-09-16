

/**
* In this problem, we would consider divide the problem into three parts,
* if the length of two strings is same, if the length of string 1 is more than string 2,
* and if the length of string 1 is less than string 2
*/
public class Solution05 {
	
	public static boolean Oneaway(String s1, String s2) {
		// remove a character
		// and replace a character
		if (s1.length() - s2.length() == 1 || s1.length() == s2.length()) {
			int diffcount = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (s2.indexOf(s1.charAt(i)) == -1) {
					diffcount++;
				}
			}
			if (diffcount == 1)
				return true;
			else
				return false;
		} // insert a character
		else if (s2.length() - s1.length() == 1) {
			int diffcount = 0;
			for (int i = 0; i < s2.length(); i++) {
				if (s1.indexOf(s2.charAt(i)) == -1) {
					diffcount++;
				}
			}
			if (diffcount == 1)
				return true;
			else
				return false;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "pale";
		String b = "bake";
		if (Oneaway(a,b))
			System.out.println("True");
		else
			System.out.println("Fasle");
	}

}
