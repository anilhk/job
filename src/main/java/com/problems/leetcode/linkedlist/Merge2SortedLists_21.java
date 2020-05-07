package com.problems.leetcode.linkedlist;

/**
 * 21. Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list.
 * 
 * The new list should be made by splicing together the nodes of the first two
 * lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 
 * Output: 1->1->2->3->4->4
 *
 */
public class Merge2SortedLists_21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode head = dummy;

		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				dummy.next = l1;
				l1 = l1.next;
			} else {
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
