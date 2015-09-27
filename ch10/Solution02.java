import java.util.HashMap;
import java.util.LinkedList;
import java.util.Arrays;
/** 
 * 
 * Question - Group Anagrams
 * Created by Yu Zheng on 9/25/2015 
 *
 * idea: Abuot the anagrams, we can just use sort function to sort each string,
 * so they would has same order that we can put them together. put them into a Hashmap
 * and we can easily sort the other string.
 * 
 */

public class Solution02 {
	public static boolean compareString(String a, String b) {
		if(a.length != b.length)
			return false;
		char[] arrayb = b.toCharArray();
		Arrays.sort(arrayb);
		Strig newStringb = new String(arrayb);
		if(!a.equals(newStringb))
			return false;
		return true;
	}

	public static String[] groupAngrams(String[] a) {
		HashMap<String, LinkedList<String>> mapLinkSting = new HashMap<LinkedList<String>>();
		String[] result = new String[a.length];
		for(int i = 0; i < a.length; i++) {
			char[] arraya = a[i].toCharArray();
			Arrays.sort(arraya);
			String newastring = new String(arraya);
			if(mapLinkSting.containsKey(newastring))
				mapLinkSting.get(newastring).add(a[i]);
			else {
				LinkedList<String> newlinklist = new LinkedList<String>();
				newlinklist.add(a[i]);
				mapLinkSting.put(newastring, newlinklist);
			}
		}

		int count = 0;
		for(String t : mapLinkSting.keySet()) {
			LinkedList<String> getstringlink mapLinkSting.get(t);
			for(int i = 0; i< getstringlink.size(); i++) {
				result[count++] = getstringlink.get(i);
			} 
		}
		return result;
	}

	public static void main(String[] args) {
		
	}

}
