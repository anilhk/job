package com.problems.leetcode.linkedlist;

/**
 * 
 * 203. Remove Linked List Elements
 *
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 *        
 * Input: 1->6->6->3->4->5->6, val = 6
 * 
 *  Output: 1->2->3->4->5
 */
public class RemoveLinkListElements_203 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
        	return head;
        }
        
        while(head != null && head.val == val) {
        	head = head.next;
        }
        
    	ListNode temp = head;
    	
    		while(temp != null && temp.next != null) {
    			
    			if (temp.next.val == val) {
                    // just move the pointer forward. 
    				temp.next = temp.next.next;
    			}else {
    				temp = temp.next;
    			}
    			
    		}
    	return head;
    }	
}
