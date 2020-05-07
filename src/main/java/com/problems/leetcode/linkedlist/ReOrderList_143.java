package com.problems.leetcode.linkedlist;

/**
 * 
 * 143. Reorder List
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3. 
 * 
 * Example 2:
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.å
 *
 */
public class ReOrderList_143 {

	public void reorderList(ListNode head) {

		 if (head == null || head.next == null) {
	            return;
	        }
	        
	        
	        ListNode slow = head;
	        ListNode fast = head;
	        ListNode ptr = null;
	        
	        while(fast != null && fast.next != null) {
	            
	            ptr = slow;
	            fast = fast.next.next;
	            slow = slow.next;

	        }
	        
	        // fast is the end of list l2.
	        // slow is start of list l2
	        
	        // head is start of list l1.
	         //ptr = end of list l1/
	           
	        ptr.next = null;
	        
	        slow = reverse(slow);
	        merge(head,slow);
	        
	        
	    }
	    // 1 2 3 4 5 6 
	   public ListNode merge(ListNode l1, ListNode l2) {
	        
	        ListNode dummy = new ListNode(-1);
	        ListNode head = dummy;
	        
	        while(l1!= null && l2 !=null) {
	            
	            dummy.next = l1;
	            l1 = l1.next;
	            dummy = dummy.next;
	            
	            dummy.next = l2;
	            l2= l2.next;
	            dummy = dummy.next;
	           
	        }
	        
	        if (l1 != null) {
	            dummy.next = l1;
	        }else {
	            dummy.next = l2;
	        }
	       
	       
	        return head.next;
	    }
	    
	    
	    public ListNode reverse(ListNode t1) {
	        
	        ListNode next =null;
	        ListNode current  = t1;
	        ListNode prev = null;
	        
	        while(current != null) {
	            
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        
	        }
	        
	        return prev;
	        
	    }
	
}
