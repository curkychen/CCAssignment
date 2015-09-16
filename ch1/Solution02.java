import java.util.Arrays;
/**
 *  sort this two string, compare them character by character.
 */
public class Solution02 {
	public static boolean checkpermutation(String a, String b) {
		boolean result = true;
		if (a.length() != b.length())
			return false;
		char[] aarrary = a.toCharArray();
		char[] barrary = b.toCharArray();
		Arrays.sort(aarrary);
		Arrays.sort(barrary);
		if (!Arrays.equals(aarrary, barrary))
			return false;
			
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "zhengyu";
		String b = "zhenguu";
		if (checkpermutation(a, b)) {
			System.out.println("They are permutation for each other");
		}
		else
			System.out.println("They are not permutation for each other");
		
	}

}
