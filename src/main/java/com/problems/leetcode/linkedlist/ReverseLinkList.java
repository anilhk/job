package com.problems.leetcode.linkedlist;

/**
 * 
 * 206. Reverse Linked List
 * 
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 *
 * 
 * 
 */
public class ReverseLinkList {

	public ListNode reverseList(ListNode head) {

		ListNode current = null;
		ListNode prev = null;
		ListNode next = null;

		current = head;

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;

	}
}
