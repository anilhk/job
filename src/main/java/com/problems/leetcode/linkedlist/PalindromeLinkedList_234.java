package com.problems.leetcode.linkedlist;

/**
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * Input: 1->2 
 * Output: false 
 * 
 * Example 2:
 * 
 * Input: 1->2->2->1 
 * Output: true 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 */
public class PalindromeLinkedList_234 {

	// get the middle of the list.
	// assign fast from end to start
	// reverse middle 
	// now compare each element by element if no match return false.
	
    public boolean isPalindrome(ListNode head) {
    	
    	ListNode slowPointer=head;
    	ListNode fastPointer=head;
    	
    	while(fastPointer != null && fastPointer.next != null) {
    		
    		slowPointer = slowPointer.next;
    		fastPointer = fastPointer.next.next;
    		
    	}
    	
    	// this is middle of the list.
    	
    	slowPointer = reverse(slowPointer);
    	fastPointer = head;
    	while(slowPointer != null) {
    		
    		if (fastPointer.val != slowPointer.val) {
    			return false;
    		}
    		
    		fastPointer = fastPointer.next;
    		slowPointer = slowPointer.next;
    	}
    	
    	return true;
    	
    }
    
    
    public ListNode reverse(ListNode node) {
    	
    	ListNode current = null;
		ListNode prev = null;
		ListNode next = null;

		current = node;

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;

    	
    }

}
