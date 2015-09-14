
/**
* For this problem, I just use the function which the string class has.
* just check the first index number of character is equal to the last 
* index number of character or not, So that we would know the string is
* unique or not.  
*
*/
public class Solution01 {
	
	public static boolean compareUnique(String a) {
		boolean result = true;
		for(int i = 0; i < a.length(); i++) {
			if (a.indexOf(a.charAt(i)) != a.lastIndexOf(a.charAt(i))) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public static void main(String [] args) {
		String a = "zheefng";
		if (compareUnique(a)) {
			System.out.println("It's a Unique");
		}
		else
			System.out.println("It's NOT a unique");
		
	}

}
