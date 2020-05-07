package com.problems.leetcode.linkedlist;

/**
 * 
 * 83. Remove Duplicates from Sorted List
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * Input: 1->1->2 
 * 
 * Output: 1->2 
 * 
 * 
 * Example 2:
 * 
 * Input: 1->1->2->3->3 
 * 
 * Output: 1->2->3
 *
 */
public class RemoveDuplicatesFromSortedList_83 {

    public ListNode deleteDuplicates(ListNode head) {

    	if (head == null) {
    		return head;
    	}
    	
    	
    	while(head != null && head.next != null && head.val == head.next.val) {
    		head = head.next;
    	}
    	
    	ListNode temp = head;
    	while(temp != null && temp.next != null) {
    		
    		if (temp.val == temp.next.val) {
    			temp.next = temp.next.next;
    		}else {
    			temp = temp.next;
    		}
    	}
    	return head;
    }
}
