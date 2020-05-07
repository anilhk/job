package com.problems.leetcode.linkedlist;

/**
 * 
 * 148. Sort List
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * Input: 4->2->1->3 
 * Output: 1->2->3->4 Example 2:
 * 
 * Input: -1->5->3->4->0 
 * Output: -1->0->3->4->5
 *
 */
public class SortList_148 {

    public ListNode sortList(ListNode head) {
		
    	// breaking condition // very important 
    	
    	if (head == null || head.next == null) {
    		return head;
    	}
    	
    	ListNode slowPointer = head;
    	ListNode fastPointer = head;
    	ListNode temp = head;
    	
    	while(fastPointer != null && fastPointer.next != null) {
    		
    		temp = slowPointer;
    		slowPointer = slowPointer.next;
    		fastPointer = fastPointer.next.next;
    	
    	}
    	
    	
    	// head is the start of first list 
    	// tmp is the end of first list
    	
    	// slowPointer is the start of secondlist list
    	// fastPointer is the end of sedond list
    	temp.next = null;
    	
    	
    	ListNode left = sortList(head);
    	ListNode right = sortList(slowPointer);
    	
    	return merge(left,right);

    	
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
    	
    	ListNode dummy = new ListNode(0);
    	ListNode  head = dummy;
    	
    	while(l1 != null && l2 != null) {
    		
    		if (l1.val < l2.val) {
    			dummy.next = l1;
    			l1 = l1.next;
    		}else {
    			dummy.next = l2;
    			l2 = l2.next;
    		}
    		dummy = dummy.next;
    	}
    	
    	if (l1 != null) {
    		dummy.next = l1;
    	}
    	
    	if (l2 != null) {
    		dummy.next = l2;
    	}
    
    	return head.next;
    }
	
	
}
