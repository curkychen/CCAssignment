/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) 
            return;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        ListNode l1 = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode l2 = rever(slow);
        
        merge(l1, l2);
    }
    
    public ListNode rever(ListNode l) {
        ListNode c = l;
        ListNode p = null;
        ListNode n = null;
        while(c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

    public void merge(ListNode l1, ListNode l2) {
        while(l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if(n1 == null)
                break;
            
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}