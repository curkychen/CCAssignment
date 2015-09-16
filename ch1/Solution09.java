public class Solution09 {

	// if the s2 is the rotate from s1, it must Satisfy s2 is the substring of s1
	public static boolean isrotate (String s1, String s2) {
		if (s1.length() != s2.length())
				return false;
		String newstring = s1 + s1;
		return newstring.contains(s2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcdefg";
		String s2 = "efgabcd";
		System.out.println(s1);
		System.out.println(s2);
		if (isrotate(s1, s2))
			System.out.println("s2 is rotate from s1");
		else
			System.out.println("s2 is not rotated from s1");
	}

}
