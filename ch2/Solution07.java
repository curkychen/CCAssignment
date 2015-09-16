/**
 * create two pointer, travel the two list. if their tails are different,
 * return false.
 * else, compute the how many nodes that the longer list more than shorter list.
 * set two pointer at the start of two list
 * make the longer pointer advance by different length
 * the two pointer travel their own list together until they meet.
 */
public class Solution07 {
	
	public linkedNode findintersection(linkedNode list1, linkedNode list2) {
		// TODO Auto-generated method stub
		if (list1 == null || list2 == null)
			return null;
		int size1 = 1;
		int size2 = 1;
		linkedNode tail1 = list1;
		linkedNode tail2 = list2;
		while (tail1.next != null) {
			tail1 = tail1.next;
			size1++;
		}
		while (tail2.next != null) {
			tail2 = tail2.next;
			size2++;
		}
		
		// if their tails are different, return null
		if(tail1 != tail2)
			return null;
		
		linkedNode longer = size1 < size2 ? list2 : list1;
		linkedNode shorter = size1 < size2 ? list1 : list2;
		
		// longer advance move
		int k =  Math.abs(size1 - size2); 
		while (k > 0 && longer != null) {
			longer = longer.next;
			k--;
		}
		
		// find the intersecting
		while (longer != shorter) {
			longer = longer.next;
			shorter = shorter.next;
		}
		
		return longer;
	}

}
