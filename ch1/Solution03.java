/**
 *  count how " " it has. And then just compute how big array we need. 
 *  travel the old string, one we met the space, just put the "%20" into it
 */

public class Solution03 {
	public static char[] replacespace(char[] s, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if(s[i] == ' ')
				count++;
		}
		char[] newchar = new char[n + count * 2];
		int newindex = 0;
		for (int i = 0; i < n; i++) {
			if (s[i] != ' ') {
				newchar[newindex++] = s[i];
			}
			else {
				newchar[newindex++] = '%';
				newchar[newindex++] = '2';
				newchar[newindex++] = '0';
			}
		}
		System.out.println(count);	
		return newchar;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] input = "Mr John smith    ".toCharArray();
		char[] output = replacespace(input,13);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
		}		
	}

}
