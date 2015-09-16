/**
 *  travel the string, use a count to count how many same character we met, if the 
 *  next character is different, print the count and the character, recount the next
 *  character.
 */
public class Solution06 {
	
	public static String stringcompress(String s) {
		int count = 0;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			count++;
			if ((i + 1) == s.length() || s.charAt(i) != s.charAt(i + 1)) {
				result.append(s.charAt(i));
				result.append(count);
				count = 0;
			}

		}
		if (result.toString().length() < s.length())
			return result.toString();
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "adrrrrr";
		String output = stringcompress(input);
		System.out.println(output);
	}

}
