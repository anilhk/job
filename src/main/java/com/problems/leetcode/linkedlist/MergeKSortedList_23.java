package com.problems.leetcode.linkedlist;

import java.util.PriorityQueue;

/**
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedList_23 {

	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		for (ListNode node : lists) {

			ListNode temp = node;

			while (temp != null) {

				queue.add(temp.val);
				temp = temp.next;
			}

		}

		ListNode dummy = new ListNode(0);
		ListNode head = dummy;

		while (!queue.isEmpty()) {

			int val = queue.poll();
			dummy.next = new ListNode(val);
			dummy = dummy.next;

		}

		return head.next;

	}
}
